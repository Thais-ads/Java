package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.CurriculoDAO;
import br.com.contivo.to.CurriculoTO;

public class CurriculoBO {
	private CurriculoDAO cd = null;
	
	/*
	 * GET-ALL
	 */
	public List<CurriculoTO> listar() {
		cd = new CurriculoDAO();
		return cd.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<CurriculoTO> listar(int id) {
		cd = new CurriculoDAO();
		return cd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(CurriculoTO curriculo) {
		cd = new CurriculoDAO();
		cd.inserir(curriculo);
	}
	/*
	 * PUT
	 */
	public void atualizar(CurriculoTO curriculo) {
		cd = new CurriculoDAO();
		cd.alterar(curriculo);
	}
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		cd = new CurriculoDAO();
		cd.excluir(id);
	}
	
	
}
