import java.util.ArrayList;
import java.util.Scanner;

public class ClienteView {
	//char opcao;

	Scanner leitor = new Scanner(System.in);

	// instancia cliente
	// Cliente cliente = new Cliente();

	// variaveis auxiliares
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String endereco;
	private String dataNascimento;
	private char sexo;
	private String estadoCivil;
	private String situacao;

	void retornaView(char opcao, ArrayList<Cliente> listCliente) {
		switch (opcao) {
		case 'i':
			System.out.println("===== Cadastrar Cliente =====");
			try {
				System.out.print("Nome:");
				nome = leitor.nextLine();
				System.out.print("CPF:");
				cpf = leitor.nextLine();
				System.out.print("Telefone:");
				telefone = leitor.nextLine();
				System.out.print("Email:");
				email = leitor.nextLine();
				System.out.print("Endereco:");
				endereco = leitor.nextLine();
				System.out.print("Data Nascimento:");
				// String dataNasc = leitor.nextLine();
				// DateFormat dataForm = new SimpleDateFormat("dd/MM/yyyy");// formatar a data
				// dataNascimento = dataForm.parse(dataNasc);
				dataNascimento = leitor.nextLine();
				System.out.print("Sexo: (F)feminino (M)masculino");
				sexo = leitor.nextLine().charAt(0);
				System.out.print("Estado civil:");
				estadoCivil = leitor.nextLine();
				// System.out.print("Situacao:");
				// situacao = leitor.nextLine();
				// id = listCliente.size() + 1;
				Cliente c = new Cliente(nome, cpf, telefone, email, endereco, dataNascimento, sexo, estadoCivil,
						listCliente);
				listCliente.add(c);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			break;
		case 'a':
			System.out.println("====== Alterar Cliente ======");
			Cliente cAux = new Cliente();
			System.out.print("Código: ");
			int codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					cAux = cliente;
				}
				;
			}
			System.out.print("Altera nome (s)Sim (n)Nao ");
			char op = leitor.next().charAt(0);
			if (op == 's' || op == 'S') {
				System.out.print("Novo Nome/Razao Social:");
				cAux.nome = leitor.next();
			}
			break;
		case 'c':
			System.out.println("====== Consultar Cliente ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					System.out.println("=== Dados Funcionario ===");
					System.out.println(cliente.id + "|" + cliente.nome + "|" + cliente.cpf);
					System.out.println("====================");
				}
			}
			break;
		case 'e':
			System.out.println("====== Inativar Cliente ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					cliente.InativarCliente();
					System.out.println("!!! Cliente Inativado com Sucesso !!!");
				}
				;
			}
			break;
		case 'r':
			System.out.println("====== Reativar Cliente ======");
			System.out.print("Código: ");
			codigoBusca = leitor.nextInt();
			for (Cliente cliente : listCliente) {
				if (cliente.id == codigoBusca) {
					cliente.AtivarCliente();
					System.out.println("!!! Cliente Reativado com Sucesso !!!");
				}
				;
			}
			break;
		default:
			System.out.println("Valor informado inválido!");
		}
	}
}
