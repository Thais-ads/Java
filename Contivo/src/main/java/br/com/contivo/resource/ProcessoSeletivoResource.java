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

import br.com.contivo.bo.ProcessoSeletivoBO;
import br.com.contivo.to.ProcessoSeletivoTO;


@Path("/processoseletivo")
public class ProcessoSeletivoResource {
	ProcessoSeletivoBO pb = new ProcessoSeletivoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProcessoSeletivoTO> buscar() {
		return pb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProcessoSeletivoTO> buscar(@PathParam("id") int id) {
		return pb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProcessoSeletivoTO processo, @Context UriInfo uriInfo) {
		pb.cadastrar(processo);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(processo.getIdProcessoSeletivo()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(ProcessoSeletivoTO processo, @PathParam("id") int id) {
		processo.setIdProcessoSeletivo(id);
		pb.atualizar(processo);;
		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		pb.excluir(id);
	}
}
