package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.FeedBackDAO;
import br.com.contivo.to.FeedBackTO;

public class FeedBackBO {
	private FeedBackDAO fbd = null;
	/*
	 * GET-ALL
	 */
	public List<FeedBackTO> listar() {
		fbd = new FeedBackDAO();
		return fbd.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<FeedBackTO> listar(int id) {
		fbd = new FeedBackDAO();
		return fbd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(FeedBackTO feedBack) {
		fbd = new FeedBackDAO();
		fbd.inserir(feedBack);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(FeedBackTO feedBack) {
		fbd = new FeedBackDAO();
		fbd.alterar(feedBack);
	}
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		fbd = new FeedBackDAO();
		fbd.excluir(id);
	}
}
