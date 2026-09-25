package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import view.automacao.*;
import view.cadastro.*;
import view.inventario.*;
import view.movimentacao.*;
import view.mrp.*;

public class TelaEstoque extends JFrame {

	private static final long serialVersionUID = 1L;

	private final JTabbedPane abasEstoque = new JTabbedPane();

	public TelaEstoque() {

		// Título da janela
		super("Sistema de Gestão de Estoque");

		montar();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setMinimumSize(new Dimension(700, 500));
		setSize(1200, 800);

		setLocationRelativeTo(null);

		// Evento ao clicar no X da janela
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				sair();
			}
		});
	}

	/**
	 * Monta a interface principal.
	 */
	private void montar() {

		// Menu superior
		setJMenuBar(criarMenu());

		// Tela inicial
		JPanel inicio = new JPanel(new GridBagLayout());

		JLabel texto = new JLabel("Selecione uma função acima");
		texto.setFont(texto.getFont().deriveFont(Font.BOLD, 18f));

		inicio.add(texto);

		abasEstoque.addTab("Início", inicio);

		add(abasEstoque, BorderLayout.CENTER);

		// Rodapé
		JPanel rodape = new JPanel(new BorderLayout());

		rodape.setBorder(
			BorderFactory.createEmptyBorder(4, 8, 4, 8)
		);

		rodape.add(
			new JLabel("Sistema Estoque - Java Desktop"),
			BorderLayout.EAST
		);

		add(rodape, BorderLayout.SOUTH);
	}

	/**
	 * Cria o menu principal.
	 */
	private JMenuBar criarMenu() {

		JMenuBar barra = new JMenuBar();

		JMenu cadastro = new JMenu("Cadastro");
		JMenu movimentacao = new JMenu("Movimentação");
		JMenu inventario = new JMenu("Inventário");
		JMenu automacao = new JMenu("Automação");
		JMenu relatorio = new JMenu("Relatório");
		JMenu sistema = new JMenu("Sistema");

		// Itens do menu
		JMenuItem telaAlertaReposicao =
			Item("Alerta de Reposição", 1);

		JMenuItem telaEstoqueMinMax =
			Item("Estoque Min/Max", 2);

		JMenuItem telaGiroEstoque =
			Item("Giro Estoque", 3);

		JMenuItem telaKits =
			Item("Kits", 4);

		JMenuItem telaProdutos =
			Item("Produtos", 5);

		JMenuItem telaVariacoes =
			Item("Variações", 6);

		JMenuItem telaAjustes =
			Item("Ajustes", 7);

		JMenuItem telaInventario =
			Item("Inventário", 8);

		JMenuItem telaEntradaSaida =
			Item("Entrada e Saída", 9);

		JMenuItem telaLoteSerie =
			Item("Lote e Série", 10);

		JMenuItem telaMultilocalizacao =
			Item("Multilocalização", 11);

		JMenuItem telaMRP =
			Item("MRP", 12);

		// Menu Sistema
		JMenuItem sobre = new JMenuItem("Sobre");
		JMenuItem sair = new JMenuItem("Sair");

		// Ação do botão Sobre
		sobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(
					TelaEstoque.this,
					"Sistema de Gestão de Estoque\n"
					+ "Java Desktop\n\n"
					+ "Versão 1.0",
					"Sobre",
					JOptionPane.INFORMATION_MESSAGE
				);
			}
		});

		// Ação do botão Sair
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});

		// Adiciona Sobre e Sair ao menu Sistema
		sistema.add(sobre);
		sistema.addSeparator();
		sistema.add(sair);

		// Adiciona os menus à barra
		barra.add(cadastro);
		barra.add(movimentacao);
		barra.add(inventario);
		barra.add(automacao);
		barra.add(relatorio);
		barra.add(sistema);

		// Cadastro
		cadastro.add(telaKits);
		cadastro.add(telaProdutos);
		cadastro.add(telaVariacoes);

		// Inventário
		inventario.add(telaAjustes);
		inventario.add(telaInventario);

		// Movimentação
		movimentacao.add(telaEntradaSaida);
		movimentacao.add(telaLoteSerie);
		movimentacao.add(telaMultilocalizacao);

		// Relatório
		relatorio.add(telaMRP);

		// Automação
		automacao.add(telaAlertaReposicao);
		automacao.add(telaEstoqueMinMax);
		automacao.add(telaGiroEstoque);

		return barra;
	}

	/**
	 * Cria um item de menu e associa o módulo correspondente.
	 */
	private JMenuItem Item(String titulo, final int modulo) {

		JMenuItem item = new JMenuItem(titulo);

		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirModulo(modulo);
			}
		});

		return item;
	}

	/**
	 * Abre o módulo selecionado.
	 */
	private void abrirModulo(int modulo) {

		String titulo;
		JPanel painel;

		if (modulo == 1) {

			titulo = "Alerta de Reposição";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaAlertaReposicao();

		} else if (modulo == 2) {

			titulo = "Estoque Min/Max";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaEstoqueMinMax();

		} else if (modulo == 3) {

			titulo = "Giro Estoque";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaGiroEstoque();

		} else if (modulo == 4) {

			titulo = "Kits";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaKits();

		} else if (modulo == 5) {

			titulo = "Produtos";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaProdutos();

		} else if (modulo == 6) {

			titulo = "Variações";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaVariacoes();

		} else if (modulo == 7) {

			titulo = "Ajustes";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaAjustes();

		} else if (modulo == 8) {

			titulo = "Inventário";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaInventario();

		} else if (modulo == 9) {

			titulo = "Entrada e Saída";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaEntradaSaida();

		} else if (modulo == 10) {

			titulo = "Lote e Série";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaLoteSerie();

		} else if (modulo == 11) {

			titulo = "Multilocalização";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaMultilocalizacao();

		} else if (modulo == 12) {

			titulo = "MRP";

			if (selecionar(titulo)) {
				return;
			}

			painel = new TelaMRP();

		} else {

			JOptionPane.showMessageDialog(
				this,
				"Módulo inválido.",
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);

			return;
		}

		abrirAba(titulo, painel);
	}

	/**
	 * Abre uma nova aba.
	 */
	public void abrirAba(String titulo, JPanel painel) {

		int i = abasEstoque.indexOfTab(titulo);

		// Se a aba já existe, apenas seleciona
		if (i >= 0) {
			abasEstoque.setSelectedIndex(i);
			return;
		}

		// Adiciona a aba
		abasEstoque.addTab(titulo, painel);

		// Cria o cabeçalho com botão X
		abasEstoque.setTabComponentAt(
			abasEstoque.indexOfComponent(painel),
			cabecalhoFechavel(titulo, painel)
		);

		// Seleciona a nova aba
		abasEstoque.setSelectedComponent(painel);
	}

	/**
	 * Verifica se uma aba já está aberta.
	 */
	private boolean selecionar(String titulo) {

		int i = abasEstoque.indexOfTab(titulo);

		if (i >= 0) {
			abasEstoque.setSelectedIndex(i);
			return true;
		}

		return false;
	}

	/**
	 * Cria o cabeçalho da aba com botão para fechar.
	 */
	private JPanel cabecalhoFechavel(
		String titulo,
		final Component painel
	) {

		JPanel p = new JPanel(
			new FlowLayout(
				FlowLayout.LEFT,
				3,
				0
			)
		);

		p.setOpaque(false);

		JLabel label = new JLabel(titulo);
		p.add(label);

		JButton fechar = new JButton("x");

		fechar.setMargin(
			new Insets(0, 4, 0, 4)
		);

		fechar.setToolTipText("Fechar aba");

		fechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				abasEstoque.remove(painel);
			}
		});

		p.add(fechar);

		return p;
	}

	/**
	 * Confirma e encerra o sistema.
	 */
	private void sair() {

		int resposta = JOptionPane.showConfirmDialog(
			this,
			"Deseja encerrar o sistema?",
			"Sair",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);

		if (resposta == JOptionPane.YES_OPTION) {

			dispose();

			System.exit(0);
		}
	}

	/**
	 * Ponto de entrada do programa.
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				TelaEstoque tela = new TelaEstoque();

				tela.setVisible(true);
			}
		});
	}
}
