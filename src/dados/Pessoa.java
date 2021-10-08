package dados;

/**
 * Atribuição dos métodos gets e sets aos atributos da classe abstrata Pessoa.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

public abstract class Pessoa {
	private String nome;
	private Date dataNascimento;
	private Telefone telefone;
	private String cpf;
	
	public Pessoa(String nome, Date dataNascimento, Telefone telefone, String cpf) {
		setNome(nome);
		setDataNascimento(dataNascimento);
		setTelefone(telefone);
		setCPF(cpf);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
}
