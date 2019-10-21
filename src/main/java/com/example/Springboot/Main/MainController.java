package com.example.Springboot.Main;

import java.util.ArrayList;
import java.util.List;


import com.example.Springboot.Model.Voiture;

import com.example.Springboot.carForm.CarForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static List<Voiture>voitures = new ArrayList<>();

    static{
        voitures.add(new Voiture("Renault", "Twingo"));
        voitures.add(new Voiture("Nissan", "Micra 5"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index (Model model){
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("voitures", voitures);
        return "carList";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String savecar(Model model, @ModelAttribute("carForm") CarForm carForm) {

        String marque = carForm.getMarque();
        String modele = carForm.getModele();

        System.out.println("\n\n marque = " + marque + "\n\n modele = " + modele);

        if (marque != null && marque.length() > 0
                && modele != null && modele.length() > 0) {
            Voiture voiture = new Voiture(marque, modele);
            voitures.add(voiture);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }
}
