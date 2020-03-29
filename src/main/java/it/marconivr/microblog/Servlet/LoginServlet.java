package it.marconivr.microblog.Servlet;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import it.marconivr.microblog.dao.UtenteDao;
import it.marconivr.microblog.entity.BlogUtente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        String password = request.getParameter("password");

        BlogUtente utente = UtenteDao.findBlogUtente(name);

        String salt = utente.getSalt();

        String passwordSalt = password + salt;

        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(passwordSalt, Charsets.UTF_8);
        String sha256 = hasher.hash().toString();

        if (sha256.equals(utente.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            request.setAttribute("username", name);
            request.getRequestDispatcher("info.jsp").include(request, response);
            
        } else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
