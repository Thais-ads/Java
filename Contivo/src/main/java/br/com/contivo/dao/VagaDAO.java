package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.VagaTO;

public class VagaDAO {

	private Connection con = null;

	@SuppressWarnings("static-access")
	public VagaDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(VagaTO vaga) {
		String sql = "insert into T_IBM_VAGA(ID_VAGA,ID_EMPRESA,ID_SKILL,DESCRICAO_VAGA,REQUISITO_NIVEL_ACADEMICO) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vaga.getIdVaga());
			ps.setInt(2, vaga.getIdEmpresa());
			ps.setInt(3, vaga.getIdSkill());
			ps.setString(4, vaga.getDescricaoVaga());
			ps.setString(5, vaga.getRequisitoNivelAcademico());
			if (ps.executeUpdate() > 0) {
				return "Vaga cadastrada com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String alterar(VagaTO vaga) {
		String sql = "update T_IBM_VAGA set ID_EMPRESA = ?, ID_SKILL = ?, DESCRICAO_VAGA = ?, REQUISITO_NIVEL_ACADEMICO = ?"
				+ "where ID_VAGA = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, vaga.getIdEmpresa());
			ps.setInt(2, vaga.getIdSkill());
			ps.setString(3, vaga.getDescricaoVaga());
			ps.setString(4, vaga.getRequisitoNivelAcademico());
			ps.setInt(5, vaga.getIdVaga());
			if (ps.executeUpdate() > 0) {
				return "Vaga alterada com sucesso.";
			} else {
				return "Erro ao alterar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String excluir(int id) {
		
		String sql = "delete from T_IBM_VAGA where ID_VAGA = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Vaga excluida com sucesso.";
			} else {
				return "Erro ao excluir a vaga.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public List<VagaTO> listarTodos() {
		String sql = "select * from T_IBM_VAGA";
		ArrayList<VagaTO> lista = new ArrayList<VagaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					VagaTO vto = new VagaTO();
					vto.setIdVaga(rs.getInt(1));
					vto.setIdEmpresa(rs.getInt(2));
					vto.setIdSkill(rs.getInt(3));
					vto.setDescricaoVaga(rs.getString(4));
					vto.setRequisitoNivelAcademico(rs.getString(5));
					lista.add(vto);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<VagaTO> listarId(int id) {
		String sql = "select * from T_IBM_VAGA where ID_VAGA = ?";
		ArrayList<VagaTO> lista = new ArrayList<VagaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					VagaTO vto = new VagaTO();
					vto.setIdVaga(rs.getInt(1));
					vto.setIdEmpresa(rs.getInt(2));
					vto.setIdSkill(rs.getInt(3));
					vto.setDescricaoVaga(rs.getString(4));
					vto.setRequisitoNivelAcademico(rs.getString(5));
					lista.add(vto);
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
