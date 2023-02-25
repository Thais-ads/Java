package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.EnderecoCandidatoTO;

public class EnderecoCandidatoDAO {
	private Connection con = null;

	@SuppressWarnings("static-access")
	public EnderecoCandidatoDAO() {
		this.con = new Conexao().abriConexao();
	}

	public String inserir(EnderecoCandidatoTO enderecoCandidato) {
		String sql = "insert into T_IBM_END_CANDIDATO(LOGRADOURO, BAIRRO, CIDADE,UF,CEP,PONTO_REFERENCIA,DT_INICIO,DT_FIM) "
				+ "values(?,?,?,?,?,?,to_DATE(?,'dd/mm/yyyy'),to_DATE(?,'dd/mm/yyyy'))";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(3, enderecoCandidato.getLogradouro());
			ps.setString(4, enderecoCandidato.getBairro());
			ps.setString(5, enderecoCandidato.getCidade());
			ps.setString(6, enderecoCandidato.getUf());
			ps.setInt(7, enderecoCandidato.getCep());
			ps.setString(8, enderecoCandidato.getComplemento());
			ps.setString(9, enderecoCandidato.getDataInicio());
			ps.setString(10, enderecoCandidato.getDataFim());
			if (ps.executeUpdate() > 0) {
				return "Endereço cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(EnderecoCandidatoTO enderecoCandidato) {
		
		String sql = "update T_IBM_END_CANDIDATO set LOGRADOURO = ?, BAIRRO = ?, CIDADE = ?, UF = ?, CEP = ?, PONTO_REFERENCIA = ?,"
				+ " DATA_INICIO = to_DATE(?,'dd/mm/yyyy'), DATA_FIM = to_DATE(?,'dd/mm/yyyy')"
				+ "where ID_ENDERECO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, enderecoCandidato.getLogradouro());
			ps.setString(2, enderecoCandidato.getBairro());
			ps.setString(3, enderecoCandidato.getCidade());
			ps.setString(4, enderecoCandidato.getUf());
			ps.setInt(5, enderecoCandidato.getCep());
			ps.setString(6, enderecoCandidato.getComplemento());
			ps.setString(7, enderecoCandidato.getDataFim());
			ps.setString(8, enderecoCandidato.getDataFim());
			ps.setInt(9, enderecoCandidato.getIdEndereco());
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
		
		String sql = "delete from T_IBM_END_CANDIDATO where ID_ENDERECO = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Endereço excluido com sucesso.";
			} else {
				return "Erro ao excluir excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<EnderecoCandidatoTO> listarTodos() {
		String sql = "select * from T_IBM_END_CANDIDATO";
		ArrayList<EnderecoCandidatoTO> lista = new ArrayList<EnderecoCandidatoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EnderecoCandidatoTO ecto = new EnderecoCandidatoTO();
					ecto.setIdEndereco(rs.getInt(1));
					ecto.setIdCandidato(rs.getInt(2));
					ecto.setLogradouro(rs.getString(3));
					ecto.setUf(rs.getString(4));
					ecto.setComplemento(rs.getString(5));
					ecto.setDataInicio(rs.getString(6));
					ecto.setDataFim(rs.getString(7));
					ecto.setBairro(rs.getString(8));
					ecto.setCpf(rs.getInt(9));
					ecto.setCidade(rs.getString(10));
					lista.add(ecto);

				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<EnderecoCandidatoTO> listarId(int id) {
		String sql = "select * from T_IBM_END_CANDIDATO where ID_END_CANDIDATO = ?";
		ArrayList<EnderecoCandidatoTO> lista = new ArrayList<EnderecoCandidatoTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					EnderecoCandidatoTO ecto = new EnderecoCandidatoTO();
					ecto.setIdEndereco(rs.getInt(1));
					ecto.setIdCandidato(rs.getInt(2));
					ecto.setLogradouro(rs.getString(3));
					ecto.setUf(rs.getString(4));
					ecto.setComplemento(rs.getString(5));
					ecto.setDataInicio(rs.getString(6));
					ecto.setDataFim(rs.getString(7));
					ecto.setBairro(rs.getString(8));
					ecto.setCep(rs.getInt(9));
					ecto.setCidade(rs.getString(10));
					lista.add(ecto);
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

