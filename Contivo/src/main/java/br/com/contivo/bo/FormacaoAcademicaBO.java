package br.com.contivo.bo;

import java.util.List;

import br.com.contivo.dao.FormacaoAcademicaDAO;
import br.com.contivo.to.FormacaoAcademicaTO;

public class FormacaoAcademicaBO {
	private FormacaoAcademicaDAO fad = null;
	
	/*
	 * GET-ALL
	 */
	public List<FormacaoAcademicaTO> listar() {
		fad = new FormacaoAcademicaDAO();
		return fad.listarTodos();
	}
	
	/*
	 * GET-BY-ID
	 */
	public List<FormacaoAcademicaTO> listar(int id){
		fad = new FormacaoAcademicaDAO();
		return fad.listarId(id);
	}
	
	/*
	 * POST
	 */
			
	public void cadastrar(FormacaoAcademicaTO formacaoAcademica) {
		fad = new FormacaoAcademicaDAO();
		fad.inserir(formacaoAcademica);
	}
	
	/*
	 * PUT
	 */
	public void atualizar(FormacaoAcademicaTO fomacaoAcademica) {
		fad = new FormacaoAcademicaDAO();
		fad.alterar(fomacaoAcademica);
	}
	
	/*
	 * DELETE
	 */
	public void excluir(int id) {
		fad = new FormacaoAcademicaDAO();
		fad.excluir(id);
	}
}
