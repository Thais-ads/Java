package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.CurriculoTO;

public class CurriculoDAO {

	private Connection con = null;

	@SuppressWarnings("static-access")
	public CurriculoDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(CurriculoTO curriculo) {

		String sql = "insert into T_IBM_CURRICULO(ID_SKILL,ID_CANDIDATO,ID_FORMACAO,ID_SKILL,APRESENTACAO_PESSOAL) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, curriculo.getIdCandidato());
			ps.setInt(2, curriculo.getIdFormacao());
			ps.setInt(3, curriculo.getIdSkill());
			ps.setString(4, curriculo.getAprePessoal());

			if (ps.executeUpdate() > 0) {
				return "Curriculo cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(CurriculoTO curriculo) {
		String sql = "update T_IBM_SKILL set APRESENTACAO_PESSOAL = ?, ID_CANDIDATO = ?, ID_FORMACAO = ?, ID_SKILL = ? "
				+ "where = ID_CURRICULO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, curriculo.getIdCandidato());
			ps.setInt(2, curriculo.getIdFormacao());
			ps.setInt(3, curriculo.getIdSkill());
			ps.setString(4, curriculo.getAprePessoal());
			ps.setInt(5, curriculo.getIdcurriculo());
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
		String sql = "delete from T_IBM_CURRICULO where ID_CURRICULO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Curriculo excluido com sucesso.";
			} else {
				return "Erro ao excluir curriculo.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<CurriculoTO> listarTodos() {
		String sql = "select * from T_IBM_CURRICULO";
		ArrayList<CurriculoTO> lista = new ArrayList<CurriculoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					CurriculoTO ct = new CurriculoTO();
					ct.setIdcurriculo(rs.getInt(1));
					ct.setIdCandidato(rs.getInt(2));
					ct.setIdFormacao(rs.getInt(3));
					ct.setIdSkill(rs.getInt(4));
					ct.setAprePessoal(rs.getString(5));
					lista.add(ct);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	public List<CurriculoTO> listarId(int id) {
		String sql = "select * from T_IBM_CURRICULO where ID_CURRICULO = ?";
		ArrayList<CurriculoTO> lista = new ArrayList<CurriculoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					CurriculoTO ct = new CurriculoTO();
					ct.setIdcurriculo(rs.getInt(1));
					ct.setIdCandidato(rs.getInt(2));
					ct.setIdFormacao(rs.getInt(3));
					ct.setIdSkill(rs.getInt(4));
					ct.setAprePessoal(rs.getString(5));
					lista.add(ct);
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
