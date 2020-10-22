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
	private Veiculo veiculo;
	private String status;
	private String descricao;
	
	public Atendimento(int ano, int mes, int dia, int hora, Funcionario funcionario, Cliente cliente, Servico servico, Veiculo veiculo,
			String status, String descricao, ArrayList<Atendimento> todosAtendimentos) {
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.horaInicio = hora;
		this.horaFim = hora + 2;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.servico = servico;
		this.veiculo = veiculo;
		this.status = status;
		this.descricao = descricao;

		if (todosAtendimentos.size() > 0) {
			Atendimento ultimoAtendimento = Collections.max(todosAtendimentos);
			if (ultimoAtendimento != null)
				this.codigo = ultimoAtendimento.getCodigo() + 1;
		}

	}
	
	private Atendimento(int ano, int mes, int dia, int hora) {
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.horaInicio = hora;
		this.horaFim = hora + 2;
	}
	
	private Atendimento() {}

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
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
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
	
	public void UpdateAtendimento(Atendimento atendimento, ArrayList<Atendimento> todosAtendimentos) {
		Atendimento a = this.getById(atendimento.codigo, todosAtendimentos);
		a.setAno(atendimento.ano);
		a.setMes(atendimento.mes);
		a.setDia(atendimento.dia);
		a.setHoraInicio(atendimento.horaInicio);
		a.setFuncionario(atendimento.funcionario);
		a.setCliente(atendimento.cliente);
		a.setServico(atendimento.servico);
		a.setVeiculo(atendimento.veiculo);
		a.setDescricao(atendimento.descricao);
		a.setStatus(atendimento.status);
	}
	
	public Atendimento getById(int idBusca, ArrayList<Atendimento> todosAtendimentos){
		Atendimento atendimento = new Atendimento();
		for(Atendimento a : todosAtendimentos) {
			if(a.codigo == idBusca) {
				atendimento = a;
			}
		}
		return atendimento;
	}
	
	public Atendimento getAtendimentoByData(int ano, int mes, int dia, int hora, ArrayList<Atendimento> todosAtendimentos) {
		Atendimento atendimento = new Atendimento(ano, mes, dia, hora);
		for(Atendimento a : todosAtendimentos) {
			if(a.ano == ano && a.mes == mes && a.dia == dia && a.horaInicio == hora) {
				atendimento = a;
			}
			else {
				atendimento = null;
			}
		}
		return atendimento;
	}
	
	public void excluiAtendimento(int ano, int mes, int dia, int hora, ArrayList<Atendimento> todosAtendimentos) {
		for(Atendimento a : todosAtendimentos) {
			if(a.ano == ano && a.mes == mes && a.dia == dia && a.horaInicio == hora) {
				todosAtendimentos.remove(a);
			}
		}
	}
	
	public boolean verificaAtendimento(int ano, int mes, int dia, int hora, ArrayList<Atendimento> todosAtendimentos) {
		boolean x = false;
		for(Atendimento a : todosAtendimentos) {
			if(a.ano == ano && a.mes == mes && a.dia == dia && a.horaInicio == hora) {
				x = true;
			}
		}
		return x;
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
