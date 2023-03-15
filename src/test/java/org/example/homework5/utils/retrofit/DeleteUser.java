package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface DeleteUser {

    @DELETE("Account/v1/User/{UUID}")
    Call<String> deleteUser(@Path("UUID") String UUID, @Header("authorization") String token);
}
