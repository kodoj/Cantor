package com.futureprocessing.cantor.model;

import com.futureprocessing.cantor.constraint.FieldMatch;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class UserRegistrationDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    private double usd;

    private double eur;

    private double chf;

    private double rub;

    private double czk;

    private double gbp;

    private double pln;

    @AssertTrue
    private Boolean terms;

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public double getUsd() {
        return usd;
    }

    public double getEur() {
        return eur;
    }

    public double getChf() {
        return chf;
    }

    public double getRub() {
        return rub;
    }

    public double getCzk() {
        return czk;
    }

    public double getGbp() {
        return gbp;
    }

    public double getPln() {
        return pln;
    }
}
