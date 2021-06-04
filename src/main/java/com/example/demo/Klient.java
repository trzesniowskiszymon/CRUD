package com.example.demo;

import com.example.demo.NumerZamowienia;

import javax.persistence.*;

@Entity
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKlienta;
    private String imie;
    private String nazwisko;

    @OneToOne(cascade = CascadeType.ALL)
    private NumerZamowienia numerZamowienia;

    public Klient(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Klient() {
    }

    public NumerZamowienia getZamowienie() {
        return numerZamowienia;
    }

    public void setNumerZamowienia(NumerZamowienia obiektZamowienia) {
        this.numerZamowienia = obiektZamowienia;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
