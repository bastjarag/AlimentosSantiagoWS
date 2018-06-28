/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.ProductoProveedor;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOProductoProveedor {
    public static boolean AgregarProductoProveedor(ProductoProveedor productoProveedor) {
        CallableStatement cs = Conexion.Conexion.CrearCallableStatement("call SP_AGREGAR_PRODUCTO_PROVEEDOR(?,?,?)");
        if (cs == null)
            return false;
        
        try {
            cs.setInt("IN_ID_PROVEEDOR", productoProveedor.idProveedor);
            cs.setInt("IN_ID_PRODUCTO", productoProveedor.idProducto);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            System.out.println("Numero filas insertadas: " + cs.getInt("OUT_RPTA"));
            return true;
        }
        catch (SQLException exc) {
            System.err.println(exc);
        }
        return false;
    }
}
