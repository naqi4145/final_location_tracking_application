package com.upwork.location.apis.modles;

import java.util.List;


public class LoginModel {
    public int result;
    public String id;
    public boolean auth;
    public User user;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User {
        public List<Object> equipments;
        public List<Object> works;
        public List<Object> favoriteWorks;
        public List<Object> favoriteEquips;
        public String _id;
        public String email;
        public String password;
        public String userUrl;
        public int __v;

        public List<Object> getEquipments() {
            return equipments;
        }

        public void setEquipments(List<Object> equipments) {
            this.equipments = equipments;
        }

        public List<Object> getWorks() {
            return works;
        }

        public void setWorks(List<Object> works) {
            this.works = works;
        }

        public List<Object> getFavoriteWorks() {
            return favoriteWorks;
        }

        public void setFavoriteWorks(List<Object> favoriteWorks) {
            this.favoriteWorks = favoriteWorks;
        }

        public List<Object> getFavoriteEquips() {
            return favoriteEquips;
        }

        public void setFavoriteEquips(List<Object> favoriteEquips) {
            this.favoriteEquips = favoriteEquips;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserUrl() {
            return userUrl;
        }

        public void setUserUrl(String userUrl) {
            this.userUrl = userUrl;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }
    }

}
