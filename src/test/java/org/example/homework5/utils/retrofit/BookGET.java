package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BookGET {

    @GET("BookStore/v1/Book")
    Call<Book> getBookByIsdn(@Query("ISBN") String ISBN,
                             @Header("authorization") String basic);
}
