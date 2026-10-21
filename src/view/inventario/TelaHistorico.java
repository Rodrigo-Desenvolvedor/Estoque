package view.inventario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaHistorico extends JPanel {
	private static final long serialVersionUID = 10L;

	private JLabel lblProduto;
	private JLabel lblTipo;
	private JLabel lblPeriodo;
	private JLabel lblResponsavel;
	private JLabel lblDocumento;

	private JTextField txtProduto;
	private JComboBox<String> comboTipo;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTextField txtResponsavel;
	private JTextField txtDocumento;

	private JButton btnFiltrar;
	private JButton btnLimparFiltros;
	private JButton btnExportar;

	private JTable tabelaMovimentacoes;
	private DefaultTableModel modeloTabela;

	public TelaHistorico() {
		setSize(1200, 800);
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
		JPanel painelFiltros = new JPanel();
		painelFiltros.setLayout(new BoxLayout(painelFiltros, BoxLayout.Y_AXIS));
		painelFiltros.setBorder(BorderFactory.createTitledBorder("Filtros disponíveis"));

		lblProduto = new JLabel("Produto");
		txtProduto = new JTextField(15);

		lblTipo = new JLabel("Tipo");
		comboTipo = new JComboBox<>(new String[] { "Todos", "Entrada", "Saída", "Transferência", "Ajuste" });

		lblPeriodo = new JLabel("Período");
		txtDataInicial = new JTextField(8);
		txtDataFinal = new JTextField(8);

		lblResponsavel = new JLabel("Responsável");
		txtResponsavel = new JTextField(12);

		lblDocumento = new JLabel("Documento");
		txtDocumento = new JTextField(10);

		JPanel linha1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		linha1.add(lblProduto);
		linha1.add(txtProduto);
		linha1.add(lblTipo);
		linha1.add(comboTipo);
		linha1.add(lblPeriodo);
		linha1.add(txtDataInicial);
		linha1.add(new JLabel("até"));
		linha1.add(txtDataFinal);

		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
		linha2.add(lblResponsavel);
		linha2.add(txtResponsavel);
		linha2.add(lblDocumento);
		linha2.add(txtDocumento);

		painelFiltros.add(linha1);
		painelFiltros.add(linha2);

		return painelFiltros;
	}

	private JPanel criarPainelAcoes() {
		JPanel painelAcoes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));

		btnFiltrar = new JButton("Filtrar");
		btnLimparFiltros = new JButton("Limpar Filtros");
		btnExportar = new JButton("Exportar");

		painelAcoes.add(btnFiltrar);
		painelAcoes.add(btnLimparFiltros);
		painelAcoes.add(btnExportar);

		return painelAcoes;
	}
	private JScrollPane criarPainelTabela() {
		modeloTabela = new DefaultTableModel(new Object[] { "Data/Hora", "Produto", "Tipo", "Quantidade", "Origem",
				"Destino", "Motivo", "Documento", "Responsável", "Observação" }, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tabelaMovimentacoes = new JTable(modeloTabela);

		JScrollPane scrollPane = new JScrollPane(tabelaMovimentacoes);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Histórico de Movimentações"));

		return scrollPane;
	}

	public JTextField getTxtProduto() {
		return txtProduto;
	}

	public JTextField getTxtDataInicial() {
		return txtDataInicial;
	}

	public JTextField getTxtDataFinal() {
		return txtDataFinal;
	}

	public JTextField getTxtResponsavel() {
		return txtResponsavel;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
}