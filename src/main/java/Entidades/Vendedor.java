/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián
 */
public class Vendedor {
    public int id;
    public int sueldo;

    public Vendedor(int sueldo) {
        this.sueldo = sueldo;
    }

    public Vendedor(int id, int comision) {
        this.id = id;
        this.sueldo = comision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
