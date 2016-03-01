/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vente.spring.SpringConfig;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vente.entity.Article;
import vente.entity.Categorie;
import vente.entity.CodePromo;
import vente.entity.ModeLivraison;
import vente.entity.Utilisateur;
import vente.service.ArticleService;
import vente.service.CategorieService;
import vente.service.CodePromoService;
import vente.service.CommandeService;
import vente.service.DBService;
import vente.service.ModeLivraisonService;
import vente.service.SousCommandeService;
import vente.service.UtilisateurService;

/**
 *
 * @author ETY
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class SpringTest {
    
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private DBService dbService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private CodePromoService codePromoService;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private ModeLivraisonService modeLivraisonService;
    @Autowired
    private SousCommandeService sousCommandeService;
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Test
    public void init(){
        dbService.deleteAll();
        utilisateurService.save(new Utilisateur("email1", "mdp1", "nom1", "prenom1", "adresse1", 33000L, "ville1"));
        articleService.save(new Article("article1", 100L));
        categorieService.save(new Categorie("Pull"));
        codePromoService.save(new CodePromo("-10%", 10));
        modeLivraisonService.save(new ModeLivraison("Colissimo", 5L));
        
        System.out.println("Init ok");
    }
  
    
    
}
