/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.ProductoMenu;
import Conexion.Conexion;
import Entidades.Producto;
import java.sql.CallableStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastián
 */
public class DAOProductoMenu {

    public static boolean Insertar(ProductoMenu productoMenu) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_AGREGAR_PROD_MENU(?,?,?,?)");
        int cambios = 0;
        System.out.println("Producto menu " + productoMenu.toString());
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

    public static List<Producto> ListarMenu(Date fechaVenta) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        ResultSet rs = Conexion.RealizarConsulta(String.format(
                "SELECT * FROM VIEW_LISTAR_PROD_EN_MENU WHERE TRUNC(FECHA_VENTA) = TRUNC(TO_DATE('%s', 'DD-MM-YYYY'))",
                dateFormat.format(fechaVenta)));

        List<Producto> productos = new ArrayList<>();
        try {
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("ID_PRODUCTO"), rs.getString("NOMBRE"), rs.getInt("PRECIO"), 
                        rs.getString("DESCRIPCION"), rs.getInt("STOCK"));
                productos.add(producto);
            }
        } catch (SQLException exc) {
            System.err.println(exc);
        }
        return productos;
    }
}
