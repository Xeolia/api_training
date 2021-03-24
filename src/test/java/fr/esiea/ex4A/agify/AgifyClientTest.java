package fr.esiea.ex4A.agify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyClientTest {

    @Test
    void userList() throws IOException {
        AgifyClient agifyClient = new Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
            .create(AgifyClient.class);

        Call<AgifyUser> agifyUserCall = agifyClient.userList("Alexia","US");
        AgifyUser agifyUser = agifyUserCall.execute().body();
        Assertions.assertEquals("Alexia", agifyUser.name);
        Assertions.assertEquals(47, agifyUser.age);
        Assertions.assertEquals(6, agifyUser.count);
        Assertions.assertEquals("US", agifyUser.country_id);
    }
}
