package com.futureprocessing.cantor.model;

import com.futureprocessing.cantor.constraint.FieldMatch;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

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

    private BigDecimal USD;

    private BigDecimal EUR;

    private BigDecimal CHF;

    private BigDecimal RUB;

    private BigDecimal CZK;

    private BigDecimal GBP;

    private BigDecimal PLN;

    @AssertTrue
    private Boolean terms;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

    public BigDecimal getUSD() {
        return USD;
    }

    public void setUSD(BigDecimal USD) {
        this.USD = USD;
    }

    public BigDecimal getEUR() {
        return EUR;
    }

    public void setEUR(BigDecimal EUR) {
        this.EUR = EUR;
    }

    public BigDecimal getCHF() {
        return CHF;
    }

    public void setCHF(BigDecimal CHF) {
        this.CHF = CHF;
    }

    public BigDecimal getRUB() {
        return RUB;
    }

    public void setRUB(BigDecimal RUB) {
        this.RUB = RUB;
    }

    public BigDecimal getCZK() {
        return CZK;
    }

    public void setCZK(BigDecimal CZK) {
        this.CZK = CZK;
    }

    public BigDecimal getGBP() {
        return GBP;
    }

    public void setGBP(BigDecimal GBP) {
        this.GBP = GBP;
    }

    public BigDecimal getPLN() {
        return PLN;
    }

    public void setPLN(BigDecimal PLN) {
        this.PLN = PLN;
    }
}
