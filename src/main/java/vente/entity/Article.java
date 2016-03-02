/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 128)
    private String nom;
    private String ref;
    private Long stock;
    private Long nbVendus;
    private Long prix;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID")
    private Categorie categorie;
    
    @OneToMany(mappedBy = "article")
    private List<SousCommande> sousCommandes;

    public Article(Long id, String nom, Long stock, Long prix) {
        this.id = id;
        this.nom = nom;
        this.stock = stock;
        this.prix = prix;
    }

    public Article(String nom, Long prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Article(String nom, Date dateCreation, Long stock, Long prix) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.stock = stock;
        this.prix = prix;
    }
    
    
    
   

    public Article() {
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
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vente.entity.Article[ id=" + id + " ]";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public List<SousCommande> getSousCommandes() {
        return sousCommandes;
    }

    public void setSousCommandes(List<SousCommande> sousCommandes) {
        this.sousCommandes = sousCommandes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getNbVendus() {
        return nbVendus;
    }

    public void setNbVendus(Long nbVendus) {
        this.nbVendus = nbVendus;
    }
    
}
