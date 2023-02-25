package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SkillTO {
	
	private int idSkill;
	private String nomeSkill, tipoSkill, nivelSkill;
	
	public SkillTO() {
		
	}

	public SkillTO(int idSkill, String nomeSkill, String tipoSkill, String nivelSkill) {
		super();
		this.idSkill = idSkill;
		this.nomeSkill = nomeSkill;
		this.tipoSkill = tipoSkill;
		this.nivelSkill = nivelSkill;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public String getNomeSkill() {
		return nomeSkill;
	}

	public String getTipoSkill() {
		return tipoSkill;
	}

	public String getNivelSkill() {
		return nivelSkill;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}

	public void setNomeSkill(String nomeSkill) {
		this.nomeSkill = nomeSkill;
	}

	public void setTipoSkill(String tipoSkill) {
		this.tipoSkill = tipoSkill;
	}

	public void setNivelSkill(String nivelSkill) {
		this.nivelSkill = nivelSkill;
	}
	
	
	
}
