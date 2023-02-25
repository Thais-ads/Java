package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.EnderecoCandidatoDAO;
import br.com.contivo.to.EnderecoCandidatoTO;

public class EnderecoCandidatoBO {
	private EnderecoCandidatoDAO ecd = null;
	
	/*
	 * GET-ALL
	 */
	public List<EnderecoCandidatoTO> listar() {
		ecd = new EnderecoCandidatoDAO();
		return ecd.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<EnderecoCandidatoTO> listar(int id) {
		ecd = new EnderecoCandidatoDAO();
		return ecd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(EnderecoCandidatoTO enderecoCandidato) {
		ecd = new EnderecoCandidatoDAO();
		ecd.inserir(enderecoCandidato);
	}
	
	/*
	 * PUT
	 */
	
	public void atualizar(EnderecoCandidatoTO enderecoCandidato) {
		ecd = new EnderecoCandidatoDAO();
		ecd.alterar(enderecoCandidato);
	}
	
	/*
	 * DELETE
	 */
	
	public void excluir(int id) {
		ecd = new EnderecoCandidatoDAO();
		ecd.excluir(id);
	}
}

