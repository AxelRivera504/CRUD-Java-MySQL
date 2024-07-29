/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basedatospoo;
import basedatospoo.Models.Cliente;
import basedatospoo.Models.Respuesta;
import java.util.Date;
import java.util.List;
/**
 *
 * @author arrivera
 */
public class BaseDatosPoo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instancia para ejecutar los metodos a la BD
        ClientesDB cliente = new ClientesDB();
        
        
        
        System.out.println("/////////////////////////////////////////////////////////");
        //Listar todos los clientes
        List<Cliente> clientes = cliente.getClientes();
        System.out.println("Listar todos los clientes");
        for (Cliente cli : clientes) {
            System.out.println("cliente No:"+cli.client_id);
            System.out.println("Nombre:"+cli.nombre);
            System.out.println("Correo:"+cli.correo);
            System.out.println("Estado:"+cli.estado);
            System.out.println("RTN:"+cli.rtn);
            System.out.println("Fecha Creacion:"+cli.fecha_creacion);
        }
        
        System.out.println("/////////////////////////////////////////////////////////");
        //Listar Cliente por id
        Cliente clienteMasiso = cliente.getClienteById(1);
        System.out.println("Listar cliente por id");
        System.out.println("cliente No:"+clienteMasiso.client_id);
        System.out.println("Nombre:"+clienteMasiso.nombre);
        System.out.println("Correo:"+clienteMasiso.correo);
        System.out.println("Estado:"+clienteMasiso.estado);
        System.out.println("RTN:"+clienteMasiso.rtn);
        System.out.println("Fecha Creacion:"+clienteMasiso.fecha_creacion);
        
        
        System.out.println("/////////////////////////////////////////////////////////");
        //Creacion Cliente
        System.out.println("Creacion Cliente");
        Cliente clientCreation = new Cliente(){{
            correo = "axeldm05@gmail.com";
            nombre = "Axel Dario Rivera Murillo";
            estado = "activo";
            fecha_creacion = new Date();
            rtn = "0501200209639";
        }};
        Respuesta resultadoCreation = cliente.AddCliente(clientCreation);
        System.out.println(resultadoCreation.getMessage());
        
        
        System.out.println("/////////////////////////////////////////////////////////");
        //Creacion Cliente
        System.out.println("Actualizacion Cliente");
        Cliente clientUpdate = new Cliente(){{
            client_id = 2;
            correo = "dario.rivera@unah.hn";
            nombre = "Axel Dario Rivera Murillo";
            estado = "activo";
            fecha_creacion = new Date();
            rtn = "0501200209662";
        }};
        Respuesta resultadoUpdate = cliente.UpdateCliente(clientUpdate);
        System.out.println(resultadoUpdate.getMessage());
        
        
        System.out.println("/////////////////////////////////////////////////////////");
        //Elimincacion Cliente
        System.out.println("Eliminacion Cliente");
        int clienteId = 4;
        Respuesta resultadoDelete = cliente.DeleteCliente(clienteId);
        System.out.println(resultadoDelete.getMessage());
    }
    
}
