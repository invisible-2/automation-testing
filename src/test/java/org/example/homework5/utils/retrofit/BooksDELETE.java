package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BooksDELETE {

    @DELETE("BookStore/v1/Books")
    Call<String> deleteBooks(@Query("UserId") String userId,
                             @Header("authorization") String token);
}
