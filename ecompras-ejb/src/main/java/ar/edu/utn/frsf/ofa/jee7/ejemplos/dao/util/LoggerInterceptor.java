/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util;
import java.lang.reflect.Method;
import javax.inject.Inject;
 
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
 
@Log
@Interceptor
public class LoggerInterceptor {
    @Inject
    Logger logger;
    
    @AroundInvoke
     public Object logMethodEntry(InvocationContext ctx) throws Exception {
         String claseEjecutar = ctx.getTarget().getClass().getSimpleName();         
         String nombreMetodoEjecutar = ctx.getMethod().getName();
         Method met = ctx.getMethod();
         StringBuilder parametros = new StringBuilder();         
         int i = 0;
         for(Object x : ctx.getParameters()){
            parametros.append(met.getParameterTypes()[i++].getName() + " = "+x.toString()+" | ");
         }
         long  tiempoInicial = System.currentTimeMillis();
         Object ret = ctx.proceed();  
           //return ctx.proceed();
           long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
           logger.info("LOG DE TAREA: clase: "+claseEjecutar+" | metodo : "+nombreMetodoEjecutar+" | parametros:  "+ parametros.toString() + " | duracion:  "+tiempoFinal );
           return ret;
     }
    
}
