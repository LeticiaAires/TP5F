package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe Trufa.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public class Trufa extends Produto{
	private String recheio;
	
	public Trufa(String nome, Double valorCompra, Date dataValidade, String sabores, Double peso, String recheio) {
		super(nome, valorCompra, dataValidade, sabores, peso);
		setRecheio(recheio);
	}
	
	public String getRecheio() {
		return recheio;
	}
	
	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}
	
}
