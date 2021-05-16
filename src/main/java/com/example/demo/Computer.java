package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name="SpisKomputerow")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marka;
    private String model;
    private String procesor;
    private String kartaGraficzna;
    @Column(length = 2048)
    private String opis;
    @Transient
    boolean nowy;

    public Computer(String marka, String model, String procesor, String kartaGraficzna, String opis, boolean nowy) {
        this.marka = marka;
        this.model = model;
        this.procesor = procesor;
        this.kartaGraficzna = kartaGraficzna;
        this.opis = opis;
        this.nowy = nowy;
    }

    public Computer(Integer id, String marka, String model, String procesor, String kartaGraficzna, String opis, boolean nowy) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.procesor = procesor;
        this.kartaGraficzna = kartaGraficzna;
        this.opis = opis;
        this.nowy = nowy;
    }

    public Computer(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getKartaGraficzna() {
        return kartaGraficzna;
    }

    public void setKartaGraficzna(String kartaGraficzna) {
        this.kartaGraficzna = kartaGraficzna;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", procesor='" + procesor + '\'' +
                ", kartaGraficzna='" + kartaGraficzna + '\'' +
                ", opis='" + opis + '\'' +
                ", nowy=" + nowy +
                '}';
    }
}