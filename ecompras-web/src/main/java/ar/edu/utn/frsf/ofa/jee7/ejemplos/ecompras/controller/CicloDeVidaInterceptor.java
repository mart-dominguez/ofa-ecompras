/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author Martin
 */
public class CicloDeVidaInterceptor implements PhaseListener{

static final Logger LOGGER = Logger.getLogger(CicloDeVidaInterceptor.class.getName());
 
    @Override
    public void afterPhase(PhaseEvent event) {
        LOGGER.log(Level.INFO, "Después:{0}", event.getPhaseId());
    }
 
 
    @Override
    public void beforePhase(PhaseEvent event) {
        LOGGER.log(Level.INFO, "Antes:{0}", event.getPhaseId());
        //Solo si la fase es la de RESTORE_VIEW 1 muestro todos los datos sino no porque se repiten
        if(event.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            FacesContext facesContext = event.getFacesContext();
            HttpServletRequest request = (HttpServletRequest)
                facesContext.getExternalContext().getRequest();
            // analizar parametros y URL del request
            LOGGER.log(Level.INFO, "getPathInfo: "+request.getPathInfo());
            LOGGER.log(Level.INFO, "getAuthType: "+request.getAuthType());
            LOGGER.log(Level.INFO, "getContextPath: "+request.getContextPath());
            LOGGER.log(Level.INFO, "getQueryString: "+request.getQueryString());
            LOGGER.log(Level.INFO, "getRemoteAddr: "+request.getRemoteAddr());
            LOGGER.log(Level.INFO, "getMethod: "+request.getMethod());
            LOGGER.log(Level.INFO, "getRequestURL: "+request.getRequestURL());
            LOGGER.log(Level.INFO, "getRequestURI: "+request.getRequestURI());
            LOGGER.log(Level.INFO, "getServerName: "+request.getServerName());
            LOGGER.log(Level.INFO, "getServletPath: "+request.getServletPath());
            LOGGER.log(Level.INFO, "getServerPort: "+request.getServerPort());
            Cookie[] cookies = request.getCookies();
            LOGGER.log(Level.INFO, "====== COOKIES ======");
            if(cookies != null){
                for(Cookie ck : cookies){
                    LOGGER.log(Level.INFO, "cookies: "+ck.getName()+" - "+ck.getValue());                
                }
            }
            LOGGER.log(Level.INFO, "====== parametros ======");            
            for(Map.Entry<String, String[]> params : request.getParameterMap().entrySet()){
                        LOGGER.log(Level.INFO, "params: {clave "+params.getKey()+ " | valor "+Arrays.toString(params.getValue()) );

            }
            Enumeration<String> kh = request.getHeaderNames();
            if(kh != null){
            LOGGER.log(Level.INFO, "====== ENCABEZADOS ======");
            while(kh.hasMoreElements()){
                String k = kh.nextElement();
                LOGGER.log(Level.INFO, k + " *-=-*"+request.getHeader(k));    
            }
            }
        }
    }
 
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

  
    
}
