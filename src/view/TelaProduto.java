package view;

/**
 * Implementação de um JFrame contendo um JList e as respectivas ações dos JButtons referentes ao cadastro e refresh, além da ação realizada ao clicar em um item do JList.
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;


public class TelaProduto implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroTrufa;
	private JButton refreshTrufa;
	private JButton cadastroChoc;
	private JButton refreshChoc;
	private static ControleDados dados;
	private JList<String> listaTrufaCadastrada;
	private JList<String> listaChocCadastrada;
	private String[] listaNomes = new String[50];

	/**
	 * Mostra os dados cadastrados em um JFrame através de um JList.
	 * @param d
	 * @param op
	 */
	public void mostrarDados(ControleDados d, int op){
		dados = d;

		switch (op) {
		case 1:// Mostrar dados de trufas cadastradas (JList)
			listaNomes = new ControleTrufa(dados).getNomeTrufa();
			listaTrufaCadastrada = new JList<String>(listaNomes);
			janela = new JFrame("Trufas");
			titulo = new JLabel("Trufas Cadastradas");
			cadastroTrufa = new JButton("Cadastrar");
			refreshTrufa = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaTrufaCadastrada.setBounds(20, 50, 350, 120);
			listaTrufaCadastrada.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaTrufaCadastrada.setVisibleRowCount(10);

			cadastroTrufa.setBounds(70, 177, 100, 30);
			refreshTrufa.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaTrufaCadastrada);
			janela.add(cadastroTrufa);
			janela.add(refreshTrufa);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroTrufa.addActionListener(this);
			refreshTrufa.addActionListener(this);
			listaTrufaCadastrada.addListSelectionListener(this);

			break;

		case 2:// Mostrar dados de professores cadastrados (JList)
			listaNomes = new ControleChocolateSortido(dados).getNomeChoc();
			listaChocCadastrada = new JList<String>(listaNomes);
			janela = new JFrame("Chocolate Sortido");
			titulo = new JLabel("Chocolates Sortidos Cadastrados");
			cadastroChoc = new JButton("Cadastrar");
			refreshChoc = new JButton("Refresh");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaChocCadastrada.setBounds(20, 50, 350, 120);
			listaChocCadastrada.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaChocCadastrada.setVisibleRowCount(10);


			cadastroChoc.setBounds(70, 177, 100, 30);
			refreshChoc.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaChocCadastrada);
			janela.add(cadastroChoc);
			janela.add(refreshChoc);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroChoc.addActionListener(this);
			refreshChoc.addActionListener(this);
			listaChocCadastrada.addListSelectionListener(this);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}

	}



	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de nova trufa
		if(src == cadastroTrufa)
			new TelaDetalheProduto().inserirEditar(1, dados, this, 0);

		//Cadastro de novo professor
		if(src == cadastroChoc)
			new TelaDetalheProduto().inserirEditar(2, dados, this, 0);

		// Atualiza a lista de nomes de clientes mostrada no JList
		if(src == refreshTrufa) {
			listaTrufaCadastrada.setListData(new ControleTrufa(dados).getNomeTrufa());			
			listaTrufaCadastrada.updateUI();
		}

		// Atualiza a lista de nomes de funcionarios mostrada no JList
		if(src == refreshChoc) {
			listaChocCadastrada.setListData(new ControleChocolateSortido(dados).getNomeChoc());
			listaChocCadastrada.updateUI();
		}

	}

	/**
	 * Captura eventos relacionados ao JList
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaTrufaCadastrada) {
			new TelaDetalheProduto().inserirEditar(3, dados, this, 
					listaTrufaCadastrada.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaChocCadastrada) {
			new TelaDetalheProduto().inserirEditar(4, dados, this, 
					listaChocCadastrada.getSelectedIndex());
		}
	}

}

