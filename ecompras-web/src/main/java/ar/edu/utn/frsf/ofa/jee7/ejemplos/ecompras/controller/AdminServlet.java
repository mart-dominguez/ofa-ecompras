package ar.edu.utn.frsf.ofa.jee7.ejemplos.ecompras.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.InicializadorEJB;
import ar.edu.utn.frsf.ofa.jee7.ejemplos.dao.util.ConexionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Martin
 */
@WebServlet(urlPatterns = {"/Admin"})
public class AdminServlet extends HttpServlet {
  @Inject @ConexionDB
    private DataSource ds;
    @Inject
    private InicializadorEJB initEJB;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReportPdfServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            if(request.getParameter("OPER")!=null && request.getParameter("OPER").equalsIgnoreCase("INIT_PRD")){
                out.println("<h1>creando 5 productos</h1>");
                initEJB.crearProductos(5);
            }  
            if(request.getParameter("OPER")!=null && request.getParameter("OPER").equalsIgnoreCase("INIT_CLI")){
                out.println("<h1>creando 5 productos</h1>");
                initEJB.crearClientes(5);
            } 
            out.println("<h1>Operacion realizada" + request.getParameter("OPER")+ "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void reportePDF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String salida;
 
        try {
            HashMap hm = null;
            hm = new HashMap();
 
            ServletOutputStream servletOutputStream = response.getOutputStream();
 
            byte[] bytes = null;
 
            try {

                bytes = JasperRunManager.runReportToPdf(getServletContext().getResourceAsStream("/rpt/ventas.jasper" ), hm, ds.getConnection());
 
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                servletOutputStream.write(bytes, 0, bytes.length);
                servletOutputStream.flush();
                servletOutputStream.close();
            } catch (JRException e) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                e.printStackTrace(printWriter);
                response.setContentType("text/plain");
                response.getOutputStream().print(stringWriter.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida = "Error generando Reporte Jasper, el error del Sistema es " + e;
            System.out.println(salida);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            if(request.getParameter("OPER")!=null && request.getParameter("OPER").equalsIgnoreCase("RPT_VTAS")){
                this.reportePDF(request, response);
            } 
            else{
                processRequest(request, response);
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
