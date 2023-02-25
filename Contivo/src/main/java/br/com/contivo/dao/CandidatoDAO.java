package br.com.contivo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.CandidatoTO;

public class CandidatoDAO {

	private Connection con = null;

	@SuppressWarnings("static-access")
	public CandidatoDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(CandidatoTO candidato) {

		String sql = "insert into T_IBM_CANDIDATO(NOME_CANDIDATO,CPF_CANDIDATO,RG_CANDIDATO,RNE_CANDIDATO,ESTADO_CIVIL,TEL_CANDIDATO,EMAIL_CANDIDATO,DATA_NASCIMENTO,GENERO_CANDIDATO,ST_TELEFONE_CANDIDATO,ST_EMAIL_CANDIDATO,SENHA)\r\n"
				+ "values(?,?,?,?,?,?,?,to_DATE(?,'dd/mm/yyyy'),?,?,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, candidato.getNome());
			ps.setLong(2, candidato.getCpf());
			ps.setString(3, candidato.getRg());
			ps.setInt(4, candidato.getRne());
			ps.setString(5, candidato.getEstadoCivil());
			ps.setString(6, candidato.getTelefone());
			ps.setString(7, candidato.getEmail());
			ps.setString(8, candidato.getDataNascimento());
			ps.setString(9, candidato.getGenero());
			ps.setString(10, candidato.getSenha());
			ps.setString(11, candidato.getStatusTelefone());
			ps.setString(12, candidato.getStatusEmail());
			if (ps.executeUpdate() > 0) {
				return "Candidato cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(CandidatoTO candidato) {

		String sql = "update T_IBM_CANDIDATO set NOME_CANDIDATO = ?, CPF_CANDIDATO = ?, RG_CANDIDATO = ?, RNE_CANDIDATO = ?, "
				+ "ESTADO_CIVIL = ?, TEL_CANDIDATO = ?, EMAIL_CANDIDATO = ?, DATA_NASCIMENTO = to_DATE(?,'dd/mm/yyyy'), GENERO_CANDIDATO = ?, SENHA = ?, "
				+ "ST_TELEFONE_CANDIDATO = ?, ST_EMAIL_CANDIDATO = ?, where ID_CANDIDATO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, candidato.getNome());
			ps.setLong(2, candidato.getCpf());
			ps.setString(3, candidato.getRg());
			ps.setInt(4, candidato.getRne());
			ps.setString(5, candidato.getEstadoCivil());
			ps.setString(6, candidato.getTelefone());
			ps.setString(7, candidato.getEmail());
			ps.setString(8, candidato.getDataNascimento());
			ps.setString(9, candidato.getGenero());
			ps.setString(10, candidato.getSenha());
			ps.setString(11, candidato.getStatusTelefone());
			ps.setString(12, candidato.getStatusEmail());
			ps.setInt(13, candidato.getIdCandidato());
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

		String sql = "delete from T_IBM_CANDIDATO where ID_CANDIDATO = ?";
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

	public List<CandidatoTO> listarTodos() {
		String sql = "select * from T_IBM_CANDIDATO";
		ArrayList<CandidatoTO> lista = new ArrayList<CandidatoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					CandidatoTO ct = new CandidatoTO();
					ct.setIdCandidato(rs.getInt(1));
					ct.setNome(rs.getString(2));
					ct.setCpf(rs.getLong(3));
					ct.setRg(rs.getString(4));
					ct.setRne(rs.getInt(5));
					ct.setEstadoCivil(rs.getString(6));
					ct.setTelefone(rs.getString(7));
					ct.setEmail(rs.getString(8));
					ct.setSenha(rs.getString(9));
					ct.setDataNascimento(rs.getString(10));
					ct.setGenero(rs.getString(11));
					ct.setStatusTelefone(rs.getString(12));
					ct.setStatusEmail(rs.getString(13));
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

	public List<CandidatoTO> listarId(int id) {
		String sql = "select * from T_IBM_CANDIDATO where ID_CANDIDATO = ?";
		ArrayList<CandidatoTO> lista = new ArrayList<CandidatoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					CandidatoTO ct = new CandidatoTO();
					ct.setIdCandidato(rs.getInt(1));
					ct.setNome(rs.getString(2));
					ct.setCpf(rs.getLong(3));
					ct.setRg(rs.getString(4));
					ct.setEstadoCivil(rs.getString(5));
					ct.setGenero(rs.getString(6));
					ct.setDataNascimento(rs.getString(7));
					ct.setTelefone(rs.getString(8));
					ct.setEmail(rs.getString(9));
					ct.setSenha(rs.getString(10));
					ct.setRne(rs.getInt(11));
					ct.setStatusTelefone(rs.getString(12));
					ct.setStatusEmail(rs.getString(13));
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