package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BooksPOST {

    @Headers({"accept:application/json", "Content-Type: application/json"})
    @POST("BookStore/v1/Books")
    Call<Books> addIsbn(@Body BookBodyPost body,
                        @Header("authorization") String basic);
}
