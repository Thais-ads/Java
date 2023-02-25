package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.FormacaoAcademicaTO;

public class FormacaoAcademicaDAO{

	private Connection con = null;

	@SuppressWarnings("static-access")
	public FormacaoAcademicaDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(FormacaoAcademicaTO formacaoAcademica) {
		String sql = "insert into T_IBM_FORMACAO_ACADEMICA(NIVEL_FORMACAO,INSTITUICAO,DATA_INICIO,DATA_FIM,STATUS) "
				+ "values(?,?,,to_DATE(?,'dd/mm/yyyy'),to_DATE(?,'dd/mm/yyyy'),?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, formacaoAcademica.getFormacao());
			ps.setString(2, formacaoAcademica.getInstituicao());
			ps.setString(3, formacaoAcademica.getDataInicio());
			ps.setString(4, formacaoAcademica.getDataFim());
			ps.setString(5, formacaoAcademica.getStatus());
			if (ps.executeUpdate() > 0) {
				return "Formação cadastrada com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String alterar(FormacaoAcademicaTO formacaoAcademica) {
		String sql = "update T_IBM_FORMACAO_ACADEMICA set NIVEL_FORMACAO = ?, INSTITUICAO = ?, DATA_INICIO = ?, DATA_FIM = ?, STATUS = ?"
				+ "where ID_FORMACAO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, formacaoAcademica.getFormacao());
			ps.setString(2, formacaoAcademica.getInstituicao());
			ps.setString(3, formacaoAcademica.getDataInicio());
			ps.setString(4, formacaoAcademica.getDataFim());
			ps.setString(5, formacaoAcademica.getStatus());
			ps.setInt(6, formacaoAcademica.getIdformacao());
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
		String sql = "delete from T_IBM_FORMACAO_ACADEMICA where ID_FORMACAO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Cadastro excluido com sucesso.";
			} else {
				return "Erro ao excluir cadastro.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public List<FormacaoAcademicaTO> listarTodos() {
		String sql = "select * from T_IBM_FORMACAO_ACADEMICA";
		ArrayList<FormacaoAcademicaTO> lista = new ArrayList<FormacaoAcademicaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					FormacaoAcademicaTO fato = new FormacaoAcademicaTO();
					fato.setIdformacao(rs.getInt(1));
					fato.setFormacao(rs.getString(2));
					fato.setInstituicao(rs.getString(3));
					fato.setDataInicio(rs.getString(4));
					fato.setDataFim(rs.getString(5));
					fato.setStatus(rs.getString(6));
					lista.add(fato);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<FormacaoAcademicaTO> listarId(int id) {
		String sql = "select * from T_IBM_FORMACAO_ACADEMICA where ID_FORMACAO = ?";
		ArrayList<FormacaoAcademicaTO> lista = new ArrayList<FormacaoAcademicaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					FormacaoAcademicaTO fato = new FormacaoAcademicaTO();
					fato.setIdformacao(rs.getInt(1));
					fato.setFormacao(rs.getString(2));
					fato.setInstituicao(rs.getString(3));
					fato.setDataInicio(rs.getString(4));
					fato.setDataFim(rs.getString(5));
					fato.setStatus(rs.getString(6));
					lista.add(fato);
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

