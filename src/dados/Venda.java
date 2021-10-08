package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe Venda.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public class Venda {
	private Cliente cliente;
	private Funcionario funcionario;
	private Trufa trufa;
	private ChocolateSortido chocSort;
	private Integer quantidadeVendidos;
	private Float valorTotal;
	private String formaPagamento;
	
	public Venda(Cliente cliente, Funcionario funcionario, Trufa trufa, ChocolateSortido chocSort, Integer quantidadeVendidos, Float valorTotal, String formaPagamento) {
		setCliente(cliente);
		setFuncionario(funcionario);
		setTrufa(trufa);
		setChocolateSortido(chocSort);
		setQuantidadeVendidos(quantidadeVendidos);
		setValorTotal(valorTotal);
		setFormaPagamento(formaPagamento);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Produto getTrufa() {
		return trufa;
	}
	
	public void setTrufa(Trufa trufa) {
		this.trufa = trufa;
	}
	
	public Produto getChocolateSortido() {
		return chocSort;
	}
	
	public void setChocolateSortido(ChocolateSortido chocSort) {
		this.chocSort = chocSort;
	}
	
	public Integer getQuantidadeVendidos() {
		return quantidadeVendidos;
	}
	
	public void setQuantidadeVendidos(Integer quantidadeVendidos) {
		this.quantidadeVendidos = quantidadeVendidos;
	}
	
	public Float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}
