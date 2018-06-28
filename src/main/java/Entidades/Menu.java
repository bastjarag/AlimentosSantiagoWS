/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Sebastián
 */
public class Menu {
    public int id;
    public Date fechaCreacion;
    public int idUsuario;
    public String diaDeSemana;

    public Menu(Date fechaCreacion, int idUsuario, String diaDeSemana) {
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.diaDeSemana = diaDeSemana;
    }

    public Menu(int id, Date fechaCreacion, int idUsuario, String diaDeSemana) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.idUsuario = idUsuario;
        this.diaDeSemana = diaDeSemana;
    }
    
}
