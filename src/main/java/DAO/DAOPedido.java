/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Pedido;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOPedido {
    public static boolean AgregarPedido(Pedido pedido) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_AGREGAR_PEDIDO(?,?,?,?,?,?,?)");
        if (cs == null)
            return false;
        try {
            cs.setBoolean("IN_IS_RETIRO_TIENDA", pedido.retiroTienda);
            cs.setDate("IN_FECHA_HORA", new Date(pedido.fechaHora.getTime()));
            cs.setString("IN_COMENTARIO", pedido.comentario);
            cs.setInt("IN_ID_ESTADO", pedido.idEstado);
            cs.setInt("IN_ID_USUARIO", pedido.idUsuario);
            cs.setInt("IN_TOTAL_COMPRA", pedido.totalCompra);
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            cs.execute();
            System.out.println("Numero filas insertadas: " + cs.getInt("OUT_RPTA"));
            cs.close();
            return true;
        }
        catch (SQLException exc) {
            System.err.print(exc);
        }
        return false;
    }
}
