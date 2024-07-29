/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatospoo.Models;

import javax.swing.text.html.parser.Entity;


/**
 *
 * @author arrivera
 */
public class Respuesta {
    private boolean Ok;
    private String Codigo;
    private String Mensaje;

    public void Success(boolean ok, String codigo, String mensaje) {
        this.Ok = ok;
        this.Codigo = codigo;
        this.Mensaje = mensaje;
    }

    public void Fault(boolean ok, String codigo, String mensaje) {
        this.Ok = ok;
        this.Codigo = codigo;
        this.Mensaje = mensaje;
    }

    public String getMessage() {
        return this.Mensaje;
    }

    public String getCodigo() {
        return this.Codigo;
    }

    public boolean getOk() {
        return this.Ok;
    }

    public void setMessage(String mensaje) {
        this.Mensaje = mensaje;
    }

    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }

    public void setOk(boolean ok) {
        this.Ok = ok;
    }
}