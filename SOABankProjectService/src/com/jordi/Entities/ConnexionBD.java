/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jordi.Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
public class ConnexionBD {
   private  String url = "jdbc:mysql://localhost:3306/soa_bank_service_bd?characterEncoding=utf8";
   private  String userName = "root";
   private  String password = "";
   private static Connection connect;
           
    public ConnexionBD(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
            connect = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Server Error");
 
            }  catch (ClassNotFoundException ex) {
                   Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null, "Server Error");
               }
    }
    
     public static Connection getInstance(){
         
         if(connect == null){
             new ConnexionBD();
             System.out.println("NEW SQL CONNECTION !");
             
         } else {
             System.out.println("SQL CONNECTION ALREADY EXIST !");
         }
     return connect;
     }
    
}
