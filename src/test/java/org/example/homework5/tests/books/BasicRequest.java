package org.example.homework5.tests.books;

import com.google.gson.Gson;
import org.example.homework5.utils.Base64EncodingDecoding;
import org.example.homework5.utils.retrofit.Book;
import org.example.homework5.utils.retrofit.CreatedUser;
import org.example.homework5.utils.retrofit.DemoqaUser;
import org.example.homework5.utils.retrofit.UserAndBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicRequest {
    private Logger logger = LoggerFactory.getLogger(BasicRequest.class);
    protected static final String BASE_URL = "https://demoqa.com/";
    protected final static String USER_NAME = "anatolie2";
    protected final static String NEW_USER_NAME = USER_NAME + "3";
    protected final static String PASSWORD = "Demoqa$1232";

    protected final static String BASIC_AUTHORIZATION = Base64EncodingDecoding.encode(USER_NAME + ":" + PASSWORD);
    protected final static Gson gson = new Gson();
    protected final static List<String> isbnAddList = new ArrayList<String>(){{add("9781593277574"); add("9781593275846");}};
    protected final static String editIsdn = "9781491904244";
    protected String userId;
    protected String token;
    protected DemoqaUser user;
    protected UserAndBooks userAndBooks;

    protected CreatedUser createdUser;

    protected void checkAddedIsdn(List<String> isbnAddList) throws IOException {
        if (userAndBooks == null) {
            getUserByUserIdGET();
        }
        if (userAndBooks == null || userAndBooks.getBooks().isEmpty()) {
            Assert.fail("userAndBooks is null");
        }
        for (String isbn : isbnAddList) {
            boolean isIsbnInclude = false;
            for (Book book: userAndBooks.getBooks()) {
                if (book.getIsBn().equalsIgnoreCase(isbn)) {
                    logger.info("isbn [{}] exists in user's book list, userName [{}]", isbn, user.getUsername());
                    isIsbnInclude = true;
                    break;
                }
                else {
                    logger.info("book isdn [{}] != checkedIsdn [{}]", book.getIsBn(), isbn);
                }
            }
            Assert.assertTrue(isIsbnInclude, "Added isdn does not included in user books list");
        }
    }

    protected void checkDeletedIsdn(String deletedIsbn) throws IOException {
        if (userAndBooks == null) {
            getUserByUserIdGET();
        }
        if (userAndBooks == null || userAndBooks.getBooks().isEmpty()) {
            Assert.fail("userAndBooks is null");
        }
        for (Book book: userAndBooks.getBooks()) {
            if (book.getIsBn().equalsIgnoreCase(deletedIsbn)) {
                logger.info("deletedIsbn [{}] exists in user's book list, userName [{}]", deletedIsbn, user.getUsername());
                Assert.fail("deletedIsbn [" + deletedIsbn + "] presents in user's book list");
            }
        }
    }

    public abstract void getUserByUserIdGET() throws IOException;
    public abstract void LoginPOST() throws IOException;

    protected void checkUserId() throws IOException {
        if (userId == null) {
            LoginPOST();
        }
        if (userId == null) {
            Assert.fail("User is null");
        }
        logger.info("userId [{}], token [{}]", userId, token);
    }
}
