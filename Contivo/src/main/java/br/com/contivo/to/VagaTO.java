package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VagaTO {
	
	private int idVaga;
	private int idEmpresa;
	private int idSkill;
	private String descricaoVaga;
	private String requisitoNivelAcademico;
	
	public VagaTO() {
		
	}
	
	public VagaTO(int idVaga, int idEmpresa, int idSkill, String descricaoVaga,
			String requisitoNivelAcademico) {
		super();
		this.idVaga = idVaga;
		this.idEmpresa = idEmpresa;
		this.idSkill = idSkill;
		this.descricaoVaga = descricaoVaga;
		this.requisitoNivelAcademico = requisitoNivelAcademico;
	}

	public int getIdVaga() {
		return idVaga;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	public String getRequisitoNivelAcademico() {
		return requisitoNivelAcademico;
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}

	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}

	public void setRequisitoNivelAcademico(String requisitoNivelAcademico) {
		this.requisitoNivelAcademico = requisitoNivelAcademico;
	}
	
	
	
	
}
