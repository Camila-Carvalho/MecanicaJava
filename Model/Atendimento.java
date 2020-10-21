import java.util.ArrayList;
import java.util.Collections;

public class Atendimento implements Comparable<Atendimento> {
	private int codigo = 1;
	private int ano;
	private int mes;
	private int dia;
	private int horaInicio;
	private int horaFim;
	private Funcionario funcionario;
	private Cliente cliente;
	private Servico servico;
	private String status;
	private String descricao;

	public Atendimento(int ano, int mes, int dia, int hora, Funcionario funcionario, Cliente cliente, Servico servico,
			String status, String descricao, ArrayList<Atendimento> todosAtendimentos) {
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.horaInicio = hora;
		this.horaFim = hora + 2;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.servico = servico;
		this.status = status;
		this.descricao = descricao;

		if (todosAtendimentos.size() > 0) {
			Atendimento ultimoAtendimento = Collections.max(todosAtendimentos);
			if (ultimoAtendimento != null)
				this.codigo = ultimoAtendimento.getCodigo() + 1;
		}

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	@Override
	public int compareTo(Atendimento o) {
		if (this.getCodigo() > o.getCodigo()) {
			return 1;
		} else if (this.getCodigo() < o.getCodigo()) {
			return -1;
		}
		return 0;
	}
}
