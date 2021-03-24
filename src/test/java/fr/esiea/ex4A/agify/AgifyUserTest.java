package fr.esiea.ex4A.agify;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esiea.ex4A.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyUserTest {
    AgifyUser agifyUserTest() throws IOException {
        AgifyClient agifyClient = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> agifyUserCall = agifyClient.userList("Alexia", "US");
        AgifyUser agifyUser = agifyUserCall.execute().body();
        return agifyUser;
    }
    @ParameterizedTest
    @ValueSource(strings = {"{\"userEmail\":\"serrier@et.esiea.fr\",\"userName\":\"Alexia\",\"userTweeter\":\"Xeolia\",\"userCountry\":\"US\",\"userSex\":\"F\",\"userSexPref\":\"H\"}"
    })
    void user_from_Json_test(String json) {
            try {
                User user = new ObjectMapper().readValue(json, User.class);
                System.out.println(user.toString());
                Assertions.assertTrue(json.contains(user.userCountry));
                Assertions.assertTrue(json.contains(user.userEmail));
                Assertions.assertTrue(json.contains(user.userName));
                Assertions.assertTrue(json.contains(user.userTweeter));
                Assertions.assertTrue(json.contains(user.userSex));
                Assertions.assertTrue(json.contains(user.userSexPref));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                Assertions.fail();
            }
    }
}
