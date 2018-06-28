/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.TEC;
import Entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOTEC {

    public static boolean AgregarTEC(TEC tec, Usuario usuario) {
        CallableStatement cs = Conexion.Conexion.CrearCallableStatement("call SP_AGREGAR_TEC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if (cs == null) {
            return false;
        }

        try {
            cs.setDate("IN_FECHA_REGISTRO", new Date(System.currentTimeMillis()));
            cs.setString("IN_NOMBRES", usuario.nombre);
            cs.setString("IN_AP_PATERNO", usuario.apellPaterno);
            cs.setString("IN_AP_MATERNO", usuario.apellMaterno);
            cs.setInt("IN_RUT", usuario.rut);
            cs.setString("IN_DV_RUT", String.valueOf(usuario.divRut));
            cs.setString("IN_DIRECCION", usuario.direccion);
            cs.setInt("IN_TELEFONO_FIJO", usuario.telefono);
            cs.setInt("IN_TELEFONO_CELULAR", usuario.celular);
            cs.setString("IN_EMAIL", usuario.email);
            cs.setString("IN_USUARIO", usuario.usuario);
            cs.setString("IN_PW", usuario.password);
            cs.setInt("IN_CARTERA", usuario.cartera);
            cs.setBoolean("IN_IS_VIGENTE_CONVENIO", tec.convenioVigente);
            cs.setInt("IN_COMPRA_MES", tec.compraMes);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            System.out.println("Numero filas insertadas: " + cs.getInt("OUT_RPTA"));
            return true;
        } catch (SQLException exc) {
            System.err.print(exc);
        }
        return false;
    }
}
