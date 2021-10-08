package controle;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe ControleCliente para obter dados especificos de um Cliente.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import dados.Date;
import dados.Telefone;
import dados.Cliente;

public class ControleCliente {
	private Cliente[] c;
	private int qtdClientes;
	
	/**
	 * Obtenção de dados referente a pessoa cliente na classe ControleDados 
	 * @param d
	 */
	public ControleCliente(ControleDados d) {
		c = d.getCliente();
		qtdClientes = d.getQtdClientes();
		
	}
	
	/**
	 * Obtenção do nome do cliente.
	 * @return s - String
	 */
	public String[] getNomeCliente() {
		String[] s = new String[qtdClientes];
		for(int i = 0; i < qtdClientes; i++) {
			s[i] = c[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdClientes;
	}

	public void setQtd(int qtd) {
		this.qtdClientes = qtd;
	}
	
	public String getNome(int i) {		
		return c[i].getNome();
	}
	
	public Date getDataNascimento(int i) {
		return c[i].getDataNascimento();
	}
	
	public Telefone getTelefone(int i) {
		return c[i].getTelefone();
	}
	
	public String getCPF(int i) {
		String numCPF = String.valueOf(c[i].getCPF());
		return numCPF;
	}
	

	public void setQtdClientes(int qtdClientes) {
		this.qtdClientes = qtdClientes;
	}
	
	
	public String getEndereco(int i) {		
		return c[i].getEndereco();
	}	
	
}
