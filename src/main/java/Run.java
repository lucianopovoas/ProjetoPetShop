import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.CadastrarAgendamento;
import dto.CadastroPet;
import dto.CadastroProprietario;
import entities.Agendamento;
import entities.Pet;
import entities.Proprietario;
import services.AgendamentoService;
import services.PetService;
import services.ProprietarioService;

public class Run {

	public static void main(String[] args) {
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<Proprietario> proprietarios = new ArrayList<>();
		List<Pet> pets = new ArrayList<>();
		List<Agendamento> agendamentos = new ArrayList<>();
		
		ProprietarioService proprietarioService = new ProprietarioService();
		PetService petService = new PetService();
		AgendamentoService agendamentoService = new AgendamentoService();
		
		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		
		while (exit == false) {
			int y = menu(scan);
			switch (y) {
			case 1:
				CadastroProprietario cadastroProprietario = new CadastroProprietario();
				System.out.println("Digite o nome do Proprietario: ");
				cadastroProprietario.setNome(scan.next());
				System.out.println("Digite o endereco do Proprietario: ");
				cadastroProprietario.setEndereco(scan.next());
				System.out.println("Digite o email do Proprietario: ");
				cadastroProprietario.setEmail(scan.next());
				System.out.println("Digite o telefone do Proprietario: ");
				cadastroProprietario.setTelefone(scan.next());

				Proprietario proprietario = new Proprietario(cadastroProprietario);
				proprietarioService.adicionarProprietario(proprietario, proprietarios);
				break;
			case 2:
				proprietarioService.todosProprietarios(proprietarios);
				break;
			case 3:
				CadastroProprietario atualizarProprietario = new CadastroProprietario();
				System.out.println("Digite o email do Proprietario para Alterar os Dados Dele :");
				String emailBuscar = scan.next();
				
				System.out.println("Digite o novo Endereco: ");
				atualizarProprietario.setEndereco(scan.next());
				System.out.println("Digite o novo Telefone");
				atualizarProprietario.setTelefone(scan.next());
				System.out.println("Digite o novo Email");
				atualizarProprietario.setEmail(scan.next());
				
				proprietarioService.atualizarProprietario(proprietarios, emailBuscar, atualizarProprietario);
				break;
			case 4:
				System.out.println("Digite o email do Proprietario que deseja Deletar");
				String emailBuscar2 = scan.next();
				proprietarioService.deletarProprietario(proprietarios, emailBuscar2);
				break;
			case 5:
				CadastroPet cadastroPet = new CadastroPet();
				System.out.println("Digite o Nome do Pet");
				cadastroPet.setNomePet(scan.next());
				System.out.println("Digite a Especie do Pet");
				cadastroPet.setEspecie(scan.next());
				System.out.println("Digite o Peso do Pet");
				cadastroPet.setPeso(scan.nextInt());
				System.out.println("Digite a Raça do Pet");
				cadastroPet.setRaca(scan.next());
				System.out.println("Digite o Email do Proprietario");
				cadastroPet.setEmailProprietario(scan.next());
				System.out.println("Digite a Data de Nascimento do Pet (DD/MM/YYYY)");
				cadastroPet.setNascimento(LocalDate.parse(scan.next(), fmt1));
				cadastroPet.setIdadePet(petService.calcularIdade(cadastroPet.getNascimento()));
				
				Pet pet = new Pet(cadastroPet);
				petService.adicionarPet(pet, pets, proprietarios);
				break;
			case 6:
				petService.todosPets(pets);
				break;
			case 7:
				CadastroPet atualizarPet = new CadastroPet();
				System.out.println("Digite o nome do Pet que deseja Alterar os Dados Dele :");
				String nomePetlBuscar = scan.next();
				System.out.println("Digite o email do Proprietario do Pet que deseja Alterar os Dados Dele :");
				String emailProprietarioBuscar = scan.next();
				
				System.out.println("Digite o Nome para Alterar");
				atualizarPet.setNomePet(scan.next());
				System.out.println("Digite a Raça para Alterar");
				atualizarPet.setRaca(scan.next());
				System.out.println("Digite a Idade para Alterar");
				atualizarPet.setIdadePet(scan.nextInt());
				
				petService.atualizarPet(pets, nomePetlBuscar, emailProprietarioBuscar, atualizarPet);
				break;
			case 8:
				System.out.println("Digite o nome do Pet que deseja Deletar");
				String nomePetBuscar2 = scan.next();
				System.out.println("Digite o email do Proprietario do Pet que deseja Deletar");
				String emailProprietarioBuscar2 = scan.next();
				petService.deletarPet(pets, nomePetBuscar2, emailProprietarioBuscar2);
				break;
			case 9:
				CadastrarAgendamento cadastrarAgendamento = new CadastrarAgendamento();
				System.out.println("Digite o nome do Pet");
				String nomePet = scan.next();
				System.out.println("Digite a Data para Marcar a Consulta (DD/MM/YYYY)");
				LocalDate date = LocalDate.parse(scan.next(), fmt1);
				cadastrarAgendamento.setDataHoraAgendar(date);
				System.out.println("Digite o Tipo do Serviço");
				cadastrarAgendamento.setTipoServico(scan.next());
				Pet petEncontrado = null;
				for(Pet p : pets){
					if(nomePet.equals(p.getNomePet())){
						petEncontrado = p;
						break;
					}
				}
				cadastrarAgendamento.setPrecoServico(agendamentoService.calcPrecoServico(petEncontrado , cadastrarAgendamento.getTipoServico()));
				
				Agendamento agendamento = new Agendamento(cadastrarAgendamento);
				agendamentoService.agendarServico(agendamento, agendamentos, nomePet, pets);
				break;
			case 10:
				agendamentoService.todosAgendamentos(agendamentos);
				break;
			case 11:
				CadastrarAgendamento atualizarAgendamento = new CadastrarAgendamento();
				System.out.println("Digite a data do agendamento para Alterar os Dados Dele :");
				LocalDate dataBuscar = LocalDate.parse(scan.next(), fmt1);
				
				System.out.println("Digite a nova Data: ");
				atualizarAgendamento.setDataHoraAgendar(LocalDate.parse(scan.next()));
				System.out.println("Digite para qual serviço alterar");
				atualizarAgendamento.setTipoServico(scan.next());
				System.out.println("Digite o novo preco");
				atualizarAgendamento.setPrecoServico(scan.nextDouble());
				
				agendamentoService.atualizarAgendamento(agendamentos, dataBuscar, atualizarAgendamento);
				break;
			case 12:
				System.out.println("Digite a data do Agendamento que deseja Deletar");
				LocalDate dataBuscar2 = LocalDate.parse(scan.next(), fmt1);
				agendamentoService.deletarAgendamento(agendamentos, dataBuscar2);
				break;
			case 13:
				System.out.println("Programa Finalizado");
				exit = true;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
		scan.close();
	}

	private static int menu(Scanner scan) {
		System.out.println("-----Menu-----");
		System.out.println("1 - Cadastrar Proprietario");
		System.out.println("2 - Mostrar Todos Proprietarios");
		System.out.println("3 - Atualizar Dados Proprietario");
		System.out.println("4 - Remover Proprietario");
		System.out.println("5 - Cadastrar Pet");
		System.out.println("6 - Mostrar Todos Pets");
		System.out.println("7 - Atualizar Dados Pet");
		System.out.println("8 - Remover Pet");
		System.out.println("9 - Agendar Consulta");
		System.out.println("10 - Mostrar Todos Agendamentos");
		System.out.println("11 - Atualizar Agendamento");
		System.out.println("12 - Remover Agendamento");
		System.out.println("13 - Sair");
		System.out.println("Oque deseja: ");
		int y = scan.nextInt();
		return y;
	}

}
