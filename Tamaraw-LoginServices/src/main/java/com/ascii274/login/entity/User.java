package com.ascii274.login.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

@Table(name = "users")
public class User {

    @ConstructorProperties({"name"})
    public User(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @OrderColumn

    @Column(name="id")
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    @Column(name="name")
    private String name;

    @NotNull
    @Size(min=3, max=100)
    @Column(name="last_name")
    private String lastName;

    @Column(name="mail_mobile")
    private String mailMobile;

    @Column(name="password")
    private String password;

    @Column(name="date_signup")
    private LocalDateTime dateSignUp;



//    @Column(name="first_name")
//    private String firstName;
//
//    @Column(name="last_name")
//    private String lastName;






}
