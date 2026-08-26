package view.inventario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaInventario extends JFrame {
	private static final long serialVersionUID = 10L;

	private JLabel lblNome;
	private JLabel lblDescricao;
	private JLabel lblQtdEstoque;

	private JTextField txtNome;
	private JTextField txtDescricao;
	private JComboBox<String> comboCompararQtdEstoque;
	private JTextField txtQtdEstoque;

	private JButton btnFiltrar;

	private JButton btnNovoItem;
	private JButton btnLimparFiltros;

	private JTable tabelaItens;
	private DefaultTableModel modeloTabela;

	public TelaInventario() {
		setTitle("Estoque - Inventário");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		criarComponentes();
	}

	private void criarComponentes() {
		JPanel painelSuperior = new JPanel();
		painelSuperior.setLayout(new BoxLayout(painelSuperior, BoxLayout.Y_AXIS));
		painelSuperior.add(criarPainelFiltros());
		painelSuperior.add(criarPainelAcoes());

		add(painelSuperior, BorderLayout.NORTH);
		add(criarPainelTabela(), BorderLayout.CENTER);
	}

	private JPanel criarPainelFiltros() {
		JPanel painelFiltros = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		painelFiltros.setBorder(BorderFactory.createTitledBorder("Filtros disponíveis"));

		lblNome = new JLabel("Nome");
		txtNome = new JTextField(15);

		lblDescricao = new JLabel("Descrição");
		txtDescricao = new JTextField(15);

		lblQtdEstoque = new JLabel("Qtd. Estoque");
		comboCompararQtdEstoque = new JComboBox<>(new String[] { "Maior que", "Menor que", "Igual a" });
		txtQtdEstoque = new JTextField(8);

		btnFiltrar = new JButton("Filtrar");

		painelFiltros.add(lblNome);
		painelFiltros.add(txtNome);
		painelFiltros.add(lblDescricao);
		painelFiltros.add(txtDescricao);
		painelFiltros.add(lblQtdEstoque);
		painelFiltros.add(comboCompararQtdEstoque);
		painelFiltros.add(txtQtdEstoque);
		painelFiltros.add(btnFiltrar);

		return painelFiltros;
	}

	private JPanel criarPainelAcoes() {
		JPanel painelAcoes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

		btnNovoItem = new JButton("Novo Item");
		btnLimparFiltros = new JButton("Limpar Filtros");

		painelAcoes.add(btnNovoItem);
		painelAcoes.add(btnLimparFiltros);

		return painelAcoes;
	}

	private JScrollPane criarPainelTabela() {
		modeloTabela = new DefaultTableModel(
				new Object[] { "Item", "Descrição", "Quantidade", "Custo unitário", "Custo total" }, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tabelaItens = new JTable(modeloTabela);

		JScrollPane scrollPane = new JScrollPane(tabelaItens);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Itens"));

		return scrollPane;
	}
}