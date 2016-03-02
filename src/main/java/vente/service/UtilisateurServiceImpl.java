/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vente.entity.Utilisateur;
import vente.exception.ExistingEmailException;
import vente.exception.WrongLoginException;

/**
 *
 * @author admin
 */
@Service
public class UtilisateurServiceImpl {

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private MailService mailService;
    @Autowired
    private ConfigService configService;
    

    public void inscription(Utilisateur u) throws ExistingEmailException {
        if (utilisateurService.findOneByEmail(u.getEmail()) != null) {
            throw new ExistingEmailException();
        }

        utilisateurService.save(u);
        mailService.envoiMail(u, configService.getTitreMailInscription(), configService.getContenuMailInscription());
        
    }

    public void login(String email, String mdp) throws WrongLoginException {
        if (utilisateurService.findOneByEmail(email).getMdp() != mdp) {
            throw new WrongLoginException();
        }
        System.out.println("Login successful");
    }
 
}
