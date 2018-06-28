/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import DAO.DAOUsuario;
import EntidadTemporal.LoginCredencial;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sebastián
 */
@Path("test")
public class TestWS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> Listar() {
        List<String> lista = new ArrayList<>();
        lista.add("control 1");
        lista.add("control 2");
        return lista;
    }
}
