/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import DAO.DAOMenu;
import EntidadTemporal.MenuTemp;
import Entidades.Menu;
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
@Path("menu")
public class MenuWS {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> ListarMenus() {
        return DAOMenu.ListarMenu();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Menu InsertarMenus(MenuTemp menu) {
        System.out.println("Insertar menu.");
        return DAOMenu.Insertar(menu.ToMenu());
    }
    
}
