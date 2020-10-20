import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class ClienteView {
	char opcao;
	
	ArrayList<Cliente> listCliente = new ArrayList(); //"BD"
	Scanner leitor = new Scanner(System.in);
	
	//instancia cliente
	Cliente cliente = new Cliente();
	
	//variaveis auxiliares	
	private int id;
	private String nome;
	private int cpf;
	private int telefone;
	private String email;
	private String endereco;
	private Date dataNascimento;
	private char sexo;
	private String estadoCivil;
	private String situacao;
	
	
	void retornaView(char opcao) {		
		System.out.println("===== Cadastrar Cliente =====");
		switch (opcao) {
		  case 'i':
			  try {
				System.out.print("Nome:");
			  	nome = leitor.next();
			  	System.out.print("CPF:");
			  	cpf = leitor.nextInt();
			  	System.out.print("Telefone:");
			  	telefone = leitor.nextInt();
			  	System.out.print("Email:");
			  	email = leitor.next();
			  	System.out.print("Endereco:");
			  	endereco = leitor.next();
			  	System.out.print("Data Nascimento:");
			  	String dataNasc = leitor.next();
			  	DateFormat dataForm = new SimpleDateFormat("dd/MM/yyyy");// formatar a data
			  	dataNascimento = dataForm.parse(dataNasc);
			  	System.out.print("Sexo: (F)feminino (M)masculino");
			  	sexo = leitor.next().charAt(0);
			  	System.out.print("Estado civil:");
			  	estadoCivil = leitor.next();
			  	System.out.print("Situacao:");
			  	situacao = leitor.next();
			  	id = listCliente.size() + 1;
			  	Cliente c = new Cliente (id, nome, cpf, telefone, email, endereco, dataNascimento, sexo, estadoCivil, situacao);
			  	listCliente.add(c);
			  }
			  catch (Exception ex) {
				  ex.printStackTrace();
			  }
		    break;
		  case 'a':
			  System.out.println("====== Alterar Cliente ======");
			  Cliente cAux = new Cliente();
			  System.out.print("Código: ");
			  int codigoBusca = leitor.nextInt();
			  for(Cliente cliente :listCliente) {		
				  if(cliente.id == codigoBusca){
					  cAux = cliente;
				  };
			  }
			  System.out.print("Altera nome (s)Sim (n)Nao ");
			  char op = leitor.next().charAt(0);
			  if(op == 's' || op == 'S') {					  
				  System.out.print("Novo Nome/Razao Social:");
				  cAux.nome = leitor.next();
			  }
		    break;
		  case 'c':
			  System.out.println("====== Consultar Cliente ======");
			  System.out.print("Código: ");
			  codigoBusca = leitor.nextInt();
			  for(Cliente cliente :listCliente) {
					if(cliente.id == codigoBusca) {
						System.out.println("=== Dados Funcionario ===");
						System.out.println(cliente.id + "|" + cliente.nome + "|" + cliente.cpf);
						System.out.println("====================");
					}
				}
			break;
		  case 'e':
			  System.out.println("====== Excluir Cliente ======");
			  System.out.print("Código: ");
			  codigoBusca = leitor.nextInt();
			  for(Cliente cliente :listCliente) {		
				  if(cliente.id == codigoBusca){
					  listCliente.remove(cliente);
				  };
			  }
			  //System.out.println("==================");	
			break;
		  default:
			  System.out.println("Valor informado inválido!");
		}
	}
}
