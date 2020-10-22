import java.util.ArrayList;
import java.util.Collections;

public class Veiculo implements Comparable<Veiculo> {
	private int id;
	private String tipo;

	// CONSTRUTOR
	Veiculo() {
	}

	Veiculo(String tipo, ArrayList<Veiculo> todosVeiculos) {
		this.tipo = tipo;

		this.id = 1;

		if (todosVeiculos.size() > 0) {
			Veiculo ultimoVeiculo = Collections.max(todosVeiculos);
			if (ultimoVeiculo != null)
				this.id = ultimoVeiculo.getId() + 1;
		}
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public int compareTo(Veiculo o) {
		if (this.getId() > o.getId()) {
			return 1;
		} else if (this.getId() < o.getId()) {
			return -1;
		}
		return 0;
	}
}
