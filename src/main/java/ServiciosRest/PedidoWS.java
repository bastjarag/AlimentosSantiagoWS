package ServiciosRest;

import DAO.DAOPedido;
import EntidadTemporal.PedidoTemp;
import Entidades.Pedido;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Basti
 */
@Path("pedido")
public class PedidoWS {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> ListarPedidos() {
        return DAOPedido.ListarPedidos();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String AgregarPedido(PedidoTemp pedido) {
        return String.valueOf(DAOPedido.AgregarPedido(pedido.ToPedido()));
    }

}
