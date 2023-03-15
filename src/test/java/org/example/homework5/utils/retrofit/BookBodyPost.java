package org.example.homework5.utils.retrofit;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class BookBodyPost {

    public String userId;
    public List<Map<String, String>> collectionOfIsbns;
}
