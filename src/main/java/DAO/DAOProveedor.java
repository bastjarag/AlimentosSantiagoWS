/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Proveedor;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOProveedor {
    public static boolean AgregarProveedor(Proveedor proveedor) {
        CallableStatement cs = Conexion.Conexion.CrearCallableStatement("call SP_AGREGAR_PROVEEDOR(?,?,?,?,?)");
        if (cs == null)
            return false;
        
        try {
            cs.setString("IN_DIRECCION", proveedor.direccion);
            cs.setInt("IN_TELEFONO_FIJO", proveedor.telefonoFijo);
            cs.setInt("IN_TELEFONO_CELULAR", proveedor.telefonoCelular);
            cs.setString("IN_NOMBRE", proveedor.nombre);
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
