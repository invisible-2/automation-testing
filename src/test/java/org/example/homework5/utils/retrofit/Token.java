package org.example.homework5.utils.retrofit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Token {

    private String token;
    private String expires;
    private String status;
    private String result;
}
