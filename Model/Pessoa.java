
public abstract class Pessoa {
	protected int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	//CONTRUTOR
	Pessoa(){}
	
	Pessoa(String _nome, String _cpf, String _telefone, String _email){
		nome = _nome;
		cpf = _cpf;
		telefone = _telefone;
		email = _email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
