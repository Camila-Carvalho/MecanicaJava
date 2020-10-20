
public abstract class Pessoa {
	protected int id;
	protected String nome;
	protected int cpf;
	protected int telefone;
	protected String email;
	
	//CONTRUTOR
	Pessoa(){}
	
	Pessoa(String _nome, int _cpf, int _telefone, String _email){
		nome = _nome;
		cpf = _cpf;
		telefone = _telefone;
		email = _email;
	}
}
