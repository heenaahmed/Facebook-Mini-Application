/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.GenericServlet;

/**
 *
 * @author praveena
 */
public class Register extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int user_id=113;
        
        
	
        String fname = request.getParameter("fname");
        
        String Lname=request.getParameter("lname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String birthday = request.getParameter("dob");
         String gender=request.getParameter("sex");
     
         
         
      
        try{
        
        
        Class.forName("oracle.jdbc.OracleDriver");

        
	
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
         
      

        PreparedStatement ps=con.prepareStatement
                  ("insert into PRAVEENA.fb_user values(?,?,?,?,?,?,?,?)");
       
           
        ps.setInt(1,user_id);
        ps.setString(2, fname);
        ps.setString(3, Lname);
        ps.setString(4, username);
        ps.setString(5, password);
        ps.setString(6, birthday);
        ps.setString(7,gender);
        ps.setString(8, null);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            String h3;
             out.println("<body style='background-color:lightblue;'>");
            
             out.println("<br>");
             out.println("<center>");
              out.print("<img src='C:/Users/mahit/Desktop/Facebook-create.png' alt='display this' width=600 height=100 />");
               out.println("<br>");
               out.println("<font size='7'>");
            out.println("<h3>Successfully Registered</h3>");
           out.println("<h3>Welcome " +" " + username +"</h3>");
            out.print("<a href='" + getServletContext().getContextPath() + "/login.html'>click here to login</a>");
           out.println("</center>");
          }
        
         else
          {
              out.println("hello");
          }
          
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
      
	
      }
    

}
