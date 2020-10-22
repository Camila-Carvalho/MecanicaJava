import java.util.ArrayList;
import java.util.Collections;

public class Cliente extends Pessoa implements Comparable<Cliente> {
	private String endereco;
	private String dataNascimento;
	private char sexo;
	private String estadoCivil;
	private String situacao;

	Cliente() {
	}

	// CONTRUTOR
	Cliente(String _nome, String _cpf, String _telefone, String _email, String _endereco, String _dataNascimento,
			char _sexo, String _estadoCivil, ArrayList<Cliente> todosClientes) {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Cliente getById(int idBusca, ArrayList<Cliente> todosClientes){
		Cliente cliente = new Cliente();
		for(Cliente c : todosClientes) {
			if(c.id == idBusca) {
				cliente = c;
			}
		}
		return cliente;
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
