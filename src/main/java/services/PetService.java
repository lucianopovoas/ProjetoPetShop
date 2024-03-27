package services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dto.CadastroPet;
import entities.Pet;
import entities.Proprietario;

public class PetService {
	
	public void adicionarPet(Pet pet, List<Pet> pets, List<Proprietario> proprietarios) {
		boolean petJaCadastrado = false;
		boolean proprietarioExistente = false;
		for (Pet p : pets) {
			if (pet.getNomePet().equals(p.getNomePet()) && pet.getEmailProprietario().equals(p.getEmailProprietario())) {
				petJaCadastrado = true;
				break;
			}
		}
		for (Proprietario p : proprietarios) {
			if (pet.getEmailProprietario().equals(p.getEmail())) {
				proprietarioExistente = true;
				break;
			}
		}
		
		if (!petJaCadastrado && proprietarioExistente && pet.getNomePet() != null && pet.getRaca() != null && pet.getEspecie() != null && pet.getNascimento() != null && pet.getIdadePet() != 0) {
			pets.add(pet);
			System.out.println("Adicionado com Sucesso");
		} else {
			System.out.println("Erro no cadastro do Pet");
		}
	}
	
	public void todosPets(List<Pet> pets) {
		for(Pet p : pets) {
			System.out.println(p);
		}
	}
	
	public void atualizarPet(List<Pet> pets, String nomePetlBuscar, String emailProprietarioBuscar, CadastroPet cadastroPet) {
		for(Pet p : pets) {
			if(nomePetlBuscar.equals(p.getNomePet()) && emailProprietarioBuscar.equals(p.getEmailProprietario())) {
				p.setRaca(cadastroPet.getRaca());
				p.setIdadePet(cadastroPet.getIdadePet());
				p.setNomePet(cadastroPet.getNomePet());
				System.out.println("Modificado Com Sucesso");
				break;
			}else {
				System.out.println("Nenhum Pet encontrado Com esses dados");
			}
		}
	}
	
	public void deletarPet(List<Pet> pets, String nomePet, String emailProprietario) {
		for(Pet p : pets) {
			if(nomePet.equals(p.getNomePet()) && emailProprietario.equals(p.getEmailProprietario())) {
				pets.remove(p);
				System.out.println("Removido Com Sucesso");
				break;
			}else {
				System.out.println("Nenhum Pet encontrado Com esses dados");
			}
		}
	}
	
	public int calcularIdade(LocalDate dataNascimento) {
		int idade = 0;
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNascimento, dataAtual);
		if(periodo.getYears() > 0 && periodo.getYears() <= 30) {
			idade = periodo.getYears();
		}		
		return idade;
	}
}
