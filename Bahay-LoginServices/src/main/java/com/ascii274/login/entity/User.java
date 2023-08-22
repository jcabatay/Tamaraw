package com.ascii274.login.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    public User(String userName){
        this.userName = userName;
    }

    private Long id;

    private String userId;

    private String password;

    private String userName;


    private String firstName;

    private String lastName;

    private String mail;


}
