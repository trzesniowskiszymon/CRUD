package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddControler {
    private CompRepo compRepo;

    @Autowired
    public AddControler(CompRepo compRepo) {
        this.compRepo = compRepo;
    }

    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("marka") String marka,
            @RequestParam("model") String model,
            @RequestParam("procesor") String procesor,
            @RequestParam("kartaGraficzna") String kartaGraficzna,
            @RequestParam("opis") String opis,
            Model modelo)
            throws Exception {

        Computer computer = new Computer(marka, model, procesor, kartaGraficzna, opis, true);
        System.out.println(computer);
        compRepo.save(computer); // ZAPIS DO BAZY !!!!
        modelo.addAttribute("computer", computer);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz( Model model){
        for (Computer computers : compRepo.findAll()) {
            System.out.println(computers);
        }

        model.addAttribute("computers", compRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        compRepo.deleteById(id);

        model.addAttribute("computers", compRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("computers", compRepo.findAllByModel(kryterium));
        return "pokaz";
    }

    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("marka") String marka,
            @RequestParam("model") String model,
            @RequestParam("procesor") String procesor,
            @RequestParam("kartaGraficzna") String kartaGraficzna,
            @RequestParam("opis") String opis, Model modelo)
            throws Exception {
        Computer computer = new Computer(id, marka, model, procesor, kartaGraficzna, opis, true);
        System.out.println(computer);
        compRepo.save(computer);
        modelo.addAttribute("computer", computer);
        return "pokaz";
    }


    @RequestMapping("/przekieruj")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model
    )
            throws Exception {
        System.out.println(compRepo.findById(id));
        model.addAttribute("computer", compRepo.findById(id));
        return "aktualizuj";
    }

}


