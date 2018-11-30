/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Filiere;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FiliereService;

/**
 *
 * @author root
 */
@WebServlet(name = "FiliereServlet", urlPatterns = {"/FiliereServlet"})
public class FiliereServlet extends HttpServlet {

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
            String action = request.getParameter("action");

            FiliereService fs = new FiliereService();
            Gson g = new Gson();

            switch (action) {
                case "ajouter": {
                    String operation = request.getParameter("operation");
                    String nom = request.getParameter("nom");
                    String code = request.getParameter("code");
                    String description = request.getParameter("description");
                    Filiere filiere = new Filiere();
                    
                    if (operation.equals("add")) {
                        fs.create(new Filiere(nom, code, description));
                    }else if (operation.equals("update")) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        filiere = fs.findById(id);
                        filiere.setNom(nom);
                        filiere.setCode(code);
                        filiere.setDescription(description);
                        fs.update(filiere);
                    } 

                    response.setContentType("application/json");
                    g.toJson(fs.findAll(), response.getWriter());
                }
                case "supprimer": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    fs.delete(fs.findById(id));

                    response.setContentType("application/json");
                    g.toJson(fs.findAll(), response.getWriter());
                }                 
                case "modifier": {
                    int id = Integer.parseInt(request.getParameter("id"));
                    response.setContentType("application/json");
                    g.toJson(fs.findById(id), response.getWriter());
                }
            }
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
        processRequest(request, response);
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
