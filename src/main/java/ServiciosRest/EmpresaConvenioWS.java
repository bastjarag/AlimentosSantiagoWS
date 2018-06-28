/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosRest;

import DAO.DAOEmpresaConvenio;
import Entidades.EmpresaConvenio;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sebastián
 */
@Path("empresa")
public class EmpresaConvenioWS {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String AgregarEmpresa(EmpresaConvenio empresa) {
        return String.valueOf(DAOEmpresaConvenio.AgregarEmpresaConvenio(empresa));
    }
}
