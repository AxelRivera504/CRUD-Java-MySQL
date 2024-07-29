/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatospoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author arrivera
 */
public class DataBaseConnection {
    
    //definir las credenciales de la conexión
    
//    private static final String HOST = "esshn.com";
//    private static final String USER = "esshnnet_poo"; 
//    private static final String PORT = "3306";
//    private static final String PWD = "l=FW4SwyUKHg";
//    private static final String BD = "esshnnet_poo";
//    
//    
//    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + BD;
    
        private static final String HOST = "localhost";
        private static final String USER = "admin"; 
        private static final String PORT = "3306";
        private static final String PWD = "@Xel0501200209630";
        private static final String BD = "facturacion_poo";
        
        
        private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + BD;
    
    //Se hacen estaticas para evitar tener que crear instancias
    
    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(URL,USER, PWD);
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
}
