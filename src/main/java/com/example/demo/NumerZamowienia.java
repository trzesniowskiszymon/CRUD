package com.example.demo;
import javax.persistence.*;

@Entity
public class NumerZamowienia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZamowienia;
    private String numerZamowienia;

    public NumerZamowienia(String numerZamowienia) {
        this.numerZamowienia = numerZamowienia;
    }

    public NumerZamowienia() {
    }

    public String getNumerZamowienia() {
        return numerZamowienia;
    }

    public void setNumerTelefonu(String numerZamowienia) {
        this.numerZamowienia = numerZamowienia;
    }
}