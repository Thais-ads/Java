package br.com.contivo.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScoreTO extends CandidatoTO{
	
	private int idScore;
	private float score;
	private String data;
	
	public ScoreTO() {
		
	}

	public ScoreTO(int idScore, float score, String data) {
		super();
		this.idScore = idScore;
		this.score = score;
		this.data = data;
	}

	public int getIdScore() {
		return idScore;
	}

	public float getScore() {
		return score;
	}

	public String getData() {
		return data;
	}

	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}
