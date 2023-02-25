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

import br.com.contivo.bo.FeedBackBO;
import br.com.contivo.to.FeedBackTO;


@Path("/feedback")
public class FeedBackResource {
	FeedBackBO fb = new FeedBackBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FeedBackTO> buscar() {
		return fb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FeedBackTO> buscar(@PathParam("id") int id) {
		return fb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(FeedBackTO feedBack, @Context UriInfo uriInfo) {
		fb.cadastrar(feedBack);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(feedBack.getIdFeedback()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(FeedBackTO feedBack, @PathParam("id") int id) {
		feedBack.setIdFeedback(id);
		fb.atualizar(feedBack);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		fb.excluir(id);
	}
}
