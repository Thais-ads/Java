package br.com.contivo.to;

public class EnderecoEmpresaTO extends EmpresaTO{
	
	private int idEndereco, idEmpresa, cep;
	private String logradouro, bairro, cidade, uf, pontoReferencia;
	
	public EnderecoEmpresaTO() {
		
	}

	public EnderecoEmpresaTO(int idEndereco, int idEmpresa, int cep, String logradouro, String bairro, String cidade,
			String uf, String pontoReferencia) {
		super();
		this.idEndereco = idEndereco;
		this.idEmpresa = idEmpresa;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pontoReferencia = pontoReferencia;
	}

	public int getIdEndereco() {
		return idEndereco;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public int getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
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

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	
	
}