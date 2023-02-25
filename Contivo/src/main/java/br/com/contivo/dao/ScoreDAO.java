package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.ScoreTO;

public class ScoreDAO {
	
	private Connection con = null;

	@SuppressWarnings("static-access")
	public ScoreDAO() {
		this.con = new Conexao().abriConexao();
	}
	
	public String inserir(ScoreTO score) {
		
		String sql = "insert into T_IBM_SCORE(SCORE,DATA_SCORE) "
				+ "values(?,?,to_DATE(?,'dd/mm/yyyy')) where ID_CANDIDATO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, score.getScore());
			ps.setString(2, score.getData());
			ps.setInt(3, score.getIdCandidato());
			
			if (ps.executeUpdate() > 0) {
				return "Score cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String alterar(ScoreTO score) {
		String sql = "update T_IBM_SCORE set Score = ?, DATA_SCORE = ? where ID_SCORE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, score.getIdScore());
			ps.setFloat(1, score.getScore());
			ps.setString(2, score.getData());
			if (ps.executeUpdate() > 0) {
				return "Cadastro alterado com sucesso.";
			} else {
				return "Erro ao alterar o cadastro.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public String excluir(int id) {
		
		String sql = "delete from T_IBM_SCORE where ID_SCORE = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Score excluido com sucesso.";
			} else {
				return "Erro ao excluir score.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public List<ScoreTO> listarTodos() {
		String sql = "select * from T_IBM_SCORE";
		ArrayList<ScoreTO> lista = new ArrayList<ScoreTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ScoreTO sto = new ScoreTO();
					sto.setIdScore(rs.getInt(1));
					sto.setIdCandidato(rs.getInt(2));
					sto.setScore(rs.getFloat(3));
					sto.setData(rs.getString(4));
					lista.add(sto);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<ScoreTO> listarId(int id) {
		String sql = "select * from T_IBM_SCORE";
		ArrayList<ScoreTO> lista = new ArrayList<ScoreTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ScoreTO sto = new ScoreTO();
					sto.setIdScore(rs.getInt(1));
					sto.setIdCandidato(rs.getInt(2));
					sto.setScore(rs.getFloat(3));
					sto.setData(rs.getString(4));
					lista.add(sto);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
}