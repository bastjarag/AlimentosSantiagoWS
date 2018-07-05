/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import DAO.DAOUsuario;
import EntidadTemporal.LoginCredencial;
import EntidadTemporal.TicketLogin;
import Entidades.Usuario;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    @Path("login")
    public TicketLogin Login(LoginCredencial login) {
        System.out.println("Usuario " + login.usuario + " está intentando loguearse.");
        Usuario usuario = DAOUsuario.LoginUsuario(login.usuario, login.password);
       
        if (usuario != null) {
            return new TicketLogin(usuario.usuario, new Date(System.currentTimeMillis()));
        }
        return null;
    }

    @DELETE
    @Path("/{rut}&{dv_rut}")
    @Produces(MediaType.TEXT_PLAIN)
    public String Borrar(@PathParam("rut") int rut, @PathParam("dv_rut") String dv_rut) {
        return String.valueOf(DAOUsuario.BorrarUsuario(rut, dv_rut.charAt(0)));
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario Agregar(Usuario usuario) {
        return DAOUsuario.Insertar(usuario);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String Editar(Usuario usuario) {
        System.out.println(String.valueOf(DAOUsuario.ActualizarUsuario(usuario)));
        return String.valueOf(DAOUsuario.ActualizarUsuario(usuario));
    }
}
