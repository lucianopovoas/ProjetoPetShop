package entities;

import java.time.LocalDate;

import dto.CadastroPet;

public class Pet {
	private String nomePet, especie, raca, emailProprietario;
	int idadePet;
	private LocalDate nascimento;
	
	public Pet(CadastroPet cadastroPet) {
		this.nomePet = cadastroPet.getNomePet();
		this.especie = cadastroPet.getEspecie();
		this.raca = cadastroPet.getRaca();
		this.idadePet = cadastroPet.getIdadePet();
		this.emailProprietario = cadastroPet.getEmailProprietario();
		this.nascimento = cadastroPet.getNascimento();
	}
	
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
	public void setIdadePet(int idadePet) {
		this.idadePet = idadePet;
	}
	public String getEmailProprietario() {
		return emailProprietario;
	}
	public void setEmailProprietario(String nomeProprietario) {
		this.emailProprietario = nomeProprietario;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public String toString() {
		return "Pet nomePet=" + nomePet + ", especie=" + especie + ", raca=" + raca + ", idadePet=" + idadePet
				+ ", EmailProprietario=" + emailProprietario + ", nascimento=" + nascimento;
	}
}
