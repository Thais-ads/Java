package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ColaboradorTO {
	
	private int idColaborador;
	private int idEmpresa;
	private String nomeColaborador;
	private String emailColaborador;
	private String senha;
	private String cargoColaborador;
	private Long cpfColaborador;
	private String nvColaborador;
	
	public ColaboradorTO(int idColaborador, int idEmpresa, String nomeColaborador, String emailColaborador,
			String senha, String cargoColaborador, Long cpfColaborador, String nvColaborador) {
		super();
		this.idColaborador = idColaborador;
		this.idEmpresa = idEmpresa;
		this.nomeColaborador = nomeColaborador;
		this.emailColaborador = emailColaborador;
		this.senha = senha;
		this.cargoColaborador = cargoColaborador;
		this.cpfColaborador = cpfColaborador;
		this.nvColaborador = nvColaborador;
	}
	
	public ColaboradorTO() {}

	public int getIdColaborador() {
		return idColaborador;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public String getEmailColaborador() {
		return emailColaborador;
	}

	public String getSenha() {
		return senha;
	}

	public String getCargoColaborador() {
		return cargoColaborador;
	}

	public Long getCpfColaborador() {
		return cpfColaborador;
	}

	public String getNvColaborador() {
		return nvColaborador;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public void setEmailColaborador(String emailColaborador) {
		this.emailColaborador = emailColaborador;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCargoColaborador(String cargoColaborador) {
		this.cargoColaborador = cargoColaborador;
	}

	public void setCpfColaborador(Long cpfColaborador) {
		this.cpfColaborador = cpfColaborador;
	}

	public void setNvColaborador(String nvColaborador) {
		this.nvColaborador = nvColaborador;
	}
	
	
	
	
}
