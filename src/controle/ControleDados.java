package controle;

/**
 * Atribuição dos métodos gets e sets para obter dados especificos e métodos de inserção, edição e remoção de uma pessoa ou produto.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import dados.ChocolateSortido;
import dados.Cliente;
import dados.Date;
import dados.Funcionario;
import dados.Loja;
import dados.Telefone;
import dados.Trufa;
import dados.Venda;
import validacao.Validacao;

public class ControleDados {
	private Loja l = new Loja();
	private Validacao v = new Validacao();
	
	/**
	 * Pega os dados pré cadastrados da classe Loja.
	 */
	public ControleDados() {
		l.fillWithSomeData();
	}
	
	public Loja getLoja() {
		return l;
	}
	public void setLoja(Loja l) {
		this.l = l;
	}

	public Cliente[] getCliente() {
		return this.l.getCliente();
	}
	
	public int getQtdClientes() {
		return this.l.getQtdClientes();
	}
	
	public int getQtdFuncionario() {
		return this.l.getQtdFuncionario();
	}
	
	public Funcionario[] getFuncionarios() {
		return this.l.getFuncionario();
	}
	
	public int getQtdTrufas() {
		return this.l.getQtdTrufas();
	}
	
	public Trufa[] getTrufa() {
		return this.l.getTrufa();
	}
	
	public int getQtdVendas() {
		return this.l.getQtdVendas();
	}
	
	public Venda[] getVenda() {
		return this.l.getVenda();
	}
	
	public int getQtdChocolateSortido() {
		return this.l.getQtdChocolateSortido();
	}
	
	public ChocolateSortido[] getChocolateSortido() {
		return this.l.getChocolateSortido();
	}

	/**
	 * Inserção dos dados de um funcionário através da instanciação da classe Funcionario.
	 * @param dadosFunc
	 * @return boolean
	 */
	public boolean inserirEditarFuncionario(String[] dadosFunc) {
		if(dadosFunc[1].isEmpty() || !v.validaDia(Integer.parseInt(dadosFunc[2]), Integer.parseInt(dadosFunc[3])) || !v.validaMes(Integer.parseInt(dadosFunc[3])) || 
				!dadosFunc[4].matches("[0-9]+") || !dadosFunc[5].matches("[0-9]+") || !dadosFunc[6].matches("[0-9]+") || !v.validaCPF(dadosFunc[7])) {
			return false;
		} else {
			Funcionario f = new Funcionario(dadosFunc[1], new Date(Integer.parseInt(dadosFunc[2]), Integer.parseInt(dadosFunc[3]), Integer.parseInt(dadosFunc[4])), 
					new Telefone(Integer.parseInt(dadosFunc[5]), Integer.parseInt(dadosFunc[6])), 
						 dadosFunc[7], dadosFunc[8], Float.parseFloat(dadosFunc[9]));
				l.inserirEditaFuncionario(f, Integer.parseInt(dadosFunc[0]));
				return true;
		}
	}

	/**
	 * Inserção dos dados de um cliente através da instanciação da classe Cliente.
	 * @param dadosCliente
	 * @return boolean
	 */
	public boolean inserirEditarCliente(String[] dadosCliente) {
		if(dadosCliente[1].isEmpty() || !v.validaDia(Integer.parseInt(dadosCliente[2]), Integer.parseInt(dadosCliente[3])) || !v.validaMes(Integer.parseInt(dadosCliente[3])) || 
				!dadosCliente[4].matches("[0-9]+") || !dadosCliente[5].matches("[0-9]+") || !dadosCliente[6].matches("[0-9]+") || !v.validaCPF(dadosCliente[7])) {
			return false;
		} else {
				Cliente c = new Cliente(dadosCliente[1], new Date(Integer.parseInt(dadosCliente[2]), Integer.parseInt(dadosCliente[3]), Integer.parseInt(dadosCliente[4])), 
						new Telefone(Integer.parseInt(dadosCliente[5]), Integer.parseInt(dadosCliente[6])), 
						 dadosCliente[7], dadosCliente[8]);
				l.inserirEditarCliente(c, Integer.parseInt(dadosCliente[0]));
				return true;
		}
	}
	
	/**
	 * Inserção dos dados de uma trufa através da instanciação da classe Trufa.
	 * @param dadosTrufa
	 * @return boolean
	 */
	public boolean inserirEditarTrufa(String[] dadosTrufa) {
		if(dadosTrufa[1].isEmpty() || !v.validaDouble(Double.parseDouble(dadosTrufa[2])) || !v.validaDia(Integer.parseInt(dadosTrufa[3]), Integer.parseInt(dadosTrufa[4])) || !v.validaMes(Integer.parseInt(dadosTrufa[4])) || 
				!dadosTrufa[5].matches("[0-9]+") || dadosTrufa[6].isEmpty() || !v.validaDouble(Double.parseDouble(dadosTrufa[7])) || dadosTrufa[8].isEmpty()) {
			return false;
		} else {
			Trufa t = new Trufa(dadosTrufa[1], Double.parseDouble(dadosTrufa[2]), 
					new Date(Integer.parseInt(dadosTrufa[3]), Integer.parseInt(dadosTrufa[4]), Integer.parseInt(dadosTrufa[5])), 
					dadosTrufa[6], Double.parseDouble(dadosTrufa[7]), dadosTrufa[8]);
				l.inserirEditarTrufa(t, Integer.parseInt(dadosTrufa[0]));
				return true;
		}
	}
	
	/**
	 * Inserção dos dados de um chocolate sortido através da instanciação da classe ChocolateSortido.
	 * @param dadosChocSort
	 * @return boolean
	 */
	public boolean inserirEditarChocolateSortido(String[] dadosChocSort) {
		if(dadosChocSort[1].isEmpty() || !v.validaDouble(Double.parseDouble(dadosChocSort[2])) || !v.validaDia(Integer.parseInt(dadosChocSort[3]), Integer.parseInt(dadosChocSort[4])) || !v.validaMes(Integer.parseInt(dadosChocSort[4])) || 
				!dadosChocSort[5].matches("[0-9]+") || dadosChocSort[6].isEmpty() || !v.validaDouble(Double.parseDouble(dadosChocSort[7])) ||  !dadosChocSort[8].matches("[0-9]+")) {
			return false;
		} else {
			ChocolateSortido cs = new ChocolateSortido(dadosChocSort[1], Double.parseDouble(dadosChocSort[2]), 
					new Date(Integer.parseInt(dadosChocSort[3]), Integer.parseInt(dadosChocSort[4]), Integer.parseInt(dadosChocSort[5])), 
					dadosChocSort[6], Double.parseDouble(dadosChocSort[7]), Integer.parseInt(dadosChocSort[8]));
				l.inserirEditarChocolateSortido(cs, Integer.parseInt(dadosChocSort[0]));
				return true;
		}
	}
	
	
	/**
	 * Método para remoção de um cliente.
	 * @param i
	 * @return boolean
	 */
	public boolean removerCliente(int i) {
		int qtdVendas = l.getQtdVendas();
		String clienteRemovido = l.getCliente()[i].getNome();
		String aux;
		for (int j = 0; j < qtdVendas; j++) { 
			aux = l.getVenda()[j].getCliente().getNome();
			if(clienteRemovido.compareTo(aux) == 0) 
				return false;
		}
		
		if(i == (l.getQtdClientes() - 1)) { 
			l.setQtdClientes(l.getQtdClientes() - 1);
			l.getCliente()[l.getQtdClientes()] = null;
			return true;
		} else {
			int cont = 0;
			while(l.getCliente()[cont].getNome().compareTo(clienteRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < l.getQtdClientes() - 1; j++) {
				l.getCliente()[j] = null;
				l.getCliente()[j] = l.getCliente()[j+1];
			}
			l.getCliente()[l.getQtdClientes()] = null;
			l.setQtdClientes(l.getQtdClientes() - 1);
			return true;
		}
	}
	
	/**
	 * Método para remoção de um funcionário.
	 * @param i
	 * @return boolean
	 */
	public boolean removerFuncionario(int i) {
		int qtdVendas = l.getQtdVendas();
		String funcRemovido = l.getFuncionario()[i].getNome();
		String aux;
		for (int j = 0; j < qtdVendas; j++) {
			aux = l.getVenda()[j].getFuncionario().getNome();
			if(funcRemovido.compareTo(aux) == 0) 
				return false;
		}
		if(i == (l.getQtdFuncionario() - 1)) { // O funcionario a ser removido está no final do array
			l.setQtdFuncionario(l.getQtdFuncionario() - 1);
			l.getFuncionario()[l.getQtdFuncionario()] = null;
			return true;
		} else { // o funcionario a ser removido está no meio do array
			int cont = 0;
			while(l.getFuncionario()[cont].getNome().compareTo(funcRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < l.getQtdFuncionario() - 1; j++) {
				l.getFuncionario()[j] = null;
				l.getFuncionario()[j] = l.getFuncionario()[j+1];
			}
			l.getFuncionario()[l.getQtdFuncionario()] = null;
			l.setQtdFuncionario(l.getQtdFuncionario() - 1);
			return true;
		}
	}
	
	/**
	 * Método para remoção de uma trufa.
	 * @param i
	 * @return boolean
	 */
	public boolean removerTrufa(int i) {
		int qtdVendas = l.getQtdVendas();
		String trufaRemovida = l.getTrufa()[i].getNome();
		String aux;
		for (int j = 0; j < qtdVendas; j++) { 
			aux = l.getVenda()[j].getTrufa().getNome();
			if(trufaRemovida.compareTo(aux) == 0) 
				return false;
		}
		
		if(i == (l.getQtdTrufas() - 1)) { 
			l.setQtdTrufas(l.getQtdTrufas() - 1);
			l.getTrufa()[l.getQtdTrufas()] = null;
			return true;
		} else {
			int cont = 0;
			while(l.getTrufa()[cont].getNome().compareTo(trufaRemovida) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < l.getQtdTrufas() - 1; j++) {
				l.getTrufa()[j] = null;
				l.getTrufa()[j] = l.getTrufa()[j+1];
			}
			l.getTrufa()[l.getQtdTrufas()] = null;
			l.setQtdTrufas(l.getQtdTrufas() - 1);
			return true;
		}
	}
	
	
	/**
	 * Método para remoção de um chocolate sortido.
	 * @param i
	 * @return boolean
	 */
	public boolean removerChocolateSortido(int i) {
		int qtdVendas = l.getQtdVendas();
		String chocRemovido = l.getChocolateSortido()[i].getNome();
		String aux;
		for (int j = 0; j < qtdVendas; j++) { 
			aux = l.getVenda()[j].getChocolateSortido().getNome();
			if(chocRemovido.compareTo(aux) == 0) 
				return false;
		}
		
		if(i == (l.getQtdChocolateSortido() - 1)) { 
			l.setQtdChocolateSortido(l.getQtdChocolateSortido() - 1);
			l.getChocolateSortido()[l.getQtdChocolateSortido()] = null;
			return true;
		} else {
			int cont = 0;
			while(l.getChocolateSortido()[cont].getNome().compareTo(chocRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < l.getQtdChocolateSortido() - 1; j++) {
				l.getChocolateSortido()[j] = null;
				l.getChocolateSortido()[j] = l.getChocolateSortido()[j+1];
			}
			l.getChocolateSortido()[l.getQtdChocolateSortido()] = null;
			l.setQtdChocolateSortido(l.getQtdChocolateSortido() - 1);
			return true;
		}
	}
}
