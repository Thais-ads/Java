package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.ScoreDAO;
import br.com.contivo.to.ScoreTO;

public class ScoreBO {
	private ScoreDAO sd = null;
	
	/*
	 * GET-ALL
	 */
	public List<ScoreTO> listar(){
		sd = new ScoreDAO();
		return sd.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<ScoreTO> listar(int id){
		sd = new ScoreDAO();
		return sd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(ScoreTO score) {
		sd = new ScoreDAO();
		sd.inserir(score);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(ScoreTO score) {
		sd = new ScoreDAO();
		sd.alterar(score);
	}
	
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		sd = new ScoreDAO();
		sd.excluir(id);
	}
	
}
