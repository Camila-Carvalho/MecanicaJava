import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioView {
	Scanner leitor = new Scanner(System.in);
	
	//variaveis auxiliares	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	
	void view(char opcao, ArrayList<Funcionario> listFuncionario) {		
		switch (opcao) {
		  case 'i':
			  System.out.println("===== Cadastrar Funcionario =====");
			  System.out.print("Nome:");
			  nome = leitor.nextLine();
			  System.out.print("CPF:");
			  cpf = leitor.nextLine();
			  System.out.print("Telefone:");
			  telefone = leitor.nextLine();
			  System.out.print("Email:");
			  email = leitor.nextLine();
			  Funcionario f = new Funcionario (nome, cpf, telefone, email, listFuncionario);
			  listFuncionario.add(f);
		    break;
		  case 'a':
			  System.out.println("====== Alterar Funcionario ======");
			  Funcionario fAux = new Funcionario();
			  System.out.print("Código: ");
			  int codigoBusca = leitor.nextInt();
			  for(Funcionario funcionario :listFuncionario) {		
				  if(funcionario.id == codigoBusca){
					  fAux = funcionario;
				  };
			  }
			  System.out.print("Altera nome (s)Sim (n)Nao ");
			  char op = leitor.next().charAt(0);
			  if(op == 's' || op == 'S') {					  
				  System.out.print("Novo Nome:");
				  String novoNome = leitor.nextLine();
				  fAux.setNome(novoNome);
			  }
		    break;
		  case 'c':
			  System.out.println("====== Consultar funcionario ======");
			  System.out.print("Código: ");
			  codigoBusca = leitor.nextInt();
			  for(Funcionario funcionario :listFuncionario) {
					if(funcionario.getId() == codigoBusca) {
						System.out.println("=== Dados Funcionario ===");
						System.out.println(funcionario.getId() + " | " + funcionario.getNome() + " | " + funcionario.getCpf());
						System.out.println("====================");
					}
				}
			break;
		  case 'e':
			  System.out.println("====== Excluir Funcionario ======");
			  System.out.print("Código: ");
			  codigoBusca = leitor.nextInt();
			  for(Funcionario funcionario :listFuncionario) {		
				  if(funcionario.getId() == codigoBusca){
					  listFuncionario.remove(funcionario);
				  };
			  }
			  //System.out.println("==================");	
			break;
		  default:
			  System.out.println("Valor informado inválido!");
		}
	}
}
