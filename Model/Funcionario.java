import java.util.ArrayList;
import java.util.Collections;

public class Funcionario extends Pessoa implements Comparable<Funcionario> {

	Funcionario() {
	}

	Funcionario(String _nome, String _cpf, String _telefone, String _email, ArrayList<Funcionario> todosFuncionarios) {
		super(_nome, _cpf, _telefone, _email);

		this.id = 1;

		if (todosFuncionarios.size() > 0) {
			Funcionario ultimoFuncionario = Collections.max(todosFuncionarios);
			if (ultimoFuncionario != null)
				this.id = ultimoFuncionario.getId() + 1;
		}

	}
	
	@Override
	public int compareTo(Funcionario o) {
		if (this.getId() > o.getId()) {
			return 1;
		} else if (this.getId() < o.getId()) {
			return -1;
		}
		return 0;
	}

}
