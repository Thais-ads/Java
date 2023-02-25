package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FeedBackTO  extends ColaboradorTO{

	private int idFeedback;
	private int idColaborador;
	private String tipoFeedback, descFeedback;
	private String data;
	
	public FeedBackTO() {
		
	}

	public FeedBackTO(int idFeedback, int idColaborador, String tipoFeedback, String descFeedback,
			String data) {
		super();
		this.idFeedback = idFeedback;
		this.idColaborador = idColaborador;
		this.tipoFeedback = tipoFeedback;
		this.descFeedback = descFeedback;
		this.data = data;
	}

	public int getIdFeedback() {
		return idFeedback;
	}

	public int getIdColaborador() {
		return idColaborador;
	}

	public String getTipoFeedback() {
		return tipoFeedback;
	}

	public String getDescFeedback() {
		return descFeedback;
	}

	public String getData() {
		return data;
	}

	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}

	public void setIdColaborador(int idColaborador) {
		this.idColaborador = idColaborador;
	}

	public void setTipoFeedback(String tipoFeedback) {
		this.tipoFeedback = tipoFeedback;
	}

	public void setDescFeedback(String descFeedback) {
		this.descFeedback = descFeedback;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
