package br.com.contivo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.contivo.bo.VagaBO;
import br.com.contivo.to.VagaTO;



@Path("/vaga")
public class VagaResource {
	VagaBO vb = new VagaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VagaTO> buscar() {
		return vb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<VagaTO> buscar(@PathParam("id") int id) {
		return vb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(VagaTO vaga, @Context UriInfo uriInfo) {
		vb.cadastrar(vaga);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(vaga.getIdVaga()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(VagaTO vaga, @PathParam("id") int id) {
		vaga.setIdVaga(id);
		vb.atualizar(vaga);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		vb.excluir(id);
	}
}
