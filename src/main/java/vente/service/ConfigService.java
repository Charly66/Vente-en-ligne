/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

/**
 *
 * @author admin
 */
public class ConfigService {
    
    private String titreMailInscription = "Inscription";
    private String contenuMailInscription = "Bienvenue chez Escrocks vendeurs !";
    private String titreMailAuto = "Votre commande vous attend";
    private String contenuMailAuto  ="Venez depenser votre argent rapidement sinon vous allez rater votre vie !";
    private int joursAvantMailAuto = 3;

    public ConfigService(String titreMailInscription, String contenuMailInscription, String titreMailAuto, String contenuMailAuto, int joursAvantMailAuto) {
        this.titreMailInscription = titreMailInscription;
        this.contenuMailInscription = contenuMailInscription;
        this.titreMailAuto = titreMailAuto;
        this.contenuMailAuto = contenuMailAuto;
        this.joursAvantMailAuto = joursAvantMailAuto;
    }

    public String getTitreMailInscription() {
        return titreMailInscription;
    }

    public void setTitreMailInscription(String titreMailInscription) {
        this.titreMailInscription = titreMailInscription;
    }

    public String getContenuMailInscription() {
        return contenuMailInscription;
    }

    public void setContenuMailInscription(String contenuMailInscription) {
        this.contenuMailInscription = contenuMailInscription;
    }

    public String getTitreMailAuto() {
        return titreMailAuto;
    }

    public void setTitreMailAuto(String titreMailAuto) {
        this.titreMailAuto = titreMailAuto;
    }

    public String getContenuMailAuto() {
        return contenuMailAuto;
    }

    public void setContenuMailAuto(String contenuMailAuto) {
        this.contenuMailAuto = contenuMailAuto;
    }

    public int getJoursAvantMailAuto() {
        return joursAvantMailAuto;
    }

    public void setJoursAvantMailAuto(int joursAvantMailAuto) {
        this.joursAvantMailAuto = joursAvantMailAuto;
    }
    
}
