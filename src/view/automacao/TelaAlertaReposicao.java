package view.automacao;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class TelaAlertaReposicao extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Color COR_FUNDO = new Color(245, 247, 250);
    private final Color COR_BOTAO = new Color(52, 152, 219);

    private final JTextField campoProduto = new JTextField(20);
    private final JComboBox<String> comboUrgencia = new JComboBox<>(new String[]{
        "Todas", "Crítica (Abaixo do Mínimo)", "Atenção (Próximo ao Mínimo)"
    });

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
        new Object[][]{
            {"ESC001", "Caderno", 5, 20, 30, "Crítica"},
            {"ESC003", "Lápis", 12, 15, 25, "Atenção"}
        },
        new String[]{"Código/SKU", "Produto", "Estoque Atual", "Estoque Mínimo", "Sugestão Reposição", "Urgência"}
    ) {
        private static final long serialVersionUID = 1L;
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable tabelaAlertas = new JTable(modeloTabela);

    private final JButton btnFiltrar = new JButton("Filtrar Alertas");
    private final JButton btnGerarOrdem = new JButton("Gerar Ordem de Compra");

    public TelaAlertaReposicao() {
        criarTela();
    }

    private void criarTela() {
        setLayout(new BorderLayout(15, 15));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(COR_FUNDO);

        JPanel filtros = new JPanel(new GridBagLayout());
        filtros.setBackground(Color.WHITE);
        filtros.setBorder(BorderFactory.createTitledBorder("Filtros de Alertas de Reposição"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        adicionarCampo(filtros, gbc, 0, 0, "Produto / SKU:", campoProduto);
        adicionarCampo(filtros, gbc, 0, 2, "Nível de Urgência:", comboUrgencia);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 0;
        filtros.add(btnFiltrar, gbc);

        tabelaAlertas.setRowHeight(28);
        tabelaAlertas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setBorder(BorderFactory.createTitledBorder("Produtos Com Necessidade de Reposição"));
        painelTabela.add(new JScrollPane(tabelaAlertas), BorderLayout.CENTER);

        JPanel painelAcoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painelAcoes.setBackground(COR_FUNDO);

        btnGerarOrdem.setBackground(COR_BOTAO);
        btnGerarOrdem.setForeground(Color.WHITE);

        painelAcoes.add(btnGerarOrdem);

        add(filtros, BorderLayout.NORTH);
        add(painelTabela, BorderLayout.CENTER);
        add(painelAcoes, BorderLayout.SOUTH);

        btnFiltrar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Filtros aplicados ao relatório de alertas."));
        btnGerarOrdem.addActionListener(e -> gerarOrdemCompra());
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints gbc, int linha, int coluna, String texto, JComponent componente) {
        gbc.gridx = coluna;
        gbc.gridy = linha;
        gbc.weightx = 0;
        painel.add(new JLabel(texto), gbc);

        gbc.gridx = coluna + 1;
        gbc.weightx = 1;
        painel.add(componente, gbc);
    }

    private void gerarOrdemCompra() {
        int linhaSelecionada = tabelaAlertas.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela para gerar a ordem de compra.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String produto = (String) tabelaAlertas.getValueAt(linhaSelecionada, 1);
        Object sugestao = tabelaAlertas.getValueAt(linhaSelecionada, 4);

        JOptionPane.showMessageDialog(this, "Ordem de Compra gerada com sucesso para o produto: " + produto + "\nQuantidade Solicitada: " + sugestao, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void limpar() {
        campoProduto.setText("");
        if (comboUrgencia.getItemCount() > 0) {
            comboUrgencia.setSelectedIndex(0);
        }
        tabelaAlertas.clearSelection();
    }

    
    public JTextField getCampoProduto() {
        return campoProduto;
    }

    public JComboBox<String> getComboUrgencia() {
        return comboUrgencia;
    }

    public JTable getTabelaAlertas() {
        return tabelaAlertas;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    public JButton getBtnFiltrar() {
        return btnFiltrar;
    }

    public JButton getBtnGerarOrdem() {
        return btnGerarOrdem;
    }
}
