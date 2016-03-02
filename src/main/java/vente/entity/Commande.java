/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.entity;

import entity.enumeration.TypeEtatCommande;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    private Long prixTotal;
    
    private TypeEtatCommande etatCommande;
    
    @ManyToOne
    @JoinColumn(name = "MODELIVRAISON_ID")
    private ModeLivraison modeLivraison;
    
    @ManyToOne
    @JoinColumn(name = "UTILISATEUR_ID")
    private Utilisateur utilisateur;
    
    @OneToMany(mappedBy = "commande")
    private List<SousCommande> sousCommandes;

    public Commande(Date dateCommande, Long prixTotal, TypeEtatCommande etatCommande) {
        this.dateCommande = dateCommande;
        this.prixTotal = prixTotal;
        this.etatCommande = etatCommande;
    }

    public Commande() {
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vente.entity.Commande[ id=" + id + " ]";
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Long getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Long prixTotal) {
        this.prixTotal = prixTotal;
    }

 

    public ModeLivraison getModeLivraison() {
        return modeLivraison;
    }

    public void setModeLivraison(ModeLivraison modeLivraison) {
        this.modeLivraison = modeLivraison;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<SousCommande> getSousCommandes() {
        return sousCommandes;
    }

    public void setSousCommandes(List<SousCommande> sousCommandes) {
        this.sousCommandes = sousCommandes;
    }

    public TypeEtatCommande getTypeEtatCommande() {
        return etatCommande;
    }

    public void setTypeEtatCommande(TypeEtatCommande typeEtatCommande) {
        this.etatCommande = typeEtatCommande;
    }

    
}
