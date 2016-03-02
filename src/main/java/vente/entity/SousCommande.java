/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class SousCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long quantite;
    
    @ManyToOne
    @JoinColumn(name = "COMMANDE_ID")
    private Commande commande;
    
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    public SousCommande() {
    }

    public SousCommande(long quantite, Article article,Commande commande) {
        this.quantite = quantite;
        this.commande = commande;
        this.article = article;
    }

    public SousCommande(long id, long quantite, Article article, Commande commande) {
        this.id = id;
        this.quantite = quantite;
        this.article = article;
        this.commande = commande;
    }

    public SousCommande(Long quantite) {
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCommande)) {
            return false;
        }
        SousCommande other = (SousCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vente.entity.SousCommande[ id=" + id + " ]";
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
}
