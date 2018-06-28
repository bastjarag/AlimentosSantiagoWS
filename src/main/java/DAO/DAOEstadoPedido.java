/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.EstadoPedido;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sebastián
 */
public class DAOEstadoPedido {

    public static ArrayList<EstadoPedido> ListarEstadosPedido() {
        ArrayList<EstadoPedido> estadosPedido = new ArrayList<EstadoPedido>();
        ResultSet resultSet = Conexion.RealizarConsulta("select * from estado_pedidos");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    EstadoPedido estadoPedido = new EstadoPedido(resultSet.getInt("ID_ESTADO"), resultSet.getString("DESCRIPCION"));
                    estadosPedido.add(estadoPedido);
                }
            }
            catch (SQLException exc) {
                System.err.println(exc);
            }
        }
        return estadosPedido;
    }
}
