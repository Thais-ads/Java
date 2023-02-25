package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.EmpresaTO;

public class EmpresaDAO {

	private Connection con = null;

	@SuppressWarnings("static-access")
	public EmpresaDAO() {
		this.con = new Conexao().abriConexao();
	}
	public String inserir(EmpresaTO empresa) {
		String sql = "insert into T_IBM_EMPRESA(CNPJ_EMPRESA,RAZAO_SOCIAL,NOME_FANTASIA,ENDERECO) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, empresa.getCnpj());
			ps.setString(2, empresa.getRazaoSocial());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			if (ps.executeUpdate() > 0) {
				return "Empresa cadastrada com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String alterar(EmpresaTO empresa) {
	
		String sql = "update empresa set CNPJ_EMPRESA = ?, RAZAO_SOCIAL = ?, NOME_FANTASIA = ?, ENDERECO = ?"
				+ "where ID_EMPRESA = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, empresa.getCnpj());
			ps.setString(2, empresa.getRazaoSocial());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setInt(5, empresa.getIdEmpresa());
			if (ps.executeUpdate() > 0) {
				return "Empresa cadastrada com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String excluir(int id) {
		String sql = "delete from T_IBM_EMPRESA where ID_EMPRESA = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Empresa excluida com sucesso.";
			} else {
				return "Erro ao excluir empresa.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public List<EmpresaTO> listarTodos() {
		String sql = "select * from T_IBM_EMPRESA";
		ArrayList<EmpresaTO> lista = new ArrayList<EmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EmpresaTO et = new EmpresaTO();
					et.setIdEmpresa(rs.getInt(1));
					et.setCnpj(rs.getLong(2));
					et.setRazaoSocial(rs.getString(3));
					et.setNomeFantasia(rs.getString(4));
					et.setEndereco(rs.getString(5));
					lista.add(et);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<EmpresaTO> listarId(int id) {
		String sql = "select * from T_IBM_EMPRESA where ID_EMPRESA = ?";
		ArrayList<EmpresaTO> lista = new ArrayList<EmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EmpresaTO et = new EmpresaTO();
					et.setIdEmpresa(rs.getInt(1));
					et.setCnpj(rs.getLong(2));
					et.setRazaoSocial(rs.getString(3));
					et.setNomeFantasia(rs.getString(4));
					et.setEndereco(rs.getString(5));
					lista.add(et);
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
