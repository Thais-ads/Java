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

import br.com.contivo.bo.SkillBO;
import br.com.contivo.to.SkillTO;

@Path("/skill")
public class SkillResource {
	SkillBO sb = new SkillBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SkillTO> buscar() {
		return sb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SkillTO> buscar(@PathParam("id") int id) {
		return sb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(SkillTO skill, @Context UriInfo uriInfo) {
		sb.cadastrar(skill);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(skill.getIdSkill()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(SkillTO skill, @PathParam("id") int id) {
		skill.setIdSkill(id);
		sb.atualizar(skill);
		return Response.ok().build();
	}
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) {
		sb.excluir(id);
	}
}
