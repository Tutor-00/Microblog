package it.marconivr.microblog.Servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class PostServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
                if(session==null){
                    out.print("Please login first");
                    request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            request.getRequestDispatcher("link.html").include(request, response);
	    
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            
            String titolo=request.getParameter("titolo");
            String post=request.getParameter("post");
            
            out.println(titolo);
            out.println(dateobj);
            out.println(post);
            out.close();
	}
     
} 

