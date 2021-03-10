package fr.esiea.ex4A;

import java.util.HashMap;
import java.util.Map;

public class User {

    private final String userEmail;
    private final String userName;
    private final String userTweeter;
    private final String userCountry;
    private final String userSex;
    private final String userSexPref;

    public User(String userEmail, String userName, String userTweeter, String userCountry, String userSex, String userSexPref) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }


    public String getUserTweeter() {
        return userTweeter;
    }



    public String getUserCountry() {
        return userCountry;
    }

    public String getUserSex() {
        return userSex;
    }


    public String getUserSexPref() {
        return userSexPref;
    }


    public enum UserSex {

        M("M"),
        F("F"),
        O("O");
        private final String value;
        private final static Map<String, User.UserSex> CONSTANTS = new HashMap<String, User.UserSex>();

        static {
            for (User.UserSex c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private UserSex(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static User.UserSex fromValue(String value) {
            User.UserSex constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum UserSexPref {

        M("M"),
        F("F"),
        O("O");
        private final String value;
        private final static Map<String, User.UserSexPref> CONSTANTS = new HashMap<String, User.UserSexPref>();

        static {
            for (User.UserSexPref c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private UserSexPref(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }

        public static User.UserSexPref fromValue(String value) {
            User.UserSexPref constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

