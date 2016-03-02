/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vente.entity.Commande;
import vente.entity.Utilisateur;

/**
 *
 * @author admin
 */
@Service
public class MailService {
    
    @Autowired
    private ConfigService configService;
    
    public void envoiMail(Utilisateur utilisateur,String titre,String contenu){
        System.out.println("Envoi du mail à "+ utilisateur.getEmail() + " : "+ titre + " - "+ contenu);
    }
    
    public void mailAutomatique(Commande commande){
        
        envoiMail(commande.getUtilisateur(),configService.getTitreMailAuto() , configService.getContenuMailAuto());
    }
    
}
