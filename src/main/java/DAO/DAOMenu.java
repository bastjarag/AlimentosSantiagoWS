/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Menu;
import java.sql.CallableStatement;
import Conexion.Conexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastián
 */
public class DAOMenu {
    
    public static List<Menu> ListarMenu() {
        ResultSet rs = Conexion.RealizarConsulta("select * from BJARA.MENUS");
        List<Menu> menus = new ArrayList<>();
        try {
            while (rs.next()) {
                Menu menu = new Menu(rs.getDate("FECHA_CREACION"), rs.getInt("ID_USUARIO"), rs.getDate("FECHA_VENTA"));
                menus.add(menu);
            }
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return menus;
    }
    
    public static Menu Insertar(Menu menu) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_CREAR_MENU(?,?,?,?)");
        System.out.println("Insertando menu.");
        try {
            cs.setDate("IN_FECHA_CREACION", new Date(menu.fechaCreacion.getTime()));
            cs.setInt("IN_ID_USUARIO", menu.idUsuario);
            cs.setDate("IN_FECHA_PUBLICACION", new Date(menu.fechaPublicacion.getTime()));
            cs.registerOutParameter("OUT_ID_MENU", Types.INTEGER);
            cs.execute();
            menu.id = cs.getInt("OUT_ID_MENU");
            System.out.println("Menu registrado...");
        }
        catch (SQLException exc) {
            System.err.println(exc);
        }
        return menu;    
    }
}
