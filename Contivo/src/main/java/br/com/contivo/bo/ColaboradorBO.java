package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.ColaboradorDAO;
import br.com.contivo.to.ColaboradorTO;

public class ColaboradorBO {
	private ColaboradorDAO cd = null;
	
	/*
	 * GET-ALL
	 */
	public List<ColaboradorTO> listar() {
		cd = new ColaboradorDAO();
		return cd.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<ColaboradorTO> listarId(int id) {
		cd = new ColaboradorDAO();
		return cd.listaId(id);
	}
	/*
	 * POST
	 */
	public void cadastrar(ColaboradorTO colaborador) {
		cd = new ColaboradorDAO();
		cd.inserir(colaborador);
	}
	/*
	 * PUT
	 */
	public void atualizar(ColaboradorTO colaborador) {
		cd = new ColaboradorDAO();
		cd.alterar(colaborador);
	}
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		cd = new ColaboradorDAO();
		cd.excluir(id);
	}
	
}
