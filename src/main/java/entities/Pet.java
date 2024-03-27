package entities;

import java.time.LocalDate;

import dto.CadastroPet;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {
	protected String nomePet, especie, raca, emailProprietario;
	protected int idadePet, peso;
	protected LocalDate nascimento;
	
	public Pet(CadastroPet cadastroPet) {
		this.nomePet = cadastroPet.getNomePet();
		this.especie = cadastroPet.getEspecie();
		this.raca = cadastroPet.getRaca();
		this.idadePet = cadastroPet.getIdadePet();
		this.emailProprietario = cadastroPet.getEmailProprietario();
		this.nascimento = cadastroPet.getNascimento();
		this.peso = cadastroPet.getPeso();
	}

}
