/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author praveena
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.*;
import javax.servlet.*;
public class Validate  {
    public static boolean checkUser(String username,String password) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("oracle.jdbc.OracleDriver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","admin");
        
         PreparedStatement ps=con.prepareStatement("select * from PRAVEENA.fb_user where user_name=? and password=?");
                  ps.setString(1, username);
                  ps.setString(2, password);
                  ResultSet rs=ps.executeQuery();
                  if(rs.next())
                  {
                      
                      st = true;
                  }
                  
      return st;
      }catch (Exception e)
      {
          e.printStackTrace();
      }
       return false;                 
  }   
   
    
}
