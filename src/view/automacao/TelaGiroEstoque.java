package view.automacao;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaGiroEstoque extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Color COR_FUNDO = new Color(245, 247, 250);
    private final Color COR_BOTAO = new Color(52, 152, 219);

    private final JTextField campoNome = new JTextField(20);
    private final JComboBox<String> comboTipo = new JComboBox<>(new String[]{"Todos", "Produto", "Variação", "Kit"});
    private final JComboBox<String> comboClassificacao = new JComboBox<>(new String[]{
        "Todas (Curva ABC)", "Classe A (Alto Giro)", "Classe B (Médio Giro)", "Classe C (Baixo Giro)"
    });

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
        new Object[][]{
            {"Caderno", "Produto", "Classe A", 450, 50, "9.0", "40.5 dias"},
            {"Caneta", "Variação", "Classe A", 1200, 100, "12.0", "30.4 dias"},
            {"Kit Escolar", "Kit", "Classe B", 80, 20, "4.0", "91.2 dias"}
        },
        new String[]{"Item", "Tipo", "Classificação", "Vendas no Período", "Estoque Médio", "Índice de Giro", "Tempo Médio (Dias)"}
    ) {
        private static final long serialVersionUID = 1L;
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable tabelaGiro = new JTable(modeloTabela);

    private final JButton btnCalcular = new JButton("Calcular Giro");
    private final JButton btnLimpar = new JButton("Limpar");

    public TelaGiroEstoque() {
        criarTela();
    }

    private void criarTela() {
        setLayout(new BorderLayout(15, 15));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(COR_FUNDO);

        JPanel filtros = new JPanel(new GridBagLayout());
        filtros.setBackground(Color.WHITE);
        filtros.setBorder(BorderFactory.createTitledBorder("Análise de Giro de Estoque"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        adicionarCampo(filtros, gbc, 0, 0, "Nome do Item:", campoNome);
        adicionarCampo(filtros, gbc, 0, 2, "Tipo:", comboTipo);
        adicionarCampo(filtros, gbc, 1, 0, "Classificação:", comboClassificacao);

        btnCalcular.setBackground(COR_BOTAO);
        btnCalcular.setForeground(Color.WHITE);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        painelBotoes.setBackground(Color.WHITE);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnCalcular);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        filtros.add(painelBotoes, gbc);

        tabelaGiro.setRowHeight(28);
        tabelaGiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setBorder(BorderFactory.createTitledBorder("Métricas de Giro Calculadas"));
        painelTabela.add(new JScrollPane(tabelaGiro), BorderLayout.CENTER);

        add(filtros, BorderLayout.NORTH);
        add(painelTabela, BorderLayout.CENTER);

        btnCalcular.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cálculo de giro atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE));
        btnLimpar.addActionListener(e -> limpar());
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints gbc, int linha, int coluna, String texto, JComponent componente) {
        gbc.gridx = coluna;
        gbc.gridy = linha;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        painel.add(new JLabel(texto), gbc);

        gbc.gridx = coluna + 1;
        gbc.weightx = 1;
        painel.add(componente, gbc);
    }

    public void limpar() {
        campoNome.setText("");
        if (comboTipo.getItemCount() > 0) {
            comboTipo.setSelectedIndex(0);
        }
        if (comboClassificacao.getItemCount() > 0) {
            comboClassificacao.setSelectedIndex(0);
        }
        tabelaGiro.clearSelection();
    }

  
    public JTextField getCampoNome() {
        return campoNome;
    }

    public JComboBox<String> getComboTipo() {
        return comboTipo;
    }

    public JComboBox<String> getComboClassificacao() {
        return comboClassificacao;
    }

    public JTable getTabelaGiro() {
        return tabelaGiro;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    public JButton getBtnLimpar() {
        return btnLimpar;
    }
}
