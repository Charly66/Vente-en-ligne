/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author ajc
 */
@Service("log_jpa")
public class LoggerServiceJPAImpl implements LoggerServiceInterface{

    @Override
    public void log() {
        System.out.println(new Date()+" - "+this.getClass().getSimpleName());
    }
}
