package com.ascii274.login.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    public User(String userName){
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;

    @Column(name="user_id")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="user_name")
    private String userName;


    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="mail")
    private String mail;


}
