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

import br.com.contivo.bo.CurriculoBO;
import br.com.contivo.to.CurriculoTO;

@Path("/curriculo")
public class CurriculoResource {
	CurriculoBO cb = new CurriculoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CurriculoTO> buscar() {
		return cb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CurriculoTO> buscar(@PathParam("id") int id) {
		return cb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(CurriculoTO curriculo, @Context UriInfo uriInfo) {
		cb.cadastrar(curriculo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(curriculo.getIdcurriculo()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(CurriculoTO curriculo, @PathParam("id") int id) {
		curriculo.setIdcurriculo(id);
		cb.atualizar(curriculo);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		cb.excluir(id);
	}
}
