package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.ProcessoSeletivoDAO;
import br.com.contivo.to.ProcessoSeletivoTO;

public class ProcessoSeletivoBO {
	private ProcessoSeletivoDAO psd = null;
	
	/*
	 * GET-ALL
	 */
	public List<ProcessoSeletivoTO> listar() {
		psd = new ProcessoSeletivoDAO();
		return psd.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<ProcessoSeletivoTO> listar(int id) {
		psd = new ProcessoSeletivoDAO();
		return psd.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(ProcessoSeletivoTO processoSeletivo) {
		psd = new ProcessoSeletivoDAO();
		psd.inserir(processoSeletivo);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(ProcessoSeletivoTO processoSeletivo) {
		psd = new ProcessoSeletivoDAO();
		psd.alterar(processoSeletivo);
	}
	
	/*
	 *DELETE
	 */
	public void excluir(int id) {
		psd = new ProcessoSeletivoDAO();
		psd.excluir(id);
	}
}
