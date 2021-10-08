package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe ChocolateSortido.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public class ChocolateSortido extends Produto{
	private Integer quantidade;
	
	public ChocolateSortido(String nome, Double valorCompra, Date dataValidade, String sabores, Double peso, Integer quantidade) {
		super(nome, valorCompra, dataValidade, sabores, peso);
		setQuantidade(quantidade);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
