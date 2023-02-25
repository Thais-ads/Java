package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormacaoAcademicaTO extends CandidatoTO{
	private int idformacao;
	private String formacao, instituicao, status;
	private String dataInicio, dataFim;
	
	public FormacaoAcademicaTO() {}

	public FormacaoAcademicaTO(int idformacao, String formacao, String instituicao, String status, String dataInicio,
			String dataFim) {
		super();
		this.idformacao = idformacao;
		this.formacao = formacao;
		this.instituicao = instituicao;
		this.status = status;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getIdformacao() {
		return idformacao;
	}

	public String getFormacao() {
		return formacao;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public String getStatus() {
		return status;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setIdformacao(int idformacao) {
		this.idformacao = idformacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
