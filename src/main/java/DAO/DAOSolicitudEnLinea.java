/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.SolicitudEnLinea;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOSolicitudEnLinea {
    public static boolean AgregarSolicitudenLinea(SolicitudEnLinea solicitudEnLinea) {
        CallableStatement cs = Conexion.Conexion.CrearCallableStatement("call SP_AGREGAR_SOL_EN_LINEA(?,?,?,?)");
        if (cs == null)
            return false;
        
        try {
            cs.setDate("IN_FECHA_HORA", new Date(solicitudEnLinea.fechaHora.getTime()));
            cs.setString("IN_COMENTARIO", solicitudEnLinea.comentario);
            cs.setInt("IN_ID_USUARIO", solicitudEnLinea.idUsuario);
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
