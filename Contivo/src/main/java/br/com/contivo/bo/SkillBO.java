package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.SkillDAO;
import br.com.contivo.to.SkillTO;

public class SkillBO {
	SkillDAO sd = null;
	
	/*
	 * GET-ALL
	 */
	public List<SkillTO> listar() {
		sd = new SkillDAO();
		return sd.listarTodos();
	}
	
	
	/*
	 * GET-BY-ID
	 */
	public List<SkillTO> listar(int id) {
		sd = new SkillDAO();
		return sd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(SkillTO skill) {
		sd = new SkillDAO();
		sd.inserir(skill);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(SkillTO skill) {
		sd = new SkillDAO();
		sd.alterar(skill);
	}
	
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		sd = new SkillDAO();
		sd.excluir(id);
	}
	
	

}
