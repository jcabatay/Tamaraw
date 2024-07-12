package com.ascii274.login.entitydto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

@Table(name = "users")
public class User {

//    @ConstructorProperties({"name"})

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
    private String dateSignUp=setFormatStringDate();


    private String setFormatStringDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        return now.format(formatter);
    }
}
