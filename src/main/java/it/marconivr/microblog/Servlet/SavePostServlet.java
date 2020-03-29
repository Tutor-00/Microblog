/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.Servlet;

import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.dao.UtenteDao;
import it.marconivr.microblog.entity.BlogPost;
import it.marconivr.microblog.entity.BlogUtente;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tutor
 */
public class SavePostServlet extends HttpServlet {

  
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String titolo = request.getParameter("titolo");
        String testo = request.getParameter("testo");
        String username = (String) request.getSession(false).getAttribute("username");
        BlogUtente u = UtenteDao.findBlogUtente(username);
        
        BlogPost p = new BlogPost();
        p.setContenuto(testo);
        p.setTitolo(titolo);
        p.setUtente(u);
        p.setDataOra(new Date());
        
        PostDao.create(p);
    }


}
