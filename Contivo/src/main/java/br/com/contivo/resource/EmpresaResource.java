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

import br.com.contivo.bo.EmpresaBO;
import br.com.contivo.to.EmpresaTO;


@Path("/empresa")
public class EmpresaResource {
	EmpresaBO eb = new EmpresaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpresaTO> buscar() {
		return eb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpresaTO> buscar(@PathParam("id") int id) {
		return eb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EmpresaTO empresa, @Context UriInfo uriInfo) {
		eb.cadastrar(empresa);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(empresa.getIdEmpresa()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(EmpresaTO empresa, @PathParam("id") int id) {
		empresa.setIdEmpresa(id);
		eb.atualizar(empresa);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		eb.excluir(id);
	}
}
