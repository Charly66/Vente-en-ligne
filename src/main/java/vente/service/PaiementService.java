/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

import entity.enumeration.TypeEtatCommande;
import org.springframework.beans.factory.annotation.Autowired;
import vente.entity.Commande;
import vente.entity.SousCommande;

/**
 *
 * @author admin
 */
public class PaiementService {
    
    @Autowired
    private MailService mailService;
    
    public void paiementCommande(Commande commande){
        commande.setTypeEtatCommande(TypeEtatCommande.AExpedie);
        for(SousCommande sousCommande : commande.getSousCommandes())
            sousCommande.getArticle().setStock(sousCommande.getArticle().getStock() - sousCommande.getQuantite());
        for(SousCommande sousCommande : commande.getSousCommandes())
            sousCommande.getArticle().setNbVendus(sousCommande.getArticle().getNbVendus()- sousCommande.getQuantite());
    }
    
}
