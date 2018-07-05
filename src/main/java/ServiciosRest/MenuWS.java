/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import DAO.DAOMenu;
import Entidades.Menu;
import javax.ws.rs.Consumes;
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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Menu Insertar(Menu menu) {
        System.out.println("Insertar menu.");
        return DAOMenu.Insertar(menu);
    }
}
