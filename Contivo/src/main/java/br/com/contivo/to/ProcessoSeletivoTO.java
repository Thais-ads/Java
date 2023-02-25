package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcessoSeletivoTO {
	private int idProcessoSeletivo;
	private int idVaga;
	private int idCurriculo;
	private int idFeedback;
	private String dataInicio, dataFim;
	
	public ProcessoSeletivoTO() {
		
	}

	public ProcessoSeletivoTO(int idProcessoSeletivo, int idVaga, int idCurriculo, int idFeedback,
			String dataInicio, String dataFim) {
		super();
		this.idProcessoSeletivo = idProcessoSeletivo;
		this.idVaga = idVaga;
		this.idCurriculo = idCurriculo;
		this.idFeedback = idFeedback;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getIdProcessoSeletivo() {
		return idProcessoSeletivo;
	}

	public int getIdVaga() {
		return idVaga;
	}

	public int getIdCurriculo() {
		return idCurriculo;
	}

	public int getIdFeedback() {
		return idFeedback;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setIdProcessoSeletivo(int idProcessoSeletivo) {
		this.idProcessoSeletivo = idProcessoSeletivo;
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	public void setIdCurriculo(int idCurriculo) {
		this.idCurriculo = idCurriculo;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	
	
}
