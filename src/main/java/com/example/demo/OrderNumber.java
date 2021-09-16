package com.example.demo;
import javax.persistence.*;

@Entity
public class OrderNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZamowienia;
    private String numerZamowienia;

    public OrderNumber(String numerZamowienia) {
        this.numerZamowienia = numerZamowienia;
    }

    public OrderNumber() {
    }

    public String getNumerZamowienia() {
        return numerZamowienia;
    }

    public void setNumerTelefonu(String numerZamowienia) {
        this.numerZamowienia = numerZamowienia;
    }
}