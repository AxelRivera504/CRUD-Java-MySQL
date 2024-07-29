/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatospoo;
import java.sql.Connection;

/**
 *
 * @author arrivera
 */
public class ProductosDB {
    private Connection con;
    
    ProductosDB(Connection con){
    this.con = con;
    }
}
