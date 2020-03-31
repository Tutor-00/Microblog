/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tutor
 */
public class CommentoServlet extends HttpServlet { 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getSession(false).getAttribute("username") != null) {
            String postIdString = request.getParameter("postId");
            long postId = Long.parseLong(postIdString);
            request.setAttribute("postId", postId);
            request.getRequestDispatcher("commento.jsp").include(request, response);
          
            
        }
    }

}

    