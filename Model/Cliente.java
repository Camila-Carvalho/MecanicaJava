import java.util.Date;

public class Cliente extends Pessoa {
	String endereco;
	Date dataNascimento; //verificar
	char sexo;
	String estadoCivil;
	String situacao;
	
	Cliente(){}
	
	//CONTRUTOR
	Cliente(int _id,
			String _nome, 
			int _cpf, 
			int _telefone, 
			String _email,
			String _endereco,
			Date _dataNascimento,
			char _sexo,
			String _estadoCivil,
			String _situacao) 
	{
		super(_id, _nome, _cpf, _telefone, _email);
		endereco = _endereco;
		dataNascimento = _dataNascimento;
		sexo = _sexo;
		estadoCivil = _estadoCivil;
		situacao = _situacao;
		
	}
}
