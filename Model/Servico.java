import java.util.ArrayList;
import java.util.Collections;

public class Servico implements Comparable<Servico> {
	int id;
	String descricao;

	// CONSTRUTOR
	Servico() {
	}

	Servico(String descricao, ArrayList<Servico> todosServicos) {
		this.descricao = descricao;

		this.id = 1;

		if (todosServicos.size() > 0) {
			Servico ultimoServico = Collections.max(todosServicos);
			if (ultimoServico != null)
				this.id = ultimoServico.getId() + 1;
		}
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(Servico o) {
		if (this.getId() > o.getId()) {
			return 1;
		} else if (this.getId() < o.getId()) {
			return -1;
		}
		return 0;
	}
}
