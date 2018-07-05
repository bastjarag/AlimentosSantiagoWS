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
        if (cs == null) {
            return false;
        }

        int cambios = 0;
        try {
            cs.setString("IN_NOMBRE", producto.nombre);
            cs.setInt("IN_PRECIO", producto.precio);
            cs.setString("IN_DESCRIPCION", producto.descripcion);
            cs.setInt("IN_STOCK", producto.stock);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            cambios = cs.getInt("OUT_RPTA");
            System.out.println("Numero filas insertadas: " + cambios);
        } catch (SQLException exc) {
            System.err.print(exc);
        }
        return cambios >= 1;
    }

    public static List<Producto> ListarProductos() {
        return ProductosDeResultSet(Conexion.RealizarConsulta("SELECT * FROM BJARA.PRODUCTOS order by productos.nombre"));
    }

    public static boolean ActualizarProducto(Producto producto) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_MODIFICAR_PRODUCTO(?,?,?,?,?,?)");
        int cambios = 0;
        if (cs == null) {
            return false;
        }

        System.out.println("Actualizando producto de id: " + producto.id + " a " + producto.nombre);
        System.out.println(producto);
        try {
            cs.setInt("IN_ID_PRODUCTO", producto.id);
            cs.setString("IN_NOMBRE", producto.nombre.trim());
            cs.setInt("IN_PRECIO", producto.precio);
            cs.setString("IN_DESCRIPCION", producto.descripcion.trim());
            cs.setInt("IN_STOCK", producto.precio);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            cambios = cs.getInt("OUT_RPTA");
            System.out.println("Numero filas actualizadas: " + cambios);
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return cambios >= 1;
    }

    public static Producto TraerProducto(int id) {
        Producto producto = new Producto();
        ResultSet resultado = Conexion.RealizarConsulta("SELECT * FROM BJARA.PRODUCTOS WHERE ID_PRODUCTO = 1");
        try {
            if (resultado.next()) {
                producto.id = resultado.getInt("ID_PRODUCTO");
                producto.nombre = resultado.getString("NOMBRE");
                producto.precio = resultado.getInt("PRECIO");
                producto.descripcion = resultado.getString("DESCRIPCION");
                producto.stock = resultado.getInt("STOCK");
            }
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return producto;
    }

    public static boolean BorrarProducto(int id) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_ELIMINAR_PRODUCTO(?,?)");
        if (cs == null) {
            return false;
        }

        int cambios = 0;
        try {
            cs.setInt("IN_ID_PRODUCTO", id);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            cambios = cs.getInt("OUT_RPTA");
            System.out.println("Eliminadas " + cambios + " filas.");
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return cambios >= 1;
    }

    public static List<Producto> ListarProductosConStock() {
        return ProductosDeResultSet(Conexion.RealizarConsulta("select * from VIEW_LISTAR_PRODUCTOS_EN_STOCK"));
    }

    public static List<Producto> ProductosDeResultSet(ResultSet resultado) {
        if (resultado == null) {
            return new ArrayList<>();
        }

        List<Producto> productos = new ArrayList<>();
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
}
