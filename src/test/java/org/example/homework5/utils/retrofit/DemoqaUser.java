package org.example.homework5.utils.retrofit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DemoqaUser extends SimpleUser{

    private String password;
    private String token;
    private String expires;
    private String created_date;
    private Boolean isActive;
}
