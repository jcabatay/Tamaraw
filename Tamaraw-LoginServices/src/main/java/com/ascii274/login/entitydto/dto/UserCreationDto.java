package com.ascii274.login.entitydto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class UserCreationDto {

//    @JsonProperty("id")
//    private final Long id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("last_name")
    private final String lastName;

    @JsonProperty("mail_mobile")
    private final String mailMobile;

    @JsonProperty("password")
    private final String password;


    @JsonProperty("Date_Signup")
    private final String dateSignUp = setFormatStringDate();

    private String setFormatStringDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        return now.format(formatter);
    }


}
