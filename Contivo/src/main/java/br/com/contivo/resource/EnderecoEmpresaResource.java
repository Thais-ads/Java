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

import br.com.contivo.bo.EnderecoEmpresaBO;
import br.com.contivo.to.EnderecoEmpresaTO;

public class EnderecoEmpresaResource {
	EnderecoEmpresaBO eb = new EnderecoEmpresaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoEmpresaTO> buscar() {
		return eb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoEmpresaTO> buscar(@PathParam("id") int id) {
		return eb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EnderecoEmpresaTO enderecoEmpresa, @Context UriInfo uriInfo) {
		eb.cadastrar(enderecoEmpresa);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(enderecoEmpresa.getIdEndereco()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(EnderecoEmpresaTO enderecoEmpresa, @PathParam("id") int id) {
		enderecoEmpresa.setIdEndereco(id);
		eb.atualizar(enderecoEmpresa);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		eb.excluir(id);
	}
}
