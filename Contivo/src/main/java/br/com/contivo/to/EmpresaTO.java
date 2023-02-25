package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpresaTO {
	
	private int idEmpresa;
	private Long cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String endereco;
	
	public EmpresaTO() {
		
	}

	public EmpresaTO(int idEmpresa, Long cnpj, String razaoSocial, String nomeFantasia, String endereco) {
		super();
		this.idEmpresa = idEmpresa;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
