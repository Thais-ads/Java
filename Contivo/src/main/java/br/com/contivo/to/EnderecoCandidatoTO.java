package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnderecoCandidatoTO extends CandidatoTO{
	
	private String logradouro, complemento, bairro, cidade, uf;
	private int idEndereco, cep;
	private String dataInicio, dataFim;
	
	public EnderecoCandidatoTO() {
		
	}

	public EnderecoCandidatoTO(String logradouro, String complemento, String bairro, String cidade, String uf,
			int cep, int idEndereco, String dataInicio, String dataFim) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.idEndereco = idEndereco;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public int getCep() {
		return cep;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
	
}
