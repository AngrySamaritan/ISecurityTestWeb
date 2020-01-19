package com.ibadsamaritan.examination.isecuritytest.model;

import com.ibadsamaritan.examination.isecuritytest.validators.PasswordMatches;
import com.ibadsamaritan.examination.isecuritytest.validators.UniqueEmail;
import com.ibadsamaritan.examination.isecuritytest.validators.ValidEmail;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    // TODO: Unique username
    private String username;

    @NotNull
    @NotEmpty
    @ValidEmail
    @UniqueEmail
    private String email;


    private String password;

    private String matchingPassword;

    private String firstName;

    private String lastName;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
