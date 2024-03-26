package dto;

import java.time.LocalDate;

public class CadastroPet {
	private String nomePet, especie, raca, emailProprietario;
	int idadePet;
	private LocalDate nascimento;
	
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public int getIdadePet() {
		return idadePet;
	}
	public void setIdadePet(int i) {
		this.idadePet = i;
	}
	public String getEmailProprietario() {
		return emailProprietario;
	}
	public void setEmailProprietario(String emailProprietario) {
		this.emailProprietario = emailProprietario;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
}
