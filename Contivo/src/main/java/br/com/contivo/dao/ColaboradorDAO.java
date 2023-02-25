package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.ColaboradorTO;

public class ColaboradorDAO {
	private Connection con = null;

	@SuppressWarnings("static-access")
	public ColaboradorDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(ColaboradorTO colaborador) {

		String sql = "insert into T_IBM_COLABORADOR_EMPRESA(ID_EMPRESA,NOME_COLABORADOR,EMAIL_COLABORADOR,SENHA,"
				+ "CARGO_COLABORADOR,CPF_COLABORADOR,NV_COLABORADOR) " + "values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, colaborador.getIdEmpresa());
			ps.setString(2, colaborador.getNomeColaborador());
			ps.setString(3, colaborador.getEmailColaborador());
			ps.setString(4, colaborador.getSenha());
			ps.setString(5, colaborador.getCargoColaborador());
			ps.setLong(6, colaborador.getCpfColaborador());
			ps.setString(7, colaborador.getNvColaborador());
			if (ps.executeUpdate() > 0) {
				return "Colaborador cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(ColaboradorTO colaborador) {
		String sql = "update T_IBM_COLABORADOR_EMPRESA set NOME_COLABORADOR = ?, EMAIL_COLABORADOR = ?, SENHA = ?,"
				+ "CARGO_COLABORADOR = ?, CPF_COLABORADOR = ?, NV_COLABORADOR" + "where ID_COLABORADOR = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, colaborador.getNomeColaborador());
			ps.setString(2, colaborador.getEmailColaborador());
			ps.setString(3, colaborador.getSenha());
			ps.setString(4, colaborador.getCargoColaborador());
			ps.setLong(5, colaborador.getCpfColaborador());
			ps.setString(6, colaborador.getNvColaborador());
			ps.setInt(7, colaborador.getIdColaborador());
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

		String sql = "delete from T_IBM_COLABORADOR_EMPRESA where ID_COLABORADOR = ?";
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

	public List<ColaboradorTO> listarTodos() {
		String sql = "select * from T_IBM_COLABORADOR_EMPRESA";
		ArrayList<ColaboradorTO> lista = new ArrayList<ColaboradorTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ColaboradorTO ct = new ColaboradorTO();
					ct.setIdColaborador(rs.getInt(1));
					ct.setIdEmpresa(rs.getInt(2));
					ct.setNomeColaborador(rs.getString(3));
					ct.setEmailColaborador(rs.getString(4));
					ct.setSenha(rs.getString(5));
					ct.setCargoColaborador(rs.getString(6));
					ct.setCpfColaborador(rs.getLong(7));
					ct.setNvColaborador(rs.getString(8));
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

	public List<ColaboradorTO> listaId(int id) {
		String sql = "select * from T_IBM_COLABORADOR_EMPRESA where ID_COLABORADOR_EMPRESA = ? ";
		ArrayList<ColaboradorTO> lista = new ArrayList<ColaboradorTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					ColaboradorTO ct = new ColaboradorTO();
					ct.setIdColaborador(rs.getInt(1));
					ct.setIdEmpresa(rs.getInt(2));
					ct.setNomeColaborador(rs.getString(3));
					ct.setEmailColaborador(rs.getString(4));
					ct.setSenha(rs.getString(5));
					ct.setCargoColaborador(rs.getString(6));
					ct.setCpfColaborador(rs.getLong(7));
					ct.setNvColaborador(rs.getString(8));
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
