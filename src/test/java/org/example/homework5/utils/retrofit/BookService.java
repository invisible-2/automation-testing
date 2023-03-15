package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookService {

    @GET("BookStore/v1/Books")
    Call<Books> getBooks();
}
