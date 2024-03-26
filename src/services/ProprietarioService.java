package services;

import java.util.List;

import dto.CadastroProprietario;
import entities.Proprietario;

public class ProprietarioService {

	public void adicionarProprietario(Proprietario proprietario, List<Proprietario> proprietarios) {
		boolean emailJaCadastrado = false;
		for (Proprietario p : proprietarios) {
			if (proprietario.getEmail().equals(p.getEmail())) {
				emailJaCadastrado = true;
				break;
			}
		}
		if (!emailJaCadastrado && proprietario.getEmail() != null && validarEmail(proprietario) && proprietario.getEndereco() != null & proprietario.getNome() != null && proprietario.getTelefone() != null) {
			proprietarios.add(proprietario);
			System.out.println("Adicionado com Sucesso");
		} else {
			System.out.println("Erro ao Cadastrar na Lista");
		}
	}
	
	public static boolean validarEmail(Proprietario proprietario) {
        // Verifica se o email do proprietario tem um "@" e um "."
        return proprietario.getEmail().contains("@") && proprietario.getEmail().contains(".");
    }

	public void todosProprietarios(List<Proprietario> proprietarios) {
		for (Proprietario p : proprietarios) {
			System.out.println(p);
		}
	}

	public void atualizarProprietario(List<Proprietario> proprietarios, String emailBuscar, CadastroProprietario cadastroProprietario) {
		for (Proprietario p : proprietarios) {
			if (emailBuscar.equals(p.getEmail())) {
				p.setEndereco(cadastroProprietario.getEndereco());
				p.setTelefone(cadastroProprietario.getTelefone());
				p.setEmail(cadastroProprietario.getEmail());
				System.out.println("Modificado Com Sucesso");
				break;
			} else {
				System.out.println("Nenhum Proprietario Encontrado com esses Dados");
			}
		}
	}

	public void deletarProprietario(List<Proprietario> proprietarios, String email) {
		for (Proprietario p : proprietarios) {
			if (email.equals(p.getEmail())) {
				proprietarios.remove(p);
				System.out.println("Removido Com Sucesso");
				break;
			} else {
				System.out.println("Nenhum Proprietario Encontrado com esses Dados");
			}
		}
	}
}
