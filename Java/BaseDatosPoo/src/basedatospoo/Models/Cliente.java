/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatospoo.Models;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author arrivera
 */
public class Cliente {
    
    public int client_id;
    public String nombre;
    public String correo;
    public String rtn;
    public String estado;
    public Date fecha_creacion;
    
    public static final String[] columnas = {"Cliente ID", "Nombre", "Correo", "RTN", "Estado"};
    
    public Cliente(int cliente_id, String nombre, String correo, String rtn, String estado, Date fecha_creacion) {
        this.client_id = cliente_id;
        this.nombre = nombre;
        this.correo = correo;
        this.rtn = rtn;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
    }

    public Cliente() {}

    @Override
    public String toString() {
        return nombre + "-" + rtn;
    }

    public Vector toVector() {

        Vector temp = new Vector();

        temp.add(client_id);
        temp.add(nombre);
        temp.add(correo);
        temp.add(rtn);
        temp.add(estado);
        temp.add(fecha_creacion);// se descarta, porque no se encuentra en el array de columnas

        return temp;

    }
    
}
