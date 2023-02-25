package br.com.contivo.resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.contivo.bo.ColaboradorBO;
import br.com.contivo.to.ColaboradorTO;

@Path("/colaborador")
public class ColadoradorResource {

	ColaboradorBO cd = new ColaboradorBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ColaboradorTO> buscar() {
		return cd.listar();
	}

	// GET-BY-ID
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ColaboradorTO> buscar(@PathParam("id") int id) {
		return cd.listarId(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ColaboradorTO colaborador, @Context UriInfo uriInfo) {
		cd.cadastrar(colaborador);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(colaborador.getIdColaborador()));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ColaboradorTO colaborador, @PathParam("id") int id) {
		colaborador.setIdColaborador(id);
		cd.atualizar(colaborador);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		cd.excluir(id);
	}
}
