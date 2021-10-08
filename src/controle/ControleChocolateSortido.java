package controle;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe ControleChocolateSortido para obter dados especificos de um pruduto.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import dados.Date;
import dados.ChocolateSortido;

public class ControleChocolateSortido {
	private ChocolateSortido[] cs;
	private int qtdChoc;
	
	/**
	 * Obtenção de dados referente ao produto Chocolate Sortido na classe ControleDados
	 * @param d
	 */
	public ControleChocolateSortido(ControleDados d) {
		cs = d.getChocolateSortido();
		qtdChoc = d.getQtdChocolateSortido();
		
	}
	
	/**
	 * Obtenção do nome do produto chocolate sortido.
	 * @return String - s
	 */
	public String[] getNomeChoc() {
		String[] s = new String[qtdChoc];
		for(int i = 0; i < qtdChoc; i++) {
			s[i] = cs[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdChoc;
	}

	public void setQtd(int qtd) {
		this.qtdChoc = qtd;
	}
	
	public String getNome(int i) {		
		return cs[i].getNome();
	}
	
	public Double getValorCompra(int i) {
		return cs[i].getValorCompra();
	}
	
	public Date getDataValidade(int i) {
		return cs[i].getDataValidade();
	}
	
	public String getSabores(int i) {
		return cs[i].getSabores();
	}
	
	public Double getPeso(int i) {
		return cs[i].getPeso();
	}
	
	public Integer getQuantidade(int i) {
		return cs[i].getQuantidade();
	}

	public void setQtdChoc(int qtdChoc) {
		this.qtdChoc = qtdChoc;
	}
}

