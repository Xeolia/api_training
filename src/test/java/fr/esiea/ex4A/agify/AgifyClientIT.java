package fr.esiea.ex4A.agify;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyClientIT {
    @ParameterizedTest
    @CsvSource({
        "Alexia,US",
        "Tanguy,FR",
        "Britney,US"
    })

    void agifyService_testIT(String name, String country){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        AgifyClient agifyClient = retrofit.create(AgifyClient.class);

        try {
            Response<AgifyUser> execute = agifyClient.userList(name, country).execute();
            AgifyUser agifyUser = execute.body();
            if(agifyUser == null){
                fail();
                return;
            }
            assertEquals(agifyUser.name, name);
            assertEquals(agifyUser.country_id, country);
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}
