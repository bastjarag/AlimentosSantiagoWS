/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Producto;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import Conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián
 */
public class DAOProducto {
    public static boolean AgregarProducto(Producto producto) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_AGREGAR_PRODUCTO(?,?,?,?,?)");
        if (cs == null)
            return false;
        
        try {
            cs.setString("IN_NOMBRE", producto.nombre);
            cs.setInt("IN_PRECIO", producto.precio);
            cs.setString("IN_DESCRIPCION", producto.descripcion);
            cs.setInt("IN_STOCK", producto.stock);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            System.out.println("Numero filas insertadas: " + cs.getInt("OUT_RPTA"));
            return true;
        }
        catch (SQLException exc) {
            System.err.print(exc);
        }
        return false;
    }
    
    public static List<Producto> ListarProductos() {
        ResultSet resultado = Conexion.RealizarConsulta("SELECT * FROM BJARA.PRODUCTOS");
        List<Producto> productos = new ArrayList<Producto>();
        if (resultado == null)
            return null;
        
        try {
            while (resultado.next()) {                
                Producto producto = new Producto(resultado.getInt("ID_PRODUCTO"), resultado.getString("NOMBRE"), 
                        resultado.getInt("PRECIO"), resultado.getString("DESCRIPCION"), resultado.getInt("STOCK"));
                productos.add(producto);
            }
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return productos;
    }
    
    public static Producto ActualizarProducto(Producto producto) {
        CallableStatement cs = Conexion.CrearCallableStatement("call ");
    }
}
