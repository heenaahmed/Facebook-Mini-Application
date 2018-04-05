/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author praveena
 */
public class Profile extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       boolean st =false;
          try{
       
        
        Class.forName("oracle.jdbc.OracleDriver");

        
	
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
        
        
           String fname = request.getParameter("fname");
          
           PreparedStatement ps=con.prepareStatement("select * from PRAVEENA.fb_user where fname=?");
           
                  ps.setString(1, fname);
               
          ResultSet rs=ps.executeQuery();
          
              while(rs.next()){
                      
                      String firstname=rs.getString("fname");
                       String lastname =rs.getString("lname");
                       //out.println("hiiiiii");
                   
                      String school=rs.getString("school_name");
                       String sex=rs.getString("gender");
                       out.println("<body style='background-color:lightblue;'>");
                       
            
             out.println("<br>");
             out.println("<center>");
              out.print("<img src='C:/Users/mahit/Desktop/Facebook-create.png' alt='display this' width=600 height=100 />");
               out.println("<br>");
               out.println("<br>");
             out.println("<font size='7'>");
             out.println("<h5> " +" " + firstname +" "+ lastname + " " +"Found</h5>");
              out.println("<h5School:> " +" " + school  +"</h5>");
              
             
       if(firstname.isEmpty()||lastname.isEmpty()||school.isEmpty()||sex.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("Profile.html");
		
			rd.include(request, response);
		}
		
                  }
     
          
          
      
         }
        catch(Exception se)
        {
            se.printStackTrace();
        }
    }
}
