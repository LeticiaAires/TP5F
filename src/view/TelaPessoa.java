package view;

/**
 * Implementação de um JFrame contendo um JList, implementação da função de pesquisa e as respectivas ações dos JButtons referentes ao cadastro, refresh e pesquisa, além da ação realizada ao clicar em um item do JList.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;


public class TelaPessoa implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton cadastroFunc;
	private JButton refreshFunc;
	private JButton pesquisaCliente;
	private JLabel cpf;
	private JButton pesquisaFunc;
	private JTextField valorCPF;
	private static ControleDados dados;
	private JList<String> listaClientesCadastrados;
	private JList<String> listaFuncionariosCadastrados;
	private String[] listaNomes = new String[50];
	
	/**
	 * Mostra os dados cadastrados em um JFrame através de um JList.
	 * @param d
	 * @param op
	 */
	public void mostrarDados(ControleDados d, int op){
		dados = d;

		switch (op) {
		case 1:// Mostrar dados de alunos cadastrados (JList)
			listaNomes = new ControleCliente(dados).getNomeCliente();
			listaClientesCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroCliente = new JButton("Cadastrar");
			refreshCliente = new JButton("Refresh");
			cpf = new JLabel("CPF:");
			pesquisaCliente = new JButton("Pesquisar");
			valorCPF = new JTextField();
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaClientesCadastrados.setBounds(20, 50, 350, 120);
			listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaClientesCadastrados.setVisibleRowCount(10);

			cadastroCliente.setBounds(70, 300, 100, 30);
			refreshCliente.setBounds(200, 300, 100, 30);
			
			cpf.setBounds(55,200, 100, 30);
			pesquisaCliente.setBounds(200,200, 100, 30);
			valorCPF.setBounds(85, 200, 100, 30);
			
			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaClientesCadastrados);
			janela.add(cadastroCliente);
			janela.add(refreshCliente);
			janela.add(cpf);
			janela.add(pesquisaCliente);
			janela.add(valorCPF);
			
			janela.setSize(400, 400);
			janela.setVisible(true);

			cadastroCliente.addActionListener(this);
			refreshCliente.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
			pesquisaCliente.addActionListener(this);

			break;

		case 2:// Mostrar dados de professores cadastrados (JList)
			listaNomes = new ControleFuncionario(dados).getNomeFuncionario();
			listaFuncionariosCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Funcionários");
			titulo = new JLabel("Funcionários Cadastrados");
			cadastroFunc = new JButton("Cadastrar");
			refreshFunc = new JButton("Refresh");
			cpf = new JLabel("CPF:");
			pesquisaFunc = new JButton("Pesquisar");
			valorCPF = new JTextField();

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFuncionariosCadastrados.setBounds(20, 50, 350, 120);
			listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaFuncionariosCadastrados.setVisibleRowCount(10);


			cadastroFunc.setBounds(70, 300, 100, 30);
			refreshFunc.setBounds(200, 300, 100, 30);
			cpf.setBounds(55,200, 100, 30);
			pesquisaFunc.setBounds(200,200, 100, 30);
			valorCPF.setBounds(85, 200, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaFuncionariosCadastrados);
			janela.add(cadastroFunc);
			janela.add(refreshFunc);
			janela.add(cpf);
			janela.add(pesquisaFunc);
			janela.add(valorCPF);

			janela.setSize(400, 400);
			janela.setVisible(true);

			cadastroFunc.addActionListener(this);
			refreshFunc.addActionListener(this);
			listaFuncionariosCadastrados.addListSelectionListener(this);
			pesquisaFunc.addActionListener(this);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}



	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo cliente
		if(src == cadastroCliente)
			new TelaDetalhePessoa().inserirEditar(1, dados, this, 0);

		//Cadastro de novo funcionario
		if(src == cadastroFunc)
			new TelaDetalhePessoa().inserirEditar(2, dados, this, 0);

		// Atualiza a lista de nomes de clientes mostrada no JList
		if(src == refreshCliente) {
			listaClientesCadastrados.setListData(new ControleCliente(dados).getNomeCliente());			
			listaClientesCadastrados.updateUI();
		}

		// Atualiza a lista de nomes de funcionarios mostrada no JList
		if(src == refreshFunc) {
			listaFuncionariosCadastrados.setListData(new ControleFuncionario(dados).getNomeFuncionario());
			listaFuncionariosCadastrados.updateUI();
		}
		
		if(src == pesquisaCliente) {
			for( int i = 0; i < dados.getQtdClientes(); i++) {
				if(dados.getCliente()[i].getCPF().equals(valorCPF.getText())) {
					new TelaDetalhePessoa().inserirEditar(3, dados, this, i);
				}
			}
		}
		
		if(src == pesquisaFunc) {
			for( int i = 0; i < dados.getQtdFuncionario(); i++) {
				if(dados.getFuncionarios()[i].getCPF().equals(valorCPF.getText())) {
					new TelaDetalhePessoa().inserirEditar(4, dados, this, i);
				}
			}
		}

	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			new TelaDetalhePessoa().inserirEditar(3, dados, this, 
					listaClientesCadastrados.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaFuncionariosCadastrados) {
			new TelaDetalhePessoa().inserirEditar(4, dados, this, 
					listaFuncionariosCadastrados.getSelectedIndex());
		}
	}

}
