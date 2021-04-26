package com.upwork.location.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.upwork.location.MainActivity;
import com.upwork.location.R;
import com.upwork.location.apis.ApiClient;
import com.upwork.location.apis.Constants;
import com.upwork.location.apis.intercaces.LoginInterface;
import com.upwork.location.apis.modles.LoginModel;

import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginForm extends AppCompatActivity {

    EditText email, password;
    Button signIn;
    String strEmail, strPass;

    Call<LoginModel> loginModelCall;
    LoginModel loginModel;
    List<LoginModel.User> userList;
    boolean isLogged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        Paper.init(this);
        isLogged = Paper.book().read(Constants.LOGGED, false);
        if (isLogged) {

            startActivity(new Intent(LoginForm.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finishAffinity();
        }

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.btnSignIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strEmail = email.getText().toString();
                strPass = password.getText().toString();
                LoginInterface loginInterface = ApiClient.getClient().create(LoginInterface.class);
                loginModelCall = loginInterface.UserLogIn(strEmail, strPass);
                loginModelCall.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        if (response.isSuccessful()) {
                            if (response.code() == 200) {
                                loginModel = response.body();
                                if (response.body().isAuth()){
                                    Paper.book().write(Constants.TOKEN, "bearer " + response.body().getUser().get_id());
                                    Paper.book().write(Constants.LOGGED, true);
                                    Toast.makeText(getApplicationContext(), "Login !", Toast.LENGTH_LONG).show();
                                    Log.d("User_ID", response.body().getUser().get_id());
                                    Intent i = new Intent(LoginForm.this, MainActivity.class);
                                    i.putExtra("User_ID", response.body().getUser().get_id());
                                    startActivity(i);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Auth Fail", Toast.LENGTH_LONG).show();
                                }
                            }
                        } else {
                            if (response.code() == 401) {
                                Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}