/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service("sec_con")
public class SecuritServiceMockImpl implements SecurityServiceInterface{
    
    @Autowired
    @Qualifier("log_consol")
    private LoggerServiceConsolImpl loggerConsol;
    
    public void check() {
        loggerConsol.log();
    }
}
