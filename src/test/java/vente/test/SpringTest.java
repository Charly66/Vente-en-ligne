/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.test;

import entity.enumeration.TypeCodePromo;
import entity.enumeration.TypeEtatCommande;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vente.spring.SpringConfig;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vente.entity.Article;
import vente.entity.Categorie;
import vente.entity.CodePromo;
import vente.entity.Commande;
import vente.entity.ModeLivraison;
import vente.entity.SousCommande;
import vente.entity.Utilisateur;
import vente.exception.ArticleQuantityException;
import vente.service.ArticleService;
import vente.service.CategorieService;
import vente.service.CodePromoService;
import vente.service.CommandeService;
import vente.service.CommandeServiceImpl;
import vente.service.DBService;
import vente.service.ModeLivraisonService;
import vente.service.SousCommandeService;
import vente.service.UtilisateurService;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
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
    @Autowired
    private CommandeServiceImpl commandeImpl;

    @Before
    public void init() {
        dbService.deleteAll();

        Utilisateur u1 = new Utilisateur(1L, "email1", "mdp1", "nom1", "prenom1", "adresse1", 33000L, "ville1");
        Article a1 = new Article(1L, "article1", 1L, 100L);
        Categorie c1 = new Categorie(1L, "Pull");
        CodePromo cp1 = new CodePromo(1L, "-10%", TypeCodePromo.POURCENTAGE, 10);
        ModeLivraison ml1 = new ModeLivraison(1L, "Colissimo", 5L);
        Commande commande = new Commande(1L, new Date(), 0L, TypeEtatCommande.APayer);
        SousCommande sc1 = new SousCommande(4848L, 2L, articleService.findOneByNom("article1"), commande);

        utilisateurService.save(u1);
        articleService.save(a1);
        categorieService.save(c1);
        codePromoService.save(cp1);
        modeLivraisonService.save(ml1);
        commandeService.save(commande);
        sousCommandeService.save(sc1);
        
        commande.setUtilisateur(u1);
        u1.getCommandes().add(commande);
        commande.setModeLivraison(ml1);
        ml1.getCommandes().add(commande);
        sc1.setCommande(commande);
        sc1.setArticle(a1);
        commande.getSousCommandes().add(sc1);
        a1.getSousCommandes().add(sc1);
        a1.setCategorie(c1);
        c1.getArticles().add(a1);
        
        utilisateurService.save(u1);
        articleService.save(a1);
        categorieService.save(c1);
        codePromoService.save(cp1);
        modeLivraisonService.save(ml1);
        commandeService.save(commande);
        sousCommandeService.save(sc1);
        
        System.out.println("Init ok");
    }

    @Test
    public void testCalculPrix() {
        Commande commande = commandeService.findOne(1L);
        commande.setPrixTotal(commandeImpl.prixTotal(1L, 1L));
        System.out.println(commande.getPrixTotal());
    }

    @Test
    public void testAjoutArticle() throws ArticleQuantityException {
        commandeImpl.ajoutArticle(1L, 1L, 1L);
    }
}
