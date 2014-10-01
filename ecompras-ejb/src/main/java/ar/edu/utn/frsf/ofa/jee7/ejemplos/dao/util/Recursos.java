/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util;

import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Martin
 */
@Named
@RequestScoped
public class Recursos {

// Expose an entity manager using the resource producer pattern

@Produces 
@PersistenceContext(unitName = "ecomprasPU")
@BaseProduccion
private EntityManager em;                                        // 

@Produces
    Logger getLogger(InjectionPoint ip) {                            // 
    String category = ip.getMember()
                        .getDeclaringClass()
                        .getName();
    return Logger.getLogger(category);
}

@Produces
    FacesContext getFacesContext() {                                 // 
    return FacesContext.getCurrentInstance();
    }
}
