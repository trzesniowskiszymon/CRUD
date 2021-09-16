package com.example.demo;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKlienta;
    private String imie;
    private String nazwisko;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderNumber orderNumber;

    public Client(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Client() {
    }

    public OrderNumber getZamowienie() {
        return orderNumber;
    }

    public void setNumerZamowienia(OrderNumber obiektZamowienia) {
        this.orderNumber = obiektZamowienia;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
