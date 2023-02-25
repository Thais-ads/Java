package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.VagaDAO;
import br.com.contivo.to.VagaTO;

public class VagaBO {
	private VagaDAO vd = null;
	
	/*
	 * GET-ALL
	 */
	public List<VagaTO> listar() {
		vd = new VagaDAO();
		return vd.listarTodos();
	}
	
	/*
	 * GET-By-ID
	 */
	public List<VagaTO> listar(int id) {
		vd = new VagaDAO();
		return vd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(VagaTO vaga) {
		vd = new VagaDAO();
		vd.inserir(vaga);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(VagaTO vaga) {
		vd = new VagaDAO();
		vd.alterar(vaga);
	}
	
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		vd = new VagaDAO();
		vd.excluir(id);
	}
}
