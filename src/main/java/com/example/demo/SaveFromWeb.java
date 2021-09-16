package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class SaveFromWeb {
    private ClientRepo clientRepo;
    private OrderNumberRepo orderNumberRepo;
    @Autowired
    public SaveFromWeb (ClientRepo clientRepo1, OrderNumberRepo orderNumberRepo1) {
        this.clientRepo = clientRepo1;
        this.orderNumberRepo = orderNumberRepo1;
    }
    @RequestMapping("/save")
    public String dodajemyDane(
            @RequestParam("imie") String imie, @RequestParam("nazwisko") String nazwisko,
            @RequestParam("nrZamowienia") String nrZamowienia)  throws Exception
    {
        Client klient = new Client(imie, nazwisko);
        OrderNumber orderNumber = new OrderNumber(nrZamowienia);
        klient.setNumerZamowienia(orderNumber);

        orderNumberRepo.save(orderNumber);
        clientRepo.save(klient);


        return "osoba: "+klient+", nrZamowienia="+nrZamowienia;
    } }

