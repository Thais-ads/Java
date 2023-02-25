package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.ProcessoSeletivoTO;

public class ProcessoSeletivoDAO {

	private Connection con = null;

	@SuppressWarnings("static-access")
	public ProcessoSeletivoDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(ProcessoSeletivoTO processo) {
		String sql = "insert into T_IBM_PROCESSO_SELETIVO(ID_VAGA,ID_CURRICULO,DATA_INICIO,DATA_FIM,ID_FEEDBACK) "
				+ "values(?,?,?,?,to_DATE(?,'dd/mm/yyyy'),to_DATE(?,'dd/mm/yyyy'))";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, processo.getIdVaga());
			ps.setInt(2, processo.getIdCurriculo());
			ps.setString(3, processo.getDataInicio());
			ps.setString(4, processo.getDataFim());
			ps.setInt(5, processo.getIdFeedback());

			if (ps.executeUpdate() > 0) {
				return "Processo seletivo cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(ProcessoSeletivoTO processo) {
		String sql = "update T_IBM_PROCESSO_SELETIVO set ID_VAGA = ?, ID_CURRICULO = ?, DATA_INICIO = ?, DATA_FIM = ?, ID_FEEDBACK = ?"
				+ "where ID_PROCESSO_SELETIVO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, processo.getIdVaga());
			ps.setInt(2, processo.getIdCurriculo());
			ps.setString(3, processo.getDataInicio());
			ps.setString(4, processo.getDataFim());
			ps.setInt(5, processo.getIdFeedback());
			ps.setInt(6, processo.getIdProcessoSeletivo());
			if (ps.executeUpdate() > 0) {
				return "Processo Seletivo alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(int id) {
		String sql = "delete from T_IBM_PROCESSO_SELETIVO where ID_PROCESSO_SELETIVO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Processo seletivo excluido com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<ProcessoSeletivoTO> listarTodos() {
		String sql = "select * from T_IBM_PROCESSO_SELETIVO";
		ArrayList<ProcessoSeletivoTO> lista = new ArrayList<ProcessoSeletivoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ProcessoSeletivoTO psto = new ProcessoSeletivoTO();
					psto.setIdProcessoSeletivo(rs.getInt(1));
					psto.setIdVaga(rs.getInt(2));
					psto.setIdCurriculo(rs.getInt(3));
					psto.setDataInicio(rs.getString(4));
					psto.setDataFim(rs.getString(5));
					psto.setIdFeedback(rs.getInt(6));
					lista.add(psto);

				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<ProcessoSeletivoTO> listarId(int id) {
		String sql = "select * from T_IBM_PROCESSO_SELETIVO where ID_PROCESSO_SELETIVO = ?";
		ArrayList<ProcessoSeletivoTO> lista = new ArrayList<ProcessoSeletivoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ProcessoSeletivoTO psto = new ProcessoSeletivoTO();
					psto.setIdProcessoSeletivo(rs.getInt(1));
					psto.setIdVaga(rs.getInt(2));
					psto.setIdCurriculo(rs.getInt(3));
					psto.setDataInicio(rs.getString(4));
					psto.setDataFim(rs.getString(5));
					psto.setIdFeedback(rs.getInt(6));
					lista.add(psto);

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
