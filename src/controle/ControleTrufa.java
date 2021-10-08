package controle;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe ControleTrufa para obter dados especificos de uma trufa.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import dados.Date;
import dados.Trufa;

public class ControleTrufa {
	private Trufa[] t;
	private int qtdTrufas;
	
	/**
	 * Obtenção de dados referente ao produto trufa na classe ControleDados
	 * @param d
	 */
	public ControleTrufa(ControleDados d) {
		t = d.getTrufa();
		qtdTrufas = d.getQtdTrufas();
		
	}
	
	/**
	 * Obtenção do nome do produto trufa.
	 * @return String - s
	 */
	public String[] getNomeTrufa() {
		String[] s = new String[qtdTrufas];
		for(int i = 0; i < qtdTrufas; i++) {
			s[i] = t[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdTrufas;
	}

	public void setQtd(int qtd) {
		this.qtdTrufas = qtd;
	}
	
	public String getNome(int i) {		
		return t[i].getNome();
	}
	
	public Double getValorCompra(int i) {
		return t[i].getValorCompra();
	}
	
	public Date getDataValidade(int i) {
		return t[i].getDataValidade();
	}
	
	public String getSabores(int i) {
		return t[i].getSabores();
	}
	
	public Double getPeso(int i) {
		return t[i].getPeso();
	}
	
	public String getRecheio(int i) {
		return t[i].getRecheio();
	}

	public void setQtdTrufas(int qtdTrufas) {
		this.qtdTrufas = qtdTrufas;
	}
}
