import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioView {
	char opcao;
	
	ArrayList<Funcionario> listFuncionario = new ArrayList(); //"BD"
	Scanner leitor = new Scanner(System.in);
	
	//instancia funcionario
	Funcionario funcionario = new Funcionario();
	
	//variaveis auxiliares	
	private int id;
	private String nome;
	private int cpf;
	private int telefone;
	private String email;
	
	
	void retornaView(char opcao) {		
		System.out.println("===== CADASTRAR FUNCIONARIO =====");
		switch (opcao) {
		  case 'i':
			  System.out.print("Nome:");
			  nome = leitor.next();
			  System.out.print("CPF:");
			  cpf = leitor.nextInt();
			  System.out.print("Telefone:");
			  telefone = leitor.nextInt();
			  System.out.print("Email:");
			  email = leitor.next();
			  id = listFuncionario.size() + 1;
			  Funcionario f = new Funcionario (id, nome, cpf, telefone, email);
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
				  System.out.print("Novo Nome/Razao Social:");
				  fAux.nome = leitor.next();
			  }
		    break;
		  case 'c':
			  System.out.println("====== Consultar funcionario ======");
			  System.out.print("Código: ");
			  codigoBusca = leitor.nextInt();
			  for(Funcionario funcionario :listFuncionario) {
					if(funcionario.id == codigoBusca) {
						System.out.println("=== Dados Funcionario ===");
						System.out.println(funcionario.id + "|" + funcionario.nome + "|" + funcionario.cpf);
						System.out.println("====================");
					}
				}
			break;
		  case 'e':
			  System.out.println("====== Excluir Funcionario ======");
			  System.out.print("Código: ");
			  codigoBusca = leitor.nextInt();
			  for(Funcionario funcionario :listFuncionario) {		
				  if(funcionario.id == codigoBusca){
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
