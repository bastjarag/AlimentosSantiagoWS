/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastián
 */
public class DAOUsuario {

    public static Usuario Insertar(Usuario usuario) {
        CallableStatement call = Conexion.CrearCallableStatement("{call sp_agregar_usuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        if (call == null) {
            return null;
        }
        
        try {
            call.setDate("IN_FECHA_REGISTRO", new Date(System.currentTimeMillis()));
            call.setString("IN_NOMBRES", usuario.nombre);
            call.setString("IN_AP_PATERNO", usuario.apellPaterno);
            call.setString("IN_AP_MATERNO", usuario.apellMaterno);
            call.setInt("IN_RUT", usuario.rut);
            call.setString("IN_DV_RUT", String.valueOf(usuario.divRut));
            call.setString("IN_DIRECCION", usuario.direccion);
            call.setInt("IN_TELEFONO_FIJO", usuario.telefono);
            call.setInt("IN_TELEFONO_CELULAR", usuario.celular);
            call.setString("IN_EMAIL", usuario.email);
            call.setString("IN_USUARIO", usuario.usuario);
            call.setString("IN_PW", usuario.password);
            call.setInt("IN_CARTERA", usuario.cartera);
            call.registerOutParameter("OUT_RPTA", Types.INTEGER);
            call.execute();
            System.out.println("Numero filas insertadas: " + call.getInt("OUT_RPTA"));
            call.close();
            return TraerUsuario(usuario.nombre);
        } catch (SQLException exc) {
            System.err.println("Error al insertar usuario");
            System.err.println(exc.getErrorCode());
            System.err.println(exc.getMessage());
        }
        return null;
    }

    public static ArrayList<Usuario> ListarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ResultSet resultSet = Conexion.RealizarConsulta("select * from usuarios");
        System.out.println("Consultando usuario");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Usuario usuario = new Usuario(resultSet.getInt("ID_USUARIO"),
                            resultSet.getDate("FECHA_REGISTRO"), resultSet.getString("NOMBRES"),
                            resultSet.getString("AP_PATERNO"), resultSet.getString("AP_MATERNO"),
                            resultSet.getInt("RUT"), resultSet.getString("DV_RUT").charAt(0),
                            resultSet.getString("DIRECCION"), resultSet.getInt("TELEFONO_FIJO"),
                            resultSet.getInt("TELEFONO_CELULAR"), resultSet.getString("EMAIL"),
                            resultSet.getString("USUARIO"), resultSet.getString("PW"), resultSet.getInt("CARTERA"));
                    usuarios.add(usuario);
                }
            } catch (SQLException exc) {
                System.err.print(exc);
            }
        }
        return usuarios;
    }

    public static boolean ActualizarUsuario(Usuario usuario) {
        CallableStatement call = Conexion.CrearCallableStatement("{call SP_MODIFICAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        int cambio = 0;
        try {
            call.setDate("IN_FECHA_REGISTRO", new Date(System.currentTimeMillis()));
            call.setString("IN_NOMBRES", usuario.nombre);
            call.setString("IN_AP_PATERNO", usuario.apellPaterno);
            call.setString("IN_AP_MATERNO", usuario.apellMaterno);
            call.setInt("IN_RUT", usuario.rut);
            call.setString("IN_DV_RUT", String.valueOf(usuario.divRut));
            call.setString("IN_DIRECCION", usuario.direccion);
            call.setInt("IN_TELEFONO_FIJO", usuario.telefono);
            call.setInt("IN_TELEFONO_CELULAR", usuario.celular);
            call.setString("IN_EMAIL", usuario.email);
            call.setString("IN_USUARIO", usuario.usuario);
            call.setString("IN_PW", usuario.password);
            call.setInt("IN_CARTERA", usuario.cartera);
            call.registerOutParameter("OUT_RPTA", Types.INTEGER);
            call.execute();
            cambio = call.getInt("OUT_RPTA");
            System.out.println("Numero filas insertadas: " + cambio);
            call.close();
        } catch (SQLException exc) {
            System.err.println(exc);
        }
        return cambio >= 1;
    }

    public static boolean BorrarUsuario(int rut, char digVerif) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_ELIMINAR_USUARIO(?,?,?)");
        if (cs == null) {
            return false;
        }

        try {
            cs.setInt("IN_RUT", rut);
            cs.setString("IN_DV_RUT", new String(new char[]{digVerif}));
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            System.out.println("Numero filas afectadas: " + cs.getInt("OUT_RPTA"));
            return true;
        } catch (SQLException exc) {
            System.err.println(exc);
        }

        return false;
    }

    public static Usuario TraerUsuario(String nombre) {
        String query = "SELECT * FROM BJARA.USUARIOS WHERE usuario = '%s'";
        query = String.format(query, nombre);
        ResultSet resultado = Conexion.RealizarConsulta(query);
        try {
            if (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.id = resultado.getInt("ID_USUARIO");
                usuario.fechaRegistro = resultado.getDate("FECHA_REGISTRO");
                usuario.nombre = resultado.getString("NOMBRES");
                usuario.apellPaterno = resultado.getString("AP_PATERNO");
                usuario.apellMaterno = resultado.getString("AP_MATERNO");
                usuario.rut = resultado.getInt("RUT");
                usuario.divRut = resultado.getString("DV_RUT").charAt(0);
                usuario.direccion = resultado.getString("DIRECCION");
                usuario.telefono = resultado.getInt("TELEFONO_FIJO");
                usuario.celular = resultado.getInt("TELEFONO_CELULAR");
                usuario.email = resultado.getString("EMAIL");
                usuario.usuario = resultado.getString("USUARIO");
                usuario.password = resultado.getString("PW");
                usuario.cartera = resultado.getInt("CARTERA");
                System.out.println("Encuentra usuario: " + usuario.nombre);
                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Usuario LoginUsuario(String nombreUsuario, String password) {
        //%s pone string
        String query = "SELECT count(*) as EXISTENCIA FROM BJARA.USUARIOS WHERE USUARIO = '%s' and PW='%s'";
        query = String.format(query, nombreUsuario, password);
        ResultSet resultado = Conexion.RealizarConsulta(query);
        try {
            if (resultado.next()) {
                // Si encuentra mas de un resultado entonces existe.
                if (resultado.getInt("EXISTENCIA") >= 1) {
                    System.out.println("Existe usuario... conectando.");
                    return TraerUsuario(nombreUsuario);
                }
            }
        } catch (SQLException exc) {
            System.err.println(exc);
        }
        return null;
    }
}
