/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.EmpresaConvenio;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Sebastián
 */
public class DAOEmpresaConvenio {

    public static boolean AgregarEmpresaConvenio(EmpresaConvenio empresaConvenio) {
        CallableStatement cs = Conexion.CrearCallableStatement("call SP_AGREGAR_EMPRESA_CONV(?,?,?,?,?,?,?,?,?)");
        if (cs == null) {
            return false;
        }
        System.out.println("Agregando empresa: " + empresaConvenio.nombre);
        try {
            System.out.println("Preparando call");
            cs.setInt("IN_SALDO_MES", empresaConvenio.saldoMes);
            cs.setInt("IN_TELEFONO_FIJO", empresaConvenio.telefono);
            cs.setInt("IN_TELEFONO_CELULAR", empresaConvenio.celular);
            cs.setString("IN_DIRECCION", empresaConvenio.direccion);
            cs.setString("IN_URL_PLANILLA", empresaConvenio.urlPlanilla);
            cs.setString("IN_URL_CONTRATO", empresaConvenio.urlContrato);
            cs.setString("IN_NOMBRE", empresaConvenio.nombre);
            cs.setInt("IN_IS_VIGENTE_CONVENIO", empresaConvenio.convenio ? 1 : 0);
            System.out.println("Registrando parametros de salida");
            cs.registerOutParameter("OUT_RPTA", Types.INTEGER);
            System.out.println("Por ejecutar call");
            cs.execute();
            System.out.println("Numero filas insertadas: " + cs.getInt("OUT_RPTA"));
            cs.close();
            return true;
        } catch (Exception exc) {
            System.err.print(exc);
        }
        return false;
    }
}
