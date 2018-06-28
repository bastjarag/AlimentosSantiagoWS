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
public class MenuProducto {
    public int id;
    public int idMenu, idProducto;
    public int stock;

    public MenuProducto(int idMenu, int idProducto, int stock) {
        this.idMenu = idMenu;
        this.idProducto = idProducto;
        this.stock = stock;
    }

    public MenuProducto(int id, int idMenu, int idProducto, int stock) {
        this.id = id;
        this.idMenu = idMenu;
        this.idProducto = idProducto;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
