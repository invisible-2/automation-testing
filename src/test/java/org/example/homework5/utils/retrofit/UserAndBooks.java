package org.example.homework5.utils.retrofit;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserAndBooks extends SimpleUser{

    @Getter
    @Setter
    private List<Book> books;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        for (Book book : books) {
            sb.append(book);
        }
        return sb.toString();
    }
}
