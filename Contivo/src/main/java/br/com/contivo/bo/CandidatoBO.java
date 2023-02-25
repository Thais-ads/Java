package br.com.contivo.bo;


import java.util.List;

import br.com.contivo.dao.CandidatoDAO;
import br.com.contivo.to.CandidatoTO;

public class CandidatoBO {
	private CandidatoDAO cd = null;	
	/*
	 * GET-ALL
	 */
	public List<CandidatoTO> listar() {
		cd = new CandidatoDAO();
		return cd.listarTodos();
		}	
	
	/*
	 * GET_BY_ID
	 */
	public List<CandidatoTO> listar(int id) {
		cd = new CandidatoDAO();
		return cd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(CandidatoTO candidato) {
		cd = new CandidatoDAO();
		cd.inserir(candidato);
		
	}
	
	/*
	 * PUT
	 */
	public void atualizar(CandidatoTO candidato) {
		cd = new CandidatoDAO();
		cd.alterar(candidato);
	}
	
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		cd = new CandidatoDAO();
		cd.excluir(id);
	}
}