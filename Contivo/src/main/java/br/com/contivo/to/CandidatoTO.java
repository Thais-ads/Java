package br.com.contivo.to;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CandidatoTO {

	private int idCandidato;
	private String nome;
	private long cpf;
	private String rg;
	private String estadoCivil;
	private String genero;
	private String dataNascimento;
	private String telefone;
	private String email;
	private String senha;
	private int rne;
	private String statusTelefone;
	private String statusEmail;
	
	
	public CandidatoTO(int idCandidato, String nome, long cpf, String rg, String estadoCivil, String genero,
			String dataNascimento, String telefone, String email, String senha, int rne, String statusTelefone,
			String statusEmail) {
		super();
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.rne = rne;
		this.statusTelefone = statusTelefone;
		this.statusEmail = statusEmail;
	}

	public CandidatoTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public String getNome() {
		return nome;
	}

	public long getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getGenero() {
		return genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public int getRne() {
		return rne;
	}

	public String getStatusTelefone() {
		return statusTelefone;
	}

	public String getStatusEmail() {
		return statusEmail;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setRne(int rne) {
		this.rne = rne;
	}

	public void setStatusTelefone(String statusTelefone) {
		this.statusTelefone = statusTelefone;
	}

	public void setStatusEmail(String statusEmail) {
		this.statusEmail = statusEmail;
	}

}
