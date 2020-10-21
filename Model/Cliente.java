import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Cliente extends Pessoa  implements Comparable<Cliente> {
	String endereco;
	String dataNascimento; //verificar
	char sexo;
	String estadoCivil;
	String situacao;
	
	Cliente(){}
	
	//CONTRUTOR
	Cliente(String _nome, 
			String _cpf, 
			String _telefone, 
			String _email,
			String _endereco,
			String _dataNascimento,
			char _sexo,
			String _estadoCivil,
			ArrayList<Cliente> todosClientes) 
	{
		super(_nome, _cpf, _telefone, _email);
		endereco = _endereco;
		dataNascimento = _dataNascimento;
		sexo = _sexo;
		estadoCivil = _estadoCivil;
		
		this.AtivarCliente();
		
		this.id = 1;

		if (todosClientes.size() > 0) {
			Cliente ultimoCliente = Collections.max(todosClientes);
			if (ultimoCliente != null)
				this.id = ultimoCliente.getId() + 1;
		}
		
	}
	
	public void AtivarCliente() {
		this.situacao = "Ativo";
	}
	
	public void InativarCliente() {
		this.situacao = "Inativo";
	}
	
	@Override
	public int compareTo(Cliente o) {
		if (this.getId() > o.getId()) {
			return 1;
		} else if (this.getId() < o.getId()) {
			return -1;
		}
		return 0;
	}
}
