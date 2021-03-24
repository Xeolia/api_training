package fr.esiea.ex4A;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class User {

    public final String userEmail;
    public final String userName;
    public final String userTweeter;
    public final String userCountry;
    public final String userSex;
    public final String userSexPref;

    public User(@JsonProperty("userEmail") String userEmail, @JsonProperty("userName")  String userName,
                @JsonProperty("userTweeter") String userTweeter, @JsonProperty("userCountry")  String userCountry,
                @JsonProperty("userSex") String userSex, @JsonProperty("userSexPref")  String userSexPref) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
    }

}

