package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe abstrata Produto.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public abstract class Produto {
	private String nome;
	private Double valorCompra;
	private Date dataValidade;
	private String sabores;
	private Double peso;
	
	public Produto(String nome, Double valorCompra, Date dataValidade, String sabores, Double peso) {
		setNome(nome);
		setValorCompra(valorCompra);
		setDataValidade(dataValidade);
		setSabores(sabores);
		setPeso(peso);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public Date getDataValidade() {
		return dataValidade;
	}
	
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public String getSabores() {
		return sabores;
	}
	
	public void setSabores(String sabores) {
		this.sabores = sabores;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}
