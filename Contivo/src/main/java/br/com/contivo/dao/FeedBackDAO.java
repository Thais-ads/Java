package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.FeedBackTO;

public class FeedBackDAO {

	private Connection con = null;

	@SuppressWarnings("static-access")
	public FeedBackDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(FeedBackTO feedback) {
		String sql = "insert into T_IBM_FEEDBACK(ID_FEEDBACK,ID_COLABORADOR,TIPO_FEEDBACK,DESC_FEEDBACK,DATA_FEEDBACK) "
				+ "values(?,?,?,?,to_DATE(?,'dd/mm/yyyy'))";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, feedback.getIdFeedback());
			ps.setInt(2, feedback.getIdColaborador());
			ps.setString(3, feedback.getTipoFeedback());
			ps.setString(4, feedback.getDescFeedback());
			ps.setString(5, feedback.getData());
			if (ps.executeUpdate() > 0) {
				return "Feedback cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(FeedBackTO feedback) {
		String sql = "update T_IBM_FEEDBACK set ID_COLABORADOR = ?, TIPO_FEEDBACK = ?, DESC_FEEDBACK = ?, DATA_FEEDBACK = to_DATE(?,'dd/mm/yyyy')"
				+ "where ID_FEEDBACK = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, feedback.getIdColaborador());
			ps.setString(2, feedback.getTipoFeedback());
			ps.setString(3, feedback.getDescFeedback());
			ps.setString(4, feedback.getData());
			ps.setInt(5, feedback.getIdFeedback());

			if (ps.executeUpdate() > 0) {
				return "Feedback alterado com sucesso.";
			} else {
				return "Erro ao alterar o feedback.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public String excluir(int id) {
		String sql = "delete from T_IBM_FEEDBACK where ID_FEEDBACK = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Feedback excluido com sucesso.";
			} else {
				return "Erro ao excluir feedback.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<FeedBackTO> listarTodos() {
		String sql = "select * from T_IBM_FEEDBACK";
		ArrayList<FeedBackTO> lista = new ArrayList<FeedBackTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					FeedBackTO fbto = new FeedBackTO();
					fbto.setIdFeedback(rs.getInt(1));
					fbto.setIdColaborador(rs.getInt(2));
					fbto.setTipoFeedback(rs.getString(3));
					fbto.setDescFeedback(rs.getString(4));
					fbto.setData(rs.getString(5));
					lista.add(fbto);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<FeedBackTO> listarId(int id) {
		String sql = "select * from T_IBM_FEEDBACK where ID_FEEDBACK = ?";
		ArrayList<FeedBackTO> lista = new ArrayList<FeedBackTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					FeedBackTO fbto = new FeedBackTO();
					fbto.setIdFeedback(rs.getInt(1));
					fbto.setIdColaborador(rs.getInt(2));
					fbto.setTipoFeedback(rs.getString(3));
					fbto.setDescFeedback(rs.getString(4));
					fbto.setData(rs.getString(5));
					lista.add(fbto);
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
