/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

import entity.enumeration.TypeCodePromo;
import org.springframework.beans.factory.annotation.Autowired;
import vente.entity.Article;
import vente.entity.CodePromo;
import vente.entity.Commande;
import vente.entity.SousCommande;
import vente.exception.ArticleQuantityException;

/**
 *
 * @author admin
 */
public class CommandeServiceImpl {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CodePromoService codePromoService;
    @Autowired
    private SousCommandeService sousCommandeService;
    @Autowired
    private CommandeService commandeService;

    public void ajoutArticle(long commandeId, long articleId, long quantite) throws ArticleQuantityException {

        // Check article possède assez de stock
        Article a = articleService.findOne(articleId);
        if (a.getStock() < quantite) {
            throw new ArticleQuantityException();
        }

        // Récup commande
        Commande c = commandeService.findOne(commandeId);

        // Ajoute ss-commande à la commande
        SousCommande sousCommande = new SousCommande(quantite, a, c);
        a.getSousCommandes().add(sousCommande);
        c.getSousCommandes().add(sousCommande);
        sousCommandeService.save(sousCommande);
//        commande.getSousCommandes().add(sousCommande);
//        commandsousCommandeeService.save(commande);

    }

    public Long prixTotal(long commandeId, long codePromoId) {
        Long prixTotal = 0L;

        for (SousCommande sousCommande : commandeService.findOne(commandeId).getSousCommandes()) {
            prixTotal = prixTotal + sousCommande.getArticle().getPrix() * sousCommande.getQuantite();
        }

        if (codePromoService.findOne(codePromoId).getTypeCodePromo() == TypeCodePromo.REMISE) {
            prixTotal = prixTotal - codePromoService.findOne(codePromoId).getValeur();
        }
        if (codePromoService.findOne(codePromoId).getTypeCodePromo() == TypeCodePromo.POURCENTAGE) {
            prixTotal = prixTotal - prixTotal * codePromoService.findOne(codePromoId).getValeur() / 100;
        }

        prixTotal = prixTotal + commandeService.findOne(commandeId).getModeLivraison().getCout();
        return prixTotal;
    }
}
