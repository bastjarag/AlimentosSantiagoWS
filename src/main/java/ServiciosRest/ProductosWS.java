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
import java.util.List;
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
@Path("producto")
public class ProductosWS {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> ListarProductos() {
        return DAOProducto.ListarProductos();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String AgregarProducto(Producto producto) {
        return String.valueOf(DAOProducto.AgregarProducto(producto));
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String ActualizarProductos(Producto producto) {
        return String.valueOf(DAOProducto.ActualizarProducto(producto));
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String BorrarProducto(@PathParam("id") int id) {
        return String.valueOf(DAOProducto.BorrarProducto(id));
    }
    
    @GET
    @Path("/productos_stock")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> ListarProductosConStock() {
        return DAOProducto.ListarProductosConStock();
    }
}
