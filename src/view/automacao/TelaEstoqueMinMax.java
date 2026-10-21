package view.automacao;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaEstoqueMinMax extends JPanel {

    private static final long serialVersionUID = 1L;

    private final Color COR_FUNDO = new Color(245, 247, 250);
    private final Color COR_BOTAO = new Color(52, 152, 219);

    private final JTextField campoProduto = new JTextField(20);
    private final JTextField campoEstoqueMin = new JTextField(15);
    private final JTextField campoEstoqueMax = new JTextField(15);
    private final JComboBox<String> comboStatus = new JComboBox<>(new String[]{"Todos", "Ativo", "Inativo"});

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Produto / SKU", "Estoque Mínimo", "Estoque Máximo", "Status"}
    ) {
        private static final long serialVersionUID = 1L;
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    private final JTable tabela = new JTable(modeloTabela);

    private final JButton btnSalvar = new JButton("Salvar Parâmetros");
    private final JButton btnLimpar = new JButton("Limpar");
    private final JButton btnPesquisar = new JButton("Pesquisar");

    public TelaEstoqueMinMax() {
        criarTela();
    }

    private void criarTela() {
        setLayout(new BorderLayout(15, 15));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(COR_FUNDO);

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBackground(Color.WHITE);
        formulario.setBorder(BorderFactory.createTitledBorder("Configuração de Estoque Mínimo e Máximo"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        adicionarCampo(formulario, gbc, 0, 0, "Produto / SKU:", campoProduto);
        adicionarCampo(formulario, gbc, 0, 2, "Status:", comboStatus);
        adicionarCampo(formulario, gbc, 1, 0, "Estoque Mínimo:", campoEstoqueMin);
        adicionarCampo(formulario, gbc, 1, 2, "Estoque Máximo:", campoEstoqueMax);

        btnSalvar.setBackground(COR_BOTAO);
        btnSalvar.setForeground(Color.WHITE);

        JPanel botoesForm = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        botoesForm.setBackground(Color.WHITE);
        botoesForm.add(btnLimpar);
        botoesForm.add(btnPesquisar);
        botoesForm.add(btnSalvar);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weightx = 1;
        formulario.add(botoesForm, gbc);

        tabela.setRowHeight(28);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel painelTabela = new JPanel(new BorderLayout());
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setBorder(BorderFactory.createTitledBorder("Parâmetros Cadastrados"));
        painelTabela.add(new JScrollPane(tabela), BorderLayout.CENTER);

        add(formulario, BorderLayout.NORTH);
        add(painelTabela, BorderLayout.CENTER);

        btnSalvar.addActionListener(e -> salvarParametros());
        btnLimpar.addActionListener(e -> limpar());
        btnPesquisar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Filtro aplicado com sucesso."));
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

    private void salvarParametros() {
        if (campoProduto.getText().trim().isEmpty() || campoEstoqueMin.getText().trim().isEmpty() || campoEstoqueMax.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int min = Integer.parseInt(campoEstoqueMin.getText().trim());
            int max = Integer.parseInt(campoEstoqueMax.getText().trim());

            if (min >= max) {
                JOptionPane.showMessageDialog(this, "O estoque mínimo deve ser menor que o máximo.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            modeloTabela.addRow(new Object[]{
                campoProduto.getText().trim(),
                min,
                max,
                comboStatus.getSelectedItem()
            });

            JOptionPane.showMessageDialog(this, "Parâmetros salvos com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limpar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite valores numéricos inteiros válidos para os estoques.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpar() {
        campoProduto.setText("");
        campoEstoqueMin.setText("");
        campoEstoqueMax.setText("");
        if (comboStatus.getItemCount() > 0) {
            comboStatus.setSelectedIndex(0);
        }
        tabela.clearSelection();
    }

    public JTextField getCampoProduto() {
        return campoProduto;
    }

    public JTextField getCampoEstoqueMin() {
        return campoEstoqueMin;
    }

    public JTextField getCampoEstoqueMax() {
        return campoEstoqueMax;
    }

    public JComboBox<String> getComboStatus() {
        return comboStatus;
    }

    public JTable getTabela() {
        return tabela;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnLimpar() {
        return btnLimpar;
    }

    public JButton getBtnPesquisar() {
        return btnPesquisar;
    }
}
