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

import br.com.contivo.bo.FormacaoAcademicaBO;
import br.com.contivo.to.FormacaoAcademicaTO;



@Path("/formacaoacademica")
public class FormacaoAcademicaResource {
	FormacaoAcademicaBO fb = new FormacaoAcademicaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FormacaoAcademicaTO> buscar() {
		return fb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FormacaoAcademicaTO> buscar(@PathParam("id") int id) {
		return fb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(FormacaoAcademicaTO formacaoAcademica, @Context UriInfo uriInfo) {
		fb.cadastrar(formacaoAcademica);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(formacaoAcademica.getIdformacao()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(FormacaoAcademicaTO formacaoAcademica, @PathParam("id") int id) {
		formacaoAcademica.setIdformacao(id);
		fb.atualizar(formacaoAcademica);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		fb.excluir(id);
	}
}

