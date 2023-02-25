package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CurriculoTO extends CandidatoTO{
	
	private String aprePessoal;
	private int idcurriculo;
	private int idSkill;
	private int idFormacao;
	
	public CurriculoTO() {
		
	}

	public CurriculoTO(String aprePessoal, int idcurriculo, int idSkill, int idFormacao) {
		super();
		this.aprePessoal = aprePessoal;
		this.idcurriculo = idcurriculo;
		this.idSkill = idSkill;
		this.idFormacao = idFormacao;
	}

	public String getAprePessoal() {
		return aprePessoal;
	}

	public int getIdcurriculo() {
		return idcurriculo;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public int getIdFormacao() {
		return idFormacao;
	}

	public void setAprePessoal(String aprePessoal) {
		this.aprePessoal = aprePessoal;
	}

	public void setIdcurriculo(int idcurriculo) {
		this.idcurriculo = idcurriculo;
	}

	public void setIdSkill(int idSkill) {
		this.idSkill = idSkill;
	}

	public void setIdFormacao(int idFormacao) {
		this.idFormacao = idFormacao;
	}
	
	
	
	
}
