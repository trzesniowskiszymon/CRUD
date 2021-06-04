package com.example.demo;
import com.example.demo.Klient;
import com.example.demo.KlientRepo;
import com.example.demo.NrZamowieniaRepo;
import com.example.demo.NumerZamowienia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class SaveFromWeb {
    private KlientRepo klientRepo;
    private NrZamowieniaRepo nrZamowieniaRepo;
    @Autowired
    public SaveFromWeb (KlientRepo klientRepo1, NrZamowieniaRepo nrZamowieniaRepo1) {
        this.klientRepo = klientRepo1;
        this.nrZamowieniaRepo = nrZamowieniaRepo1;
    }
    @RequestMapping("/save")
    public String dodajemyDane(
            @RequestParam("imie") String imie, @RequestParam("nazwisko") String nazwisko,
            @RequestParam("nrZamowienia") String nrZamowienia)  throws Exception
    {
        Klient klient = new Klient(imie, nazwisko);
        NumerZamowienia numerZamowienia = new NumerZamowienia(nrZamowienia);
        klient.setNumerZamowienia(numerZamowienia);

        nrZamowieniaRepo.save(numerZamowienia);
        klientRepo.save(klient);


        return "osoba: "+klient+", nrZamowienia="+nrZamowienia;
    } }

