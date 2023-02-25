package br.com.contivo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.contivo.to.SkillTO;

public class SkillDAO{
	
	private Connection con = null;

	@SuppressWarnings("static-access")
	public SkillDAO() {
		this.con = new Conexao().abriConexao();
	}
	

	public String inserir(SkillTO skill) {
	
		String sql = "insert into T_IBM_SKILL(NOME_SKILL,TIPO_SKILL,NIVEL_SKILL) "
				+ "values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, skill.getNomeSkill());
			ps.setString(2, skill.getTipoSkill());
			ps.setString(3, skill.getNivelSkill());
			
			if (ps.executeUpdate() > 0) {
				return "Skill cadastrado com sucesso.";
			} else {
				return "Erro ao cadastrar.";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}


	public String alterar(SkillTO skill) {
		String sql = "update T_IBM_SKILL set NOME_SKILL = ?, TIPO_SKILL = ?, NIVEL_SKILL where ID_SKILL = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, skill.getNomeSkill());
			ps.setString(2, skill.getTipoSkill());
			ps.setString(3, skill.getNivelSkill());
			ps.setInt(4, skill.getIdSkill());
			if (ps.executeUpdate() > 0) {
				return "Skill alterado com sucesso.";
			} else {
				return "Erro ao alterar o cadastro.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public String excluir(int id) {
		String sql = "delete from T_IBM_SKILL where ID_SKILL = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() > 0) {
				return "Skill excluido com sucesso.";
			} else {
				return "Erro ao excluir score.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}


	public List<SkillTO> listarTodos() {
		String sql = "select * from T_IBM_SKILL";
		ArrayList<SkillTO> lista = new ArrayList<SkillTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					SkillTO sto = new SkillTO();
					sto.setIdSkill(rs.getInt(1));
					sto.setNomeSkill(rs.getString(2));
					sto.setTipoSkill(rs.getString(3));
					sto.setNivelSkill(rs.getString(4));
					lista.add(sto);					
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

	}
	
	public List<SkillTO> listarId(int id) {
		String sql = "select * from T_IBM_SKILL where ID_SKILL = ?";
		ArrayList<SkillTO> lista = new ArrayList<SkillTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					SkillTO sto = new SkillTO();
					sto.setIdSkill(rs.getInt(1));
					sto.setNomeSkill(rs.getString(2));
					sto.setTipoSkill(rs.getString(3));
					sto.setNivelSkill(rs.getString(4));
					lista.add(sto);					
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
