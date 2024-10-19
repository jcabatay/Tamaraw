package com.ascii274.login.entitydto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class UserSearchDto {



    @JsonProperty("name")
    private final String name;

    @JsonProperty("last_name")
    private final String lastName;

    @JsonProperty("mail_mobile")
    private final String mailMobile;


    @JsonProperty("Date_Signup")
    private final String dateSignUp = setFormatStringDate();

    private String setFormatStringDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        return now.format(formatter);
    }

}
