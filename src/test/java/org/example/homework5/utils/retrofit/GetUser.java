package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GetUser {

    @GET("Account/v1/User/{UUID}")
    Call<UserAndBooks> getUserByUserId(@Path("UUID") String UUID,
                                       @Header("authorization") String token);
}
