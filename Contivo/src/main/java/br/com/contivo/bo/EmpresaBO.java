package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.EmpresaDAO;
import br.com.contivo.to.EmpresaTO;

public class EmpresaBO {
	private EmpresaDAO ed = null;
	
	/*
	 * GET-ALL
	 */
	public List<EmpresaTO> listar() {
		ed = new EmpresaDAO();
		return ed.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<EmpresaTO> listar(int id)	{
		ed = new EmpresaDAO();
		return ed.listarId(id);
	}
	
	/*
	 * POST
	 */
	
	public void cadastrar(EmpresaTO empresa) {
		ed = new EmpresaDAO();
		ed.inserir(empresa);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(EmpresaTO empresa) {
		ed = new EmpresaDAO();
		ed.alterar(empresa);
	}
	
	/*
	 * DELETE
	 */
	
	public void excluir(int id) {
		ed = new EmpresaDAO();
		ed.excluir(id);
	}
 }
