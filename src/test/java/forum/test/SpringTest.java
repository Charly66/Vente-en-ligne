/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

import forum.service.SecuritServiceMockImpl;
import forum.service.SecurityServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import forum.spring.SpringConfig;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    @Qualifier("sec_jpa")
    private SecurityServiceImpl ssi;
    @Autowired
    @Qualifier("sec_jpa")
    private SecurityServiceImpl ssi2;
    
    @Autowired
    @Qualifier("sec_con")
    private SecuritServiceMockImpl ssmi;
    
    @Test
    public void egaux(){
        Assert.assertTrue(ssi2==ssi);
        Assert.assertEquals(ssi2, ssi);
    }
    
    @Test
    public void logTest(){
        ssi.check();
    }
    
    @Test
    public void logConTest(){
        ssmi.check();
    }
    
    
    
}
