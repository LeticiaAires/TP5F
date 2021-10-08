package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe Loja.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public class Loja{
	private  Cliente[] clientes = new Cliente[50];
	private int qtdClientes = 0;
	private Trufa [] trufas = new Trufa[50];
	private int qtdTrufas = 0;
	private ChocolateSortido [] chocSort = new ChocolateSortido[50];
	private int qtdChocSort = 0;
	private Funcionario[] func = new Funcionario[50];
	private int qtdFunc = 0;
	private Telefone[] tels = new Telefone[50];
	private int qtdTels = 0;
	private Venda[] venda = new Venda[50];
	private int qtdVendas = 0;
	private String[] cpf = new String[50];
	
	/**
	 * Gera dados pré cadastrados.
	 */
	public void fillWithSomeData() {
		for(int i = 0; i < 5; i++) {
			cpf[0] = "07046446148";
			cpf[1] = "01150690704";
			cpf[2] = "04378099780";
			cpf[3] = "01045676195";
			cpf[4] = "05399569108";
			tels[i] = new Telefone((i+1)*100, (i+1)*1000000);
			clientes[i] = new Cliente("Cliente"+i, new Date(1+i,1+i,1999+i), tels[i], cpf[i], "Endereco"+i);
			func[i] = new Funcionario("Cliente"+i, new Date(2+i,2+i,1995+i), tels[i], cpf[i], "Posto"+i, (float) (i+1)*1000); 
			trufas[i] = new Trufa("Trufa"+i, (double)(i+1)*1, new Date(1+i, 1+i, 2021+i), "Sabores"+i, (double) 10+i, "Recheio"+i);
			chocSort[i] = new ChocolateSortido("Chocolate"+i, (double)(i+1)*1, new Date(1+i, 1+i, 2021+i), "Sabores"+i, (double) 10+i, 5+i);
		}
		
		qtdClientes = 5;
		qtdFunc = 5;
		qtdTrufas = 5;
		qtdChocSort = 5;
	}
	
	public Cliente[] getCliente() {
		return clientes;
	}
	
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	
	/**
	 * Insere cliente.
	 * @param c
	 * @param pos
	 */
	public void inserirEditarCliente(Cliente c, int pos) {
		this.clientes[pos] = c;
		if(pos == qtdClientes) qtdClientes++;
	}
	
	public int getQtdClientes() {
		return qtdClientes;
	}
	public void setQtdClientes(int qtdClientes) {
		this.qtdClientes = qtdClientes;
	}
	public Trufa[] getTrufa() {
		return trufas;
	}
	public void setTrufa(Trufa[] trufas) {
		this.trufas = trufas;
	}
	public int getQtdTrufas() {
		return qtdTrufas;
	}
	public void setQtdTrufas(int qtdTrufas) {
		this.qtdTrufas = qtdTrufas;
	}
	
	/**
	 * Insere trufa.
	 * @param t
	 * @param pos
	 */
	public void inserirEditarTrufa(Trufa t, int pos) {
		this.trufas[pos] = t;
		if(pos == qtdTrufas) qtdTrufas++;
	}
	
	public ChocolateSortido[] getChocolateSortido() {
		return chocSort;
	}
	public void setChocolateSortido(ChocolateSortido[] chocSort) {
		this.chocSort = chocSort;
	}
	public int getQtdChocolateSortido() {
		return qtdChocSort;
	}
	public void setQtdChocolateSortido(int qtdChocSort) {
		this.qtdChocSort = qtdChocSort;
	}
	
	/**
	 * Insere chocolate sortido.
	 * @param cs
	 * @param pos
	 */
	public void inserirEditarChocolateSortido(ChocolateSortido cs, int pos) {
		this.chocSort[pos] = cs;
		if(pos == qtdChocSort) qtdChocSort++;
	}
	
	public Funcionario[] getFuncionario() {
		return func;
	}
	
	public void setFuncionario(Funcionario[] func) {
		this.func = func;
	}
	
	/**
	 * Insere funcionario.
	 * @param f
	 * @param pos
	 */
	public void inserirEditaFuncionario(Funcionario f, int pos) {
		this.func[pos] = f;
		if(pos == qtdFunc) qtdFunc++;
	}
	
	
	public int getQtdFuncionario() {
		return qtdFunc;
	}
	public void setQtdFuncionario(int qtdFunc) {
		this.qtdFunc = qtdFunc;
	}
	public Telefone[] getTels() {
		return tels;
	}
	public void setTels(Telefone[] tels) {
		this.tels = tels;
	}
	public int getQtdTels() {
		return qtdTels;
	}
	public void setQtdTels(int qtdTels) {
		this.qtdTels = qtdTels;
	}
	public Venda[] getVenda() {
		return venda;
	}
	public void setVenda(Venda[] venda) {
		this.venda = venda;
	}
	public int getQtdVendas() {
		return qtdVendas;
	}
	public void setQtdVendas(int qtdVendas) {
		this.qtdVendas = qtdVendas;
	}
	

}
