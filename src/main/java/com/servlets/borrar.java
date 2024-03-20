/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.servlets;

import com.models.Career;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.dao.CareerQuery;
import com.db.Connect;
import jakarta.servlet.RequestDispatcher;
import java.sql.*;
/**
 *
 * @author Mati
 */
@WebServlet(name = "borrar", urlPatterns = {"/borrar"})
public class borrar extends HttpServlet {

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
        CareerQuery careerQuery = new CareerQuery();
        RequestDispatcher rd = request.getRequestDispatcher("borrar.jsp");

        try{
            Connection connection = Connect.getConnection();
            ArrayList <Career> careerList = careerQuery.getAllCareers(connection);
            String idCareer = request.getParameter("id");
//            Career careerToDelete = careerList.get(Integer.valueOf(idCareer));
            Career careerToDelete = null;
            for(int i = 0; i < careerList.size(); i ++){
                Career career = careerList.get(i);
                if(career.getId() == Integer.parseInt(idCareer)){
                    careerToDelete = career;
                }
            }
            request.setAttribute("carrera", careerToDelete);
            rd.forward(request, response);

        }catch(SQLException e){
            e.printStackTrace();
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
        String id = request.getParameter("id");
        CareerQuery careerQuery = new CareerQuery();
        try {
            Connection connection = Connect.getConnection();
            Career careerToDelete = careerQuery.getCareerById(Integer.parseInt(id), connection);
            int careerDeleted = careerQuery.deleteCareer(careerToDelete, connection);
            System.out.println(id);
            //Debuggear esto y ver pq no elimina de la base de datos
        } catch (SQLException e) {
            e.getMessage();
        }
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
