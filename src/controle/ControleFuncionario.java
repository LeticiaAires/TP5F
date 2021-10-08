package controle;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe ControleFuncionario para obter dados especificos de um Funcionário.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import dados.Date;
import dados.Funcionario;
import dados.Telefone;

public class ControleFuncionario {
	private Funcionario[] f;
	private int qtdFuncionarios;
	
	/**
	 * Obtenção de dados referente a pessoa funcionário na classe ControleDados.
	 * @param d
	 */
	public ControleFuncionario(ControleDados d) {
		this.f = d.getFuncionarios();
		this.qtdFuncionarios = d.getQtdFuncionario();
		
	}
	
	/**
	 * Obtenção do nome do cliente.
	 * @return String - s
	 */
	public String[] getNomeFuncionario() {
		String[] s = new String[qtdFuncionarios];
		for(int i = 0; i < qtdFuncionarios; i++) {
			s[i] = f[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdFuncionarios;
	}

	public void setQtd(int qtd) {
		this.qtdFuncionarios = qtd;
	}
	
	public String getNome(int i) {		
		return f[i].getNome();
	}
	
	public Date getDataNascimento(int i) {
		return f[i].getDataNascimento();
	}
	
	public Telefone getTelefone(int i) {
		return f[i].getTelefone();
	}
	
	public String getCPF(int i) {
		String numCPF = String.valueOf(f[i].getCPF());
		return numCPF;
	}
	

	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	
	
	public String getPosto(int i) {		
		return f[i].getPosto();
	}
	
	public Float getSalario(int i) {		
		return f[i].getSalario();
	}
	
}
