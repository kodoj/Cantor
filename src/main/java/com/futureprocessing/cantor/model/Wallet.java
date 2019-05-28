package com.futureprocessing.cantor.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wallet_id")
    private int wallet_id;
    @Column(name = "usd")
    private BigDecimal USD;
    @Column(name = "eur")
    private BigDecimal EUR;
    @Column(name = "chf")
    private BigDecimal CHF;
    @Column(name = "rub")
    private BigDecimal RUB;
    @Column(name = "czk")
    private BigDecimal CZK;
    @Column(name = "gbp")
    private BigDecimal GBP;
    @Column(name = "pln")
    private BigDecimal PLN;

    public Wallet() {
    }

    public int getWallet_id() {
        return wallet_id;
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
