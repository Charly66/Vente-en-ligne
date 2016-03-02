/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vente.service;

import org.springframework.data.repository.CrudRepository;
import vente.entity.CodePromo;

/**
 *
 * @author admin
 */
public interface CodePromoService extends CrudRepository<CodePromo, Long>{
    
    public CodePromo findOneByCode(String nom);
}
