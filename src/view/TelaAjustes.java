package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class TelaAjustes extends JFrame {
	private static final long serialVersionUID = 10L;

	private JComboBox<String> comboOutrasAcoes;
	private JButton btnCancelar;
	private JButton btnSalvar;

	private JTextField txtItem;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtCustoUnitario;
	private JTextField txtCustoTotal;
	private JTextField txtLote;
	private JComboBox<String> comboStatus;
	private JTextField txtDataValidade;

	public TelaAjustes() {
		setTitle("Estoque - Ajustes");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		criarComponentes();
	}

	private void criarComponentes() {
	    add(criarPainelSuperior(), BorderLayout.NORTH);

	    JPanel painelConteudo = new JPanel(new BorderLayout());
	    painelConteudo.add(criarPainelFormulario(), BorderLayout.NORTH);
	    add(painelConteudo, BorderLayout.CENTER);
	}

	private JPanel criarPainelSuperior() {
		JPanel painelSuperior = new JPanel(new BorderLayout());
		painelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel painelBotoesSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		comboOutrasAcoes = new JComboBox<>(new String[] { "Outras Ações" });
		btnCancelar = new JButton("Cancelar");
		btnSalvar = new JButton("Salvar");
		painelBotoesSuperior.add(comboOutrasAcoes);
		painelBotoesSuperior.add(btnCancelar);
		painelBotoesSuperior.add(btnSalvar);

		painelSuperior.add(painelBotoesSuperior, BorderLayout.WEST);

		return painelSuperior;
	}

	private JPanel criarPainelFormulario() {
		JPanel painelFormulario = new JPanel(new GridLayout(0, 4, 16, 8));
		painelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		txtItem = new JTextField();
		txtDescricao = new JTextField();
		txtQuantidade = new JTextField();
		txtCustoUnitario = new JTextField();
		txtCustoTotal = new JTextField();

		txtLote = new JTextField();
		comboStatus = new JComboBox<>(new String[] { "1 - Não Processado", "2 - Processado" });
		txtDataValidade = new JTextField();

		painelFormulario.add(criarCampo("Item", txtItem));
		painelFormulario.add(criarCampo("Descrição", txtDescricao));
		painelFormulario.add(criarCampo("Quantidade", txtQuantidade));
		painelFormulario.add(criarCampo("Custo unitário", txtCustoUnitario));
		painelFormulario.add(criarCampo("Custo total", txtCustoTotal));
		painelFormulario.add(criarCampo("Lote", txtLote));
		painelFormulario.add(criarCampo("Status", comboStatus));
		painelFormulario.add(criarCampo("Data de Validade", txtDataValidade));

		return painelFormulario;
	}

	private JPanel criarCampo(String rotulo, JTextField campo) {
		JPanel painelCampo = new JPanel(new BorderLayout(0, 4));
		painelCampo.add(new JLabel(rotulo), BorderLayout.NORTH);
		painelCampo.add(campo, BorderLayout.CENTER);
		return painelCampo;
	}

	private JPanel criarCampo(String rotulo, JComboBox<String> campo) {
		JPanel painelCampo = new JPanel(new BorderLayout(0, 4));
		painelCampo.add(new JLabel(rotulo), BorderLayout.NORTH);
		painelCampo.add(campo, BorderLayout.CENTER);
		return painelCampo;
	}
}