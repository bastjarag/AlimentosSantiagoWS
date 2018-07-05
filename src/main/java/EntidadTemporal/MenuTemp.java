/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadTemporal;

import Entidades.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Sebastián
 */
public class MenuTemp {
    public int id;
    public String fechaCreacion;
    public int idUsuario;
    public String fechaPublicacion;

    public MenuTemp() {
    }

    public MenuTemp(String fechaCreacion, int idUsuario, String fechaPublicacion) {
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.fechaPublicacion = fechaPublicacion;
    }

    public MenuTemp(int id, String fechaCreacion, int idUsuario, String fechaPublicacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public Menu ToMenu() {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        Menu menu = null;
        try {
            menu = new Menu(this.id, df.parse(fechaCreacion), idUsuario, df.parse(fechaPublicacion));
        } catch (ParseException exc) {
            System.err.println(exc);
        }
        return menu;
    }
}
