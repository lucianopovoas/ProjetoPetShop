package entities;

import dto.CadastroProprietario;

public class Proprietario {
	private String nome, endereco, email, telefone;

	public Proprietario() {
	}

	public Proprietario(CadastroProprietario cadastroProprietario) {
		this.nome = cadastroProprietario.getNome();
		this.endereco = cadastroProprietario.getEndereco();
		this.email = cadastroProprietario.getEmail();
		this.telefone = cadastroProprietario.getTelefone();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Proprietario nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", telefone=" + telefone;
	}
	
	
}
