package view;

/**
 * Implementação de um JFrame e as respectivas ações de cada JButton
 * @author Vitor e Leticia
 * @version 1.0 (Out, 2020)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Controle de Vendas");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton cliente = new JButton("Cliente");
	private static JButton trufa = new JButton("Trufa");
	private static JButton chocSort = new JButton("Chocolate Sortido");
	private static JButton func = new JButton("Funcionario");
	public static ControleDados dados = new ControleDados();
	
	
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);
		trufa.setBounds(140, 100, 150, 30);
		chocSort.setBounds(140, 200, 150, 30);
		func.setBounds(140, 150, 150, 30);
		cliente.setBounds(140, 50, 150, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(cliente);
		janela.add(trufa);
		janela.add(chocSort);
		janela.add(func);
		
		janela.setSize(400, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	/**
	 * método main que abre a Tela de Menu.
	 * @param args
	 */
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		cliente.addActionListener(menu);
		func.addActionListener(menu);
		trufa.addActionListener(menu);
		chocSort.addActionListener(menu);
	}
	
	/**
	 * Captura o evento de cada JButton.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cliente) {
			new TelaPessoa().mostrarDados(dados, 1);
		}
		
		if(src == func) {
			new TelaPessoa().mostrarDados(dados, 2);
		}
		
		if(src == trufa) {
			new TelaProduto().mostrarDados(dados, 1);
		}
		
		if(src == chocSort) {
			new TelaProduto().mostrarDados(dados, 2);
		}
			
	}
}

