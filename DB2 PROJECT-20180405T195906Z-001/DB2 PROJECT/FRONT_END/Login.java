/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author praveena
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(Validate.checkUser(username, password))
        {
             out.println("<body style='background-color:lightblue;'>");
            
             out.println("<br>");
             out.println("<center>");
              out.print("<img src='C:/Users/mahit/Desktop/Facebook-create.png' alt='display this' width=600 height=100 />");
               out.println("<br>");
               out.println("<br>");
             out.println("<font size='7'>");
             out.println("<h5>Welcome " +" " + username +"</h5>");
             
                        RequestDispatcher rd1=request.getRequestDispatcher("Welcome");
                        rd1.include(request,response);
              out.println("</center>");
                        
                        
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("login.html");
           rs.include(request, response);
        }
        
        
    }  

}
