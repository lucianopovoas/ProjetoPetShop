package services;

import java.time.LocalDate;
import java.util.List;

import dto.CadastrarAgendamento;
import entities.Agendamento;
import entities.Pet;

public class AgendamentoService {
	public void agendarServico(Agendamento agendamento, List<Agendamento> agendamentos, String nomePet ,List<Pet> pets) {
		boolean verificacao = false;
		boolean verificacao2 = false;
		LocalDate dataAtual = LocalDate.now();
		
		for(Agendamento a : agendamentos) {
			if(agendamento.getDataHoraAgendar().isEqual(a.getDataHoraAgendar())) {
				verificacao = true;
				break;
			}
		}
		for(Pet p : pets) {
			if(p.getNomePet().equals(nomePet)) {
				verificacao2 = true;
				break;				
			}
		}
		if(verificacao == false && verificacao2 == true && agendamento.getDataHoraAgendar().isAfter(dataAtual) && agendamento.getDataHoraAgendar() != null && agendamento.getTipoServico() != null && agendamento.getTipoServico() == "consulta" && agendamento.getTipoServico() == "tosa" && agendamento.getTipoServico() == "banho") {
			agendamentos.add(agendamento);
			System.out.println("Marcado com Sucesso");
		} else {
			System.out.println("Erro para marcar");
		}
	}
	
	public void todosAgendamentos(List<Agendamento> agendamentos) {
		for (Agendamento a : agendamentos) {
			System.out.println(a);
		}
	}

	public void atualizarAgendamento(List<Agendamento> agendamentos, LocalDate dataBuscar, CadastrarAgendamento cadastrarAgendamento) {
		for (Agendamento a : agendamentos) {
			if (dataBuscar.equals(a.getDataHoraAgendar())) {
				a.setDataHoraAgendar(cadastrarAgendamento.getDataHoraAgendar());
				a.setTipoServico(cadastrarAgendamento.getTipoServico());
				a.setPrecoServico(cadastrarAgendamento.getPrecoServico());
				System.out.println("Modificado Com Sucesso");
				break;
			} else {
				System.out.println("Nenhum Proprietario Encontrado com esses Dados");
			}
		}
	}
	
	public void deletarAgendamento(List<Agendamento> agendamentos, LocalDate dataBuscar2) {
		for (Agendamento a : agendamentos) {
			if (dataBuscar2.isEqual(a.getDataHoraAgendar())) {
				agendamentos.remove(a);
				System.out.println("Removido Com Sucesso");
				break;
			} else {
				System.out.println("Nenhum Proprietario Encontrado com esses Dados");
			}
		}
	}
	
	public String calcPrecoServico(String nomeServico) {
		String preco = "0";
		switch (nomeServico) {
		case "consulta":
			preco = "10";
		case "banho":
			preco = "30";
		case "tosa":
			preco = "50";
		default:
			System.out.println("Digite um Serviço valido");
		}
		return preco; 
	}
}
