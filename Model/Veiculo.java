import java.util.ArrayList;
import java.util.Collections;

public class Veiculo implements Comparable<Veiculo> {
	private int id;
	private String placa;

	// CONSTRUTOR
	Veiculo() {
	}

	Veiculo(String placa, ArrayList<Veiculo> todosVeiculos) {
		this.placa = placa;

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
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Veiculo getById(int idBusca, ArrayList<Veiculo> todosVeiculos){
		Veiculo veiculo = new Veiculo();
		for(Veiculo v : todosVeiculos) {
			if(v.id == idBusca) {
				veiculo = v;
			}
			else {
				veiculo = null;
			}
		}
		return veiculo;
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
