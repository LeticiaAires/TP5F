package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe Cliente.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public class Cliente extends Pessoa {
	private String endereco;
	
	public Cliente(String nome, Date dataNascimento, Telefone telefone, String cpf, String endereco) {
		super(nome, dataNascimento, telefone, cpf);
		setEndereco(endereco);
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "Nome: " + getNome() + ", Data de Nascimento: " + getDataNascimento().toString() + ", Telefone: " + getTelefone().toString() + ", CPF: " + getCPF() + ", Endereço: " + getEndereco();
				
		
	}
	
}
