package fr.esiea.ex4A.agify;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyUser> userList(@Query("name") String username, @Query("country_id") String country);

}
