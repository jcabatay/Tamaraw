package com.ascii274.login.entitydto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class UserResponseDto {

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("last_name")
    private final String lastName;

    @JsonProperty("mail_mobile")
    private final String mailMobile;

    @JsonProperty("password")
    private final String password;

    @JsonProperty("Date_Signup")
    private final LocalDateTime dateSignUp= LocalDateTime.now();



}
