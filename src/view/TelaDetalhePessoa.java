package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;

/**
 * Criação do JFrame que irá cadastrar ou excluir uma pessoa ou um produto.
 * @author vitor e leticia
 * @version 1.0 (Out, 2020)
 */

public class TelaDetalhePessoa implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelDia = new JLabel("Dia: ");
	private JTextField valorDia;
	private JLabel labelMes = new JLabel("Mês: ");
	private JTextField valorMes;
	private JLabel labelAno = new JLabel("Ano: ");
	private JTextField valorAno;
	private JLabel labelTel = new JLabel("Telefone: ");
	private JTextField valorDDD;
	private JTextField valorTelefone;
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelEnd = new JLabel("Endereço: ");
	private JTextField valorEnd;
	private JLabel labelPosto = new JLabel("Posto");
	private JTextField valorPosto;
	private JLabel labelSalario = new JLabel("Salario");
	private JTextField valorSalario;
	private JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[15];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	/**
	 * Se a opção for de detalhar cliente ou funcionário, a janela de cadastro aparece com os dados já preenchidos. Se a opção for de cadastrar, a janela aparece com os valores em branco para serem preenchidos.
	 * @param op
	 * @param d
	 * @param p
	 * @param pos
	 */
	public void inserirEditar(int op, ControleDados d, 
			TelaPessoa p, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Cadastro de Funcionário";
		if (op == 3) s = "Detalhe de Cliente";
		if (op == 4) s = "Detalhe de Funcionário";

		janela = new JFrame(s);

		//Preenche dados com dados do cliente clicado
		if (op == 3) {
			valorNome = new JTextField(dados.getCliente()[pos].getNome(), 200);
			valorDia = new JTextField(String.valueOf(dados.getCliente()[pos].getDataNascimento().getDia()), 200);
			valorMes = new JTextField(String.valueOf(dados.getCliente()[pos].getDataNascimento().getMes()), 200);
			valorAno = new JTextField(String.valueOf(dados.getCliente()[pos].getDataNascimento().getAno()), 200);
			valorDDD = new JTextField(String.valueOf(dados.getCliente()[pos].getTelefone().getDDD()), 3);
			valorTelefone = new JTextField(String.valueOf(dados.getCliente()[pos].getTelefone().getNumero()), 10);	
			valorCPF = new JTextField(String.valueOf(dados.getCliente()[pos].getCPF()), 200);
			valorEnd = new JTextField(dados.getCliente()[pos].getEndereco(),200);

		} else if (op == 4) { //Preenche dados com dados do funcionario clicado 
			valorNome = new JTextField(dados.getFuncionarios()[pos].getNome(), 200);
			valorDia = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getDataNascimento().getDia()), 200);
			valorMes = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getDataNascimento().getMes()), 200);
			valorAno = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getDataNascimento().getAno()), 200);
			valorDDD = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getTelefone().getDDD()), 3);
			valorTelefone = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getTelefone().getNumero()), 10);	
			valorCPF = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getCPF()), 200);
			valorPosto = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getPosto()), 200);
			valorSalario = new JTextField(String.valueOf(dados.getFuncionarios()[pos].getSalario()), 200);

		} else { //Não preenche com dados

			valorNome = new JTextField(200);
			valorDia = new JTextField(200);
			valorMes = new JTextField(200);
			valorAno = new JTextField(200);
			valorDDD = new JTextField(200);
			valorTelefone = new JTextField(3);
			valorCPF = new JTextField(10);
			valorEnd = new JTextField(200);
			valorPosto = new JTextField(200);
			valorSalario = new JTextField(10);

			botaoSalvar.setBounds(120, 340, 115, 30);
		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelDataNascimento.setBounds(30, 60, 150, 25);
		labelDia.setBounds(30, 90, 150, 25);
		valorDia.setBounds(70, 90, 30, 25);
		labelMes.setBounds(110, 90, 180, 25);
		valorMes.setBounds(140, 90, 30, 25);		
		labelAno.setBounds(180, 90, 150, 25);
		valorAno.setBounds(210, 90, 50, 25);
		labelTel.setBounds(30, 160, 150, 25);
		valorDDD.setBounds(180, 160, 28, 25);
		valorTelefone.setBounds(210, 160, 65, 25);
		labelCPF.setBounds(30, 200, 150, 25);
		valorCPF.setBounds(180, 200, 180, 25);
		
		
		

		//Coloca os campos relacionados a cliente
		if (op == 1 || op == 3 ) {
			labelEnd.setBounds(30, 240, 150, 25);
			valorEnd.setBounds(180, 240, 180, 25);
			this.janela.add(labelEnd);
			this.janela.add(valorEnd);

		}

		//Coloca campos relacionados a funcionario
		if (op == 2 || op == 4) {

			labelPosto.setBounds(30, 240, 150, 25);
			valorPosto.setBounds(180, 240, 180, 25);
			labelSalario.setBounds(30, 280, 150, 25);
			valorSalario.setBounds(180, 280, 180, 25);
			this.janela.add(labelPosto);
			this.janela.add(valorPosto);
			this.janela.add(labelSalario);
			this.janela.add(valorSalario);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 350, 115, 30);
			botaoExcluir.setBounds(245, 350, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelDataNascimento);
		this.janela.add(labelDia);
		this.janela.add(valorDia);
		this.janela.add(labelMes);
		this.janela.add(valorMes);
		this.janela.add(labelAno);
		this.janela.add(valorAno);
		this.janela.add(labelTel);
		this.janela.add(valorDDD);
		this.janela.add(valorTelefone);
		this.janela.add(labelCPF);
		this.janela.add(valorCPF);
	
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 500);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1)
					novoDado[0] = Integer.toString(dados.getQtdClientes());
				else if (opcao == 2)
					novoDado[0] = Integer.toString(dados.getQtdFuncionario());
				else
					novoDado[0] = Integer.toString(posicao);
					novoDado[1] =  valorNome.getText();
					novoDado[2] = valorDia.getText();
					novoDado[3] = valorMes.getText();
					novoDado[4] = valorAno.getText();
					novoDado[5] =  valorDDD.getText();
					novoDado[6] =  valorTelefone.getText();
					novoDado[7] =  valorCPF.getText();

				if (opcao == 1 || opcao == 3) {
					novoDado[8] =  valorEnd.getText();
					res = dados.inserirEditarCliente(novoDado);
				} else {
					novoDado[8] =  valorPosto.getText();
					novoDado[9] =  valorSalario.getText();
					res = dados.inserirEditarFuncionario(novoDado);
				}

				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 3) {
				res = dados.removerCliente(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoCliente(); 
			}
				
			if (opcao == 4){
				res = dados.removerFuncionario(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoFunc(); 
			}


			
		}
	}

	/**
	 * JOptionPane que exibe mensagem de exclusão bem sucedida de dados.
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * JOptionPane que exibe mensagem de cadastro bem sucedido.
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * JOptionPane que exibe mensagem de erro no cadastro contendo possiveis problemas.
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. CPF, DDD, telefone, e data não contém apenas números \n"
				+ "3. O CPF é inválido", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * JOptionPane que exibe mensagem de erro na exclusão de um cliente.
	 */
	public void mensagemErroExclusaoCliente() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o Cliente está cadastrado\n"
				+ "e tente novamente.", null, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * JOptionPane que exibe mensagem de erro na exclusão de um funcionário.
	 */
	public void mensagemErroExclusaoFunc() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o Funcionário está correto\n"
				+ "e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
