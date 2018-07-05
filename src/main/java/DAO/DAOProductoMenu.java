/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.ProductoMenu;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOProductoMenu {
    public static boolean Insertar(ProductoMenu productoMenu) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_AGREGAR_PROD_MENU(?,?,?,?)");
        int cambios = 0;
        try {
            cs.setInt("IN_ID_PRODUCTO", productoMenu.idProducto);
            cs.setInt("IN_ID_MENU", productoMenu.idMenu);
            cs.setInt("IN_STOCK", productoMenu.stock);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            cambios = cs.getInt("OUT_RPTA");
            System.out.println("Se agregaron " + cambios + " filas en Producto Menu");
            
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return cambios > 0;
    }
}
