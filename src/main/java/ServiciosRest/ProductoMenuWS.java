/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import DAO.DAOProducto;
import DAO.DAOProductoMenu;
import Entidades.Producto;
import Entidades.ProductoMenu;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sebastián
 */
@Path("producto_menu")
public class ProductoMenuWS {

    @POST
    @Path("/registrar_prod_menu")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> RegistrarProductoMenu(ProductoMenu[] productos) {
        for (ProductoMenu producto : productos) {
            DAOProductoMenu.Insertar(producto);
        }
        return DAOProducto.ListarProductosConStock();
    }

    @GET
    @Path("/{fechaMenu}")
    //@Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> TraerMenu(@PathParam("fechaMenu") String fechaMenu) {
        System.out.println("Esto trae " + fechaMenu);
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        List<Producto> productos = new ArrayList<>();
        try {
            productos = DAOProductoMenu.ListarMenu(df.parse(fechaMenu));
        } catch (ParseException exc) {
            System.err.println(exc);
        }
        return productos;
    }
}
