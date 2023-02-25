package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.EnderecoEmpresaTO;

public class EnderecoEmpresaDAO {
	private Connection con = null;

	@SuppressWarnings("static-access")
	public EnderecoEmpresaDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(EnderecoEmpresaTO enderecoEmpresa) {
		String sql = "insert into T_IBM_END_EMPRESA(NM_LOGRADOURO, BAIRRO, CEP, CIDADE, UF, PONTO_REFERENCIA) "
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, enderecoEmpresa.getLogradouro());
			ps.setString(2,  enderecoEmpresa.getBairro());
			ps.setInt(3, enderecoEmpresa.getCep());
			ps.setString(4, enderecoEmpresa.getCidade());
			ps.setString(5, enderecoEmpresa.getUf());
			ps.setString(6, enderecoEmpresa.getPontoReferencia());
			
			if (ps.executeUpdate() > 0) {
				return "Endereço cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String alterar(EnderecoEmpresaTO enderecoEmpresa) {
		String sql = "update T_IBM_END_EMPRESA set NM_LOGRADOURO = ?, BAIRRO = ?, CEP = ?, CIDADE = ?, UF = ?, PONTO_REFERENCIA = ?"
				+ "where ID_ENDERECO_IBM = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, enderecoEmpresa.getLogradouro());
			ps.setString(2,  enderecoEmpresa.getBairro());
			ps.setInt(3, enderecoEmpresa.getCep());
			ps.setString(4, enderecoEmpresa.getCidade());
			ps.setString(5, enderecoEmpresa.getUf());
			ps.setString(6, enderecoEmpresa.getPontoReferencia());
			ps.setInt(7, enderecoEmpresa.getIdEndereco());
			
			if (ps.executeUpdate() > 0) {
				return "Endereço alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String excluir(int id) {
		String sql = "delete from T_IBM_PROCESSO_SELETIVO where ID_ENDERECO_IBM = ?";
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


	public List<EnderecoEmpresaTO> listarTodos() {
		String sql = "select * from T_IBM_END_EMPRESA";
		ArrayList<EnderecoEmpresaTO> lista = new ArrayList<EnderecoEmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
				EnderecoEmpresaTO eeto = new EnderecoEmpresaTO();
				eeto.setIdEndereco(rs.getInt(1));
				eeto.setIdEmpresa(rs.getInt(2));
				eeto.setLogradouro(rs.getString(3));
				eeto.setBairro(rs.getString(4));
				eeto.setCep(rs.getInt(5));
				eeto.setCidade(rs.getString(6));
				eeto.setUf(rs.getString(7));
				eeto.setPontoReferencia(rs.getString(8));
				lista.add(eeto);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}

	public List<EnderecoEmpresaTO> listarId(int id) {
		String sql = "select * from T_IBM_END_EMPRESA where ID_ENDERECO_IBM = ?";
		ArrayList<EnderecoEmpresaTO> lista = new ArrayList<EnderecoEmpresaTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EnderecoEmpresaTO eeto = new EnderecoEmpresaTO();
					eeto.setIdEndereco(rs.getInt(1));
					eeto.setIdEmpresa(rs.getInt(2));
					eeto.setLogradouro(rs.getString(3));
					eeto.setBairro(rs.getString(4));
					eeto.setCep(rs.getInt(5));
					eeto.setCidade(rs.getString(6));
					eeto.setUf(rs.getString(7));
					eeto.setPontoReferencia(rs.getString(8));
					lista.add(eeto);
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
