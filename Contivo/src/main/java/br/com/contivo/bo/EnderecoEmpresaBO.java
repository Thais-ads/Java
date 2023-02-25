package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.EnderecoEmpresaDAO;
import br.com.contivo.to.EnderecoEmpresaTO;

public class EnderecoEmpresaBO {
	private EnderecoEmpresaDAO eed = null;
	
	/*
	 * GET-ALL
	 */
	public List<EnderecoEmpresaTO> listar() {
		eed = new EnderecoEmpresaDAO();
		return eed.listarTodos();
	}
	/*
	 * GET-BY-ID
	 */
	public List<EnderecoEmpresaTO> listar(int id) {
		eed = new EnderecoEmpresaDAO();
		return eed.listarId(id);
	}
	
	/*
	 * POST
	 */
	public void cadastrar(EnderecoEmpresaTO enderecoEmpresa) {
		eed = new EnderecoEmpresaDAO();
		eed.inserir(enderecoEmpresa);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(EnderecoEmpresaTO enderecoEmpresa) {
		eed = new EnderecoEmpresaDAO();
		eed.alterar(enderecoEmpresa);
	}
	
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		eed = new EnderecoEmpresaDAO();
		eed.excluir(id);
	} 
}
