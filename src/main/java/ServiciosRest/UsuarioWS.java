/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import DAO.DAOUsuario;
import EntidadTemporal.LoginCredencial;
import Entidades.Usuario;
import java.util.List;
import javax.servlet.http.HttpSession;
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
@Path("usuario")
public class UsuarioWS {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("traer")
    public String TraerUsuario(String usuario) {
        return "encuentra: " + usuario;
        //return DAOUsuario.TraerUsuario(usuario).usuario + "/" + usuario;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> ListarUsuarios() {
        return DAOUsuario.ListarUsuarios();
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login")
    public String Login(LoginCredencial login) {
        Usuario usuario = DAOUsuario.LoginUsuario(login.usuario, login.password);
        if (usuario != null)
            return "true";
        
        return "false";
    }
}
