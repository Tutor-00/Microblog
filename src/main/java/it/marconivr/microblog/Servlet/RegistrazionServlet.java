/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.Servlet;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import it.marconivr.microblog.dao.UtenteDao;
import it.marconivr.microblog.entity.BlogUtente;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Tutor
 */
@WebServlet(name = "RegistrazionServlet", urlPatterns = {"/RegistrazionServlet"})
public class RegistrazionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("index.html").include(request, response);
            
            String name = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            Random random = new SecureRandom();
            byte[] saltByte = new byte[16];
            random.nextBytes(saltByte);
            
            String salt = DatatypeConverter.printBase64Binary(saltByte);
            
            String passwordSalt = password + salt;
            
            Hasher hasher = Hashing.sha256().newHasher();
            hasher.putString(passwordSalt, Charsets.UTF_8);
            String sha256 = hasher.hash().toString();

            
            BlogUtente u = new BlogUtente();
            u.setUsername(name);
            u.setPassword(sha256);
            u.setSalt(salt);
            u.setEmail(email);
            UtenteDao.create(u);
            
        } catch (Exception ex) {
            Logger.getLogger(RegistrazionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }



}
