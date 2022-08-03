package com.example.testtaskmc.model.Dto;

import com.example.testtaskmc.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Schema(description = "Entity for validate user in post-request")
public class UserDto {

    @NotEmpty(message = "The name of user is required.")
    @Size(min = 2, max = 30, message = "The length of firstname must be between 2 and 30 characters.")
    private String name;

    @NotEmpty (message = "The lastname of user is required.")
    @Size(min = 2, max = 30, message = "The length of lastname must be between 2 and 30 characters.")
    private String lastname;

    @NotNull(message = "The age of user is required.")
    @Positive(message = "The age must be greater then 0.")
    private int age;

    public User toUser(){
        User user = new User();
        user.setName(name);
        user.setLastname(lastname);
        user.setAge(age);
        return user;
    }

    public UserDto(String firstname, String lastname, int age) {
        this.name = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
