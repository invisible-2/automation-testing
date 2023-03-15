package org.example.homework5.tests.books;

import com.google.gson.Gson;
import org.example.homework5.utils.Base64EncodingDecoding;
import org.example.homework5.utils.retrofit.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RetrofitRequest extends BasicRequest{
    private Retrofit retrofit = new Retrofit.Builder().baseUrl("https://demoqa.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Logger logger = Logger.getLogger(RetrofitRequest.class);

    public DemoqaUser Login(String userName, String password) throws IOException {
        logger.info("Start Login |  userName[" + userName + "], password [" +password + "]");
        Assert.assertNotNull(userName, "userName is null");
        Assert.assertNotNull(password, "password is null");
        LoginService service = retrofit.create(LoginService.class);
        Call<DemoqaUser> authCall = service.login(userName, password);

        try {
            Response response = authCall.execute();
            int statusCode = response.code();
            return (DemoqaUser) response.body();
        } catch (IOException e) {
            //logger.error("Login failed, message [{}]", e.getMessage());
        }
        return null;
    }

    @Test(groups = {"g1"})
    public void LoginPOST() throws IOException {
        logger.info("Start LoginPost");

        DemoqaUser loginUser = Login("daniel2", "D@niel2003");
        System.out.println(loginUser.getToken());

        logger.info("Stop LoginPost");
    }

    @Test
    public void getUserByUserIdGET() throws IOException {
        logger.info("Start getUserByUserIdGET");
        LoginPOST();

        GetUser service = retrofit.create(GetUser.class);
        Call<UserAndBooks> authCall = service.getUserByUserId(userId, "Bearer " + token);

        System.out.println(authCall.execute().body());

        logger.info("Stop getUserByUserIdGET");
    }

    public void createUserPOST() {
        logger.info("Start userPost");
        UserPOST service = retrofit.create(UserPOST.class);
        Call<CreatedUser> authCall = service.createUser(NEW_USER_NAME, PASSWORD);


        logger.info("Stop userPost");
    }

    public void deleteUserDELETE() throws IOException {
        logger.info("Start deleteUserDELETE");
        DeleteUser service = retrofit.create(DeleteUser.class);
        String userId;
        if (createdUser == null || createdUser.getUserID() == null || createdUser.getUserID().equalsIgnoreCase("")) {
            DemoqaUser user =   Login(NEW_USER_NAME, PASSWORD);
            userId = user.getUserId();
        }
        else {
            userId = createdUser.getUserID();
        }
        Call<?> authCall = service.deleteUser(userId, "Basic " + Base64EncodingDecoding.encode(NEW_USER_NAME + ":" + PASSWORD));


        logger.info("Stop deleteUserDELETE");
    }

    @Test(groups = {"g2"})
    public void authorizedPOST() {
        logger.info("Start authorizedTest");
        Authorized service = retrofit.create(Authorized.class);
        Call<Boolean> authCall = service.authorized(USER_NAME, PASSWORD);


        logger.info("Stop authorizedTest");
    }


    public void addIsbnPOST() throws IOException {
        logger.info("Start addIsbnPost");
        checkUserId();
        BooksPOST service = retrofit.create(BooksPOST.class);
        BookBodyPost bookBodyPost = new BookBodyPost();

        List<Map<String, String>> isbnList = new ArrayList<Map<String, String>>(){{
            add(new HashMap<String, String>(){{put("isbn", isbnAddList.get(0));}});
            add(new HashMap<String, String>(){{put("isbn", isbnAddList.get(1));}});
        }};
        bookBodyPost.setCollectionOfIsbns(isbnList);
        bookBodyPost.setUserId(user.getUserId());
        Call<Books> authCall = service.addIsbn(bookBodyPost, "Basic " + BASIC_AUTHORIZATION);

        logger.info("Stop addIsbnPost");
    }


    public void gettingBooksGET() {
        logger.info("Start testGettingBooks");
        BookService service = retrofit.create(BookService.class);
        Call<Books> booksCall  = service.getBooks();
        Gson gson = new Gson();

        logger.info("Stop testGettingBooks");
    }


    public void deleteBooksDELETE() throws IOException {
        logger.info("Start deleteBooksDELETE");
        BooksDELETE service = retrofit.create(BooksDELETE.class);
        if (userId == null) {
            LoginPOST();
        }
        if (userId == null) {
            Assert.fail("User is null");
        }
        Call<?> authCall = service.deleteBooks(userId, "Bearer " + token);
        logger.info("Stop deleteBooksDELETE");
    }

    public void getBookGET() {
        logger.info("Start getBookGET");
        BookGET service = retrofit.create(BookGET.class);
        Call<Book> booksCall  = service.getBookByIsdn(isbnAddList.get(0), "Basic " + BASIC_AUTHORIZATION);


        logger.info("Stop getBookGET");
    }

}
