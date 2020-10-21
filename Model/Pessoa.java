
public abstract class Pessoa {
	protected int id;
	protected String nome;
	protected String cpf;
	protected String telefone;
	protected String email;
	
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
}
