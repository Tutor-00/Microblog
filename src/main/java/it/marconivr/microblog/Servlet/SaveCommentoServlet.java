/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.Servlet;

import it.marconivr.microblog.dao.CommentoDao;
import it.marconivr.microblog.dao.PostDao;
import it.marconivr.microblog.dao.UtenteDao;
import it.marconivr.microblog.entity.BlogCommento;
import it.marconivr.microblog.entity.BlogPost;
import it.marconivr.microblog.entity.BlogUtente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tutor
 */
public class SaveCommentoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String testo = request.getParameter("testo");
        String username = (String) request.getSession(false).getAttribute("username");
        BlogUtente u = UtenteDao.findBlogUtente(username);
        
        String postIdString = request.getParameter("postId");
        long postId = Long.parseLong(postIdString);
        BlogPost p = PostDao.findPost(postId);
        
        BlogCommento c = new BlogCommento ();
        c.setContenuto(testo);
        c.setUtente(u);
        c.setDataOra(new Date());
        c.setPost(p);
        
        CommentoDao.create(c);
        
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("post.jsp").include(request, response);
    }



}
