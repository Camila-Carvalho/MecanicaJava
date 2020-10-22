import java.util.ArrayList;
import java.util.Scanner;

public class VeiculoView {
	Scanner leitor = new Scanner(System.in);
	// variaveis auxiliares
	private String tipo;

	void view(char opcao, ArrayList<Veiculo> listVeiculos) {
		switch (opcao) {
		case 'i':
			System.out.println("===== Cadastrar Veiculo =====");
			System.out.print("Tipo de veiculo:");
			tipo = leitor.nextLine();
			Veiculo v = new Veiculo(tipo, listVeiculos);
			listVeiculos.add(v);
			break;
		default:
			System.out.println("Valor informado inválido!");
		}
	}
}
