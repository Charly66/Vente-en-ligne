/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

import org.springframework.data.repository.CrudRepository;
import vente.entity.SousCommande;

/**
 *
 * @author admin
 */
public interface SousCommandeService extends CrudRepository<SousCommande, Long>{
    
}