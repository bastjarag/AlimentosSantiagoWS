/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sebastián
 */
public class Conexion {

    public Connection conexion;
    public String usuario = "bjara";
    public String clave = "raval12";

    private static Conexion instancia;

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException exc) {
            System.out.println("Clase no encontrada");
            return;
        }
        System.out.println("Clase encontrada, estableciendo conexión");

        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@159.89.86.128:4921:XE", usuario, clave);
        } catch (SQLException exc) {
            System.out.println("Error al realizar la conexión.");
            System.out.println(exc.getMessage());
            return;
        }
        System.out.println("Conexión obtenida");
        if (conexion != null) {
            System.out.println("Conexión realizada con éxito");
        } else {
            System.out.println("Conexión errada por favor cambié los parametros de conexión.");
        }
    }

    /**
     * Obtiene la instancia original creada.
     *
     * @return OracleConexion
     */
    public static Conexion Instancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        if (instancia.conexion == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /**
     * Crea un statement funcional rapidamente desde el objeto conexión de la
     * instancia.
     *
     * @return Statement de la conexión por defecto.
     */
    public static Statement CrearStatement() {
        try {
            return Instancia().conexion.createStatement();
        } catch (SQLException exc) {
            System.out.println("Error al crear el statement.");
            System.out.println(exc.getMessage());
        }
        return null;
    }

    public static CallableStatement CrearCallableStatement(String llamado) {
        try {
            return Instancia().conexion.prepareCall(llamado);
        } catch (SQLException exc) {
            System.out.println("Error al crear el CallableStatement");
            System.out.println(exc.getMessage());
        }
        return null;
    }

    /**
     *
     * @param query Consulta a ejecutar.
     * @return Resultado consulta.
     */
    public boolean EjecutarQuery(String query) {
        Statement statement;
        try {
            statement = conexion.createStatement();
            statement.execute(query);
        } catch (SQLException exc) {
            System.out.println("====== ERROR INESPERADO AL EJECUTAR CONSULTA ======");
            System.out.println(exc.getMessage());
            return false;
        }
        return true;
    }

    public static ResultSet RealizarConsulta(String query) {
        return Instancia().Consultar(query);
    }

    public ResultSet Consultar(String query) {
        Statement statement;
        try {
            statement = conexion.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException exc) {
            System.out.println("====== ERROR INESPERADO AL CONSULTAR DATOS ======");
            System.out.println(exc.getMessage());
            return null;
        }
    }
}
