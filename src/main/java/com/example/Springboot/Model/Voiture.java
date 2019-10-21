package com.example.Springboot.Model;

import org.springframework.web.bind.annotation.ModelAttribute;


public class Voiture {
    private String marque;
    private String modele;

    public Voiture(){

    }
    public Voiture (String marque, String modele){
        this.marque = marque;
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
}
