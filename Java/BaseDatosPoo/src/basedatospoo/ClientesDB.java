/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatospoo;
import basedatospoo.Models.Cliente;
import basedatospoo.Models.Respuesta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author arrivera
 */
public class ClientesDB {
    
    public ClientesDB(){
    }
    
    public List<Cliente> getClientes(){
        Connection con = DataBaseConnection.getConnection();
        List<Cliente> clientes = new ArrayList();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM clientes");
            
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                Cliente cli = new Cliente(
                        resultado.getInt("cliente_id"),
                        resultado.getString("correo"),
                        resultado.getString("nombre"),
                        resultado.getString("rtn"),
                        resultado.getString("estado"),
                        resultado.getDate("fecha_creacion")
                );
                clientes.add(cli);
            }
            System.out.println(clientes);
            return clientes;
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println("Error al cerrar la conexión:"+ex.getMessage());
            }
        }
        return clientes;
    }
    
    Cliente getClienteById(int Id){
        Connection con = DataBaseConnection.getConnection();
        Cliente cli = new Cliente();
        try{
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM clientes WHERE cliente_id = ?");
            stmt.setInt(1, Id);
            
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                cli.client_id           = resultado.getInt("cliente_id");
                cli.correo              = resultado.getString("correo");
                cli.nombre              = resultado.getString("nombre");
                cli.rtn                 = resultado.getString("rtn");
                cli.estado              = resultado.getString("estado");
                cli.fecha_creacion      = resultado.getDate("fecha_creacion");
            }
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println("Error al cerrar la conexión:"+ex.getMessage());
            }
        }
        return cli;
    }
    
    Respuesta AddCliente(Cliente cliente){
        Respuesta result = new Respuesta();
        Connection con = DataBaseConnection.getConnection();
        Cliente cli = new Cliente();
        try{
            PreparedStatement stmt = con.prepareStatement("INSERT INTO clientes(nombre,correo,rtn,estado,fecha_creacion) VALUE (?,?,?,?,?)");
            stmt.setString(1, cliente.nombre);
            stmt.setString(2, cliente.correo);
            stmt.setString(3, cliente.rtn);
            stmt.setString(4, cliente.estado);
            stmt.setDate(5,  new Date(cliente.fecha_creacion.getTime()));
            int rowsAffected  = stmt.executeUpdate();
            
            if(rowsAffected >= 0)
            {
               result.Success(true, "200", "Cliente agregado con exito");
            }else{
               result.Fault(true, "400", "Cliente NO agregado con exito");
            }
            
        }catch(SQLException ex){
            result.Fault(true, "400", ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
                result.Fault(true, "500", ex.getMessage());
            }
        }
        return result;
    } 
    
    
    Respuesta UpdateCliente(Cliente cliente){
        Respuesta result = new Respuesta();
        Connection con = DataBaseConnection.getConnection();
        Cliente cli = new Cliente();
        try{
            PreparedStatement stmt = con.prepareStatement("UPDATE clientes SET nombre = ? ,correo = ?, rtn = ? , estado = ? WHERE cliente_id = ? ");
            stmt.setString(1, cliente.nombre);
            stmt.setString(2, cliente.correo);
            stmt.setString(3, cliente.rtn);
            stmt.setString(4, cliente.estado);
            stmt.setInt(5,  cliente.client_id);
            int rowsAffected  = stmt.executeUpdate();
            
            if(rowsAffected >= 0)
            {
               result.Success(true, "200", "Cliente actualizado con exito");
            }else{
                result.Fault(true, "400", "Cliente NO actualizado con exito");
            }
            
        }catch(SQLException ex){
            result.Fault(true, "400", ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
               result.Fault(true, "500", ex.getMessage());
            }
        }
        return result;
    } 
    
     Respuesta DeleteCliente(int cliente){
        Respuesta result = new Respuesta();
        Connection con = DataBaseConnection.getConnection();
        Cliente cli = new Cliente();
        try{
            PreparedStatement stmt = con.prepareStatement("DELETE FROM clientes WHERE cliente_id = ?");
            stmt.setInt(1, cliente);
            int rowsAffected  = stmt.executeUpdate();
            
            if(rowsAffected >= 0)
            {
               result.Success(true, "200", "Cliente eliminado con exito");
            }else{
                result.Fault(true, "400", "Cliente NO eliminado con exito");
            }
            
        }catch(SQLException ex){
            result.Fault(true, "400", ex.getMessage());
        } finally{
            //se ejecuta siempre una vez haya finalizado todo lo del try
            try{
                con.close();
            }catch(SQLException ex){
               result.Fault(true, "500", ex.getMessage());
            }
        }
        return result;
    } 
}
