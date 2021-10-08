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
 * @version 1.0 (Out, 2021)
 */

public class TelaDetalheProduto implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelValorCompra = new JLabel("Valor Compra: ");
	private JTextField valorValorCompra;
	private JLabel labelDataValidade = new JLabel("Data de Validade: ");
	private JLabel labelDia = new JLabel("Dia: ");
	private JTextField valorDia;
	private JLabel labelMes = new JLabel("Mês: ");
	private JTextField valorMes;
	private JLabel labelAno = new JLabel("Ano: ");
	private JTextField valorAno;
	private JLabel labelSabor = new JLabel("Sabor: ");
	private JTextField valorSabor;
	private JLabel labelPeso = new JLabel("Peso: ");
	private JTextField valorPeso;
	private JLabel labelRecheio = new JLabel("Recheio: ");
	private JTextField valorRecheio;
	private JLabel labelQnt = new JLabel("Quantidade: ");
	private JTextField valorQnt;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[40];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;

	/**
	 * Se a opção for de detalhar um produto, a janela de cadastro aparece com os dados já preenchidos. Se a opção for de cadastrar, a janela aparece com os valores em branco para serem preenchidos.
	 * @param op
	 * @param d
	 * @param p
	 * @param pos
	 */
	public void inserirEditar(int op, ControleDados d, 
			TelaProduto p, int pos) {

		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de Trufa";
		if (op == 2) s = "Cadastro de Chocolate Sortido";
		if (op == 3) s = "Detalhe de Trufa";
		if (op == 4) s = "Detalhe de Chocolate Sortido";

		janela = new JFrame(s);

		//Preenche dados com dados do cliente clicado
		if (op == 3) {
			valorNome = new JTextField(dados.getTrufa()[pos].getNome(), 200);
			valorValorCompra = new JTextField(String.valueOf(dados.getTrufa()[pos].getValorCompra()), 200);
			valorDia = new JTextField(String.valueOf(dados.getTrufa()[pos].getDataValidade().getDia()), 200);
			valorMes = new JTextField(String.valueOf(dados.getTrufa()[pos].getDataValidade().getMes()), 200);
			valorAno = new JTextField(String.valueOf(dados.getTrufa()[pos].getDataValidade().getAno()), 200);
			valorSabor = new JTextField(dados.getTrufa()[pos].getSabores(), 3);
			valorPeso = new JTextField(String.valueOf(dados.getTrufa()[pos].getPeso()), 10);	
			valorRecheio = new JTextField(dados.getTrufa()[pos].getRecheio(), 200);

		} else if (op == 4) { //Preenche dados com dados do Chocolate clicado 
			valorNome = new JTextField(dados.getChocolateSortido()[pos].getNome(), 200);
			valorValorCompra = new JTextField(String.valueOf(dados.getChocolateSortido()[pos].getValorCompra()), 200);
			valorDia = new JTextField(String.valueOf(dados.getChocolateSortido()[pos].getDataValidade().getDia()), 200);
			valorMes = new JTextField(String.valueOf(dados.getChocolateSortido()[pos].getDataValidade().getMes()), 200);
			valorAno = new JTextField(String.valueOf(dados.getChocolateSortido()[pos].getDataValidade().getAno()), 200);
			valorSabor = new JTextField(dados.getChocolateSortido()[pos].getSabores(), 3);
			valorPeso = new JTextField(String.valueOf(dados.getChocolateSortido()[pos].getPeso()), 10);	
			valorQnt = new JTextField(String.valueOf(dados.getChocolateSortido()[pos].getQuantidade()), 10);	

		} else { //Não preenche com dados

			valorNome = new JTextField(200);
			valorValorCompra = new JTextField(200);
			valorDia = new JTextField(200);
			valorMes = new JTextField(200);
			valorAno = new JTextField(200);
			valorSabor = new JTextField(3);
			valorPeso = new JTextField(10);	
			valorRecheio = new JTextField(200);
			valorQnt = new JTextField(10);

			botaoSalvar.setBounds(120, 340, 115, 30);
		}

		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelValorCompra.setBounds(30, 50, 150, 25);
		valorValorCompra.setBounds(180, 50, 30, 25);
		labelDataValidade.setBounds(30, 80, 180, 25);
		labelDia.setBounds(30, 110, 180, 25);
		valorDia.setBounds(60, 110, 30, 25);		
		labelMes.setBounds(100, 110, 150, 25);
		valorMes.setBounds(130, 110, 30, 25);
		labelAno.setBounds(170, 110, 150, 25);
		valorAno.setBounds(200, 110, 40, 25);
		labelSabor.setBounds(30, 160, 150, 25);
		valorSabor.setBounds(180, 160, 180, 25);
		labelPeso.setBounds(30, 200, 150, 25);
		valorPeso.setBounds(180, 200, 180, 25);
		
		//Coloca os campos relacionados a trufa
		if (op == 1 || op == 3 ) {
			labelRecheio.setBounds(30, 240, 150, 25);
			valorRecheio.setBounds(180, 240, 180, 25);
			this.janela.add(labelRecheio);
			this.janela.add(valorRecheio);

		}

		//Coloca campos relacionados ao chocolate Sortido
		if (op == 2 || op == 4) {
			labelQnt.setBounds(30, 240, 150, 25);
			valorQnt.setBounds(180, 240, 180, 25);
			this.janela.add(labelQnt);
			this.janela.add(valorQnt);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 400, 115, 30);
			botaoExcluir.setBounds(245, 400, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelValorCompra);
		this.janela.add(valorValorCompra);
		this.janela.add(labelDataValidade);
		this.janela.add(labelDia);
		this.janela.add(valorDia);
		this.janela.add(labelMes);
		this.janela.add(valorMes);
		this.janela.add(labelAno);
		this.janela.add(valorAno);
		this.janela.add(labelSabor);
		this.janela.add(valorSabor);
		this.janela.add(labelPeso);
		this.janela.add(valorPeso);
		
	
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 500);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	/**
	 * Verifica a src e se a src for igual a botaoSalvar o produto é salvo, e se a src for igual a botaoExcluir, o produto é excluido.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1)
					novoDado[0] = Integer.toString(dados.getQtdTrufas());
				else if (opcao == 2)
					novoDado[0] = Integer.toString(dados.getQtdChocolateSortido());
				else
					novoDado[0] = Integer.toString(posicao);
					novoDado[1] = valorNome.getText();
					novoDado[2] = valorValorCompra.getText();
					novoDado[3] = valorDia.getText();
					novoDado[4] = valorMes.getText();
					novoDado[5] = valorAno.getText();
					novoDado[6] = valorSabor.getText();
					novoDado[7] = valorPeso.getText();

				if (opcao == 1 || opcao == 3) {
					novoDado[8] =  valorRecheio.getText();
					res = dados.inserirEditarTrufa(novoDado);
				} else {
					novoDado[8] =  valorQnt.getText();
					res = dados.inserirEditarChocolateSortido(novoDado);
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
				res = dados.removerTrufa(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoTrufa(); 
			}
				
			if (opcao == 4){
				res = dados.removerChocolateSortido(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoChocSort(); 
			}


			
		}
	}

	/**
	 * Mensagem em JOptionPane de sucesso de exclusao.
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Mensagem em JOptionPane de sucesso de cadastro.
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * Mensagem em JOptionPane de erro de cadastro.
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2.  \n"
				+ "3. PESO, DATA DE VALIDADE, PREÇOS OU QUANTIDADE não contém apenas números", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Mensagem em JOptionPane de erro de exclusão de trufa.
	 */
	public void mensagemErroExclusaoTrufa() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se a Trufa está cadastrado\n"
				+ "em alguma venda.", null, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 *  Mensagem em JOptionPane de erro de exclusão de chocolate sortido.
	 */
	public void mensagemErroExclusaoChocSort() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o Chocolate Sortido está correto\n"
				+ "e tente novamente.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}