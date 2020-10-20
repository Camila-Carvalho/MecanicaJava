
public abstract class Pessoa {
	protected int id;
	protected String nome;
	protected int cpf;
	protected int telefone;
	protected String email;
	
	//CONTRUTOR
	Pessoa(){}
	
	Pessoa(int _id, String _nome, int _cpf, int _telefone, String _email){
		id = _id;
		nome = _nome;
		cpf = _cpf;
		telefone = _telefone;
		email = _email;
	}
}
