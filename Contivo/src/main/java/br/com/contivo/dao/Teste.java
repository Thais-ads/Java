package br.com.contivo.dao;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.contivo.to.CandidatoTO;

public class Teste {

	
	public static void main(String[] args) {
	CandidatoDAO cd = new CandidatoDAO();	 
	
	try {
	
	List<CandidatoTO> lista = cd.listarTodos();
	if(lista != null) {
	for (CandidatoTO candidatoTO : lista) {
		System.out.println("Nome : " + candidatoTO.getNome());
		System.out.println("CPF: " + candidatoTO.getCpf());
		System.out.println("RG: " + candidatoTO.getRg());
		System.out.println("Rne: " + candidatoTO.getRne());
		System.out.println("estado civil: " + candidatoTO.getEstadoCivil());
		System.out.println("Tel:" + candidatoTO.getTelefone());
		System.out.println("Status tel: " + candidatoTO.getStatusEmail());
		System.out.println("Email: " + candidatoTO.getEmail());
		System.out.println("Status Enail: " + candidatoTO.getStatusEmail());
		System.out.println("Senha: " + candidatoTO.getSenha());
		System.out.println("Data Nascimento: " + candidatoTO.getDataNascimento());
		System.out.println("Genero: " + candidatoTO.getGenero());
		
	}
	 } else {
		 System.out.println("Lista falhou");
	 } } catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());}
	 
	
	}

	
}
