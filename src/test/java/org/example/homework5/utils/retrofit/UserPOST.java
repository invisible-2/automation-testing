package org.example.homework5.utils.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserPOST {

    @FormUrlEncoded
    @POST("Account/v1/User")
    Call<CreatedUser> createUser(@Field("userName") String userName,
                                 @Field("password") String password);
}
