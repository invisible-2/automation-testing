package org.example.homework5.utils.retrofit;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Books {

    @Getter
    @Setter
    @SerializedName("books")
    private List<Book> books;

    public boolean arePresent() {
        return !books.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!books.isEmpty()) {
            int index = 0;
            for (Book book : books) {
                builder.append("index [").append(index).append("], ").append(book.toString());
                index++;
            }
        }
        return builder.toString();
    }
}
