package view.cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TelaProdutos extends JPanel {

    private static final long serialVersionUID = 1L;

    private final JTextField codigo = new JTextField(10);
    private final JTextField nome = new JTextField(25);
    private final JTextField categoria = new JTextField(20);
    private final JTextField descricao = new JTextField(30);
    private final JTextField modelo = new JTextField(20);
    private final JTextField peso = new JTextField(10);
    private final JTextField preco = new JTextField(10);
    private final JTextField estoqueMinimo = new JTextField(10);
    private final JTextField estoqueMaximo = new JTextField(10);
    private final JTextField pesquisa = new JTextField(24);

    private final JComboBox<String> status = new JComboBox<>(
            new String[] { "Ativo", "Inativo" }
    );

    private final DefaultTableModel modeloTabela = new DefaultTableModel(
            new Object[] {
                    "Código",
                    "Nome",
                    "Categoria",
                    "Modelo",
                    "Preço",
                    "Estoque",
                    "Status"
            },
            0
    ) {
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int linha, int coluna) {
            return false;
        }
    };

    private final JTable tabela = new JTable(modeloTabela);

    private final JButton novo = new JButton("Novo");
    private final JButton salvar = new JButton("Salvar");
    private final JButton excluir = new JButton("Excluir");
    private final JButton limpar = new JButton("Limpar");
    private final JButton buscar = new JButton("Buscar");
    private final JButton todos = new JButton("Todos");

    public TelaProdutos() {

        setLayout(new BorderLayout(8, 8));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        montar();
    }

    private void montar() {

        JPanel formulario = new JPanel(new GridBagLayout());

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Cadastro de produtos"
                )
        );

        GridBagConstraints g = new GridBagConstraints();

        g.insets = new Insets(3, 4, 3, 4);
        g.anchor = GridBagConstraints.WEST;

        campo(formulario, g, 0, "Código:", codigo);
        campo(formulario, g, 1, "Nome*:", nome);
        campo(formulario, g, 2, "Categoria*:", categoria);
        campo(formulario, g, 3, "Descrição:", descricao);
        campo(formulario, g, 4, "Modelo:", modelo);
        campo(formulario, g, 5, "Peso:", peso);
        campo(formulario, g, 6, "Preço*:", preco);
        campo(formulario, g, 7, "Estoque mínimo:", estoqueMinimo);
        campo(formulario, g, 8, "Estoque máximo:", estoqueMaximo);
        componente(formulario, g, 9, "Status:", status);

        JPanel botoes = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
        );

        botoes.add(novo);
        botoes.add(salvar);
        botoes.add(excluir);
        botoes.add(limpar);

        JPanel superior = new JPanel(new BorderLayout());

        superior.add(formulario, BorderLayout.CENTER);
        superior.add(botoes, BorderLayout.SOUTH);

        add(superior, BorderLayout.NORTH);

        JPanel pesquisaPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT)
        );

        pesquisaPanel.add(new JLabel("Pesquisar produto:"));
        pesquisaPanel.add(pesquisa);
        pesquisaPanel.add(buscar);
        pesquisaPanel.add(todos);

        JPanel central = new JPanel(new BorderLayout());

        central.add(pesquisaPanel, BorderLayout.NORTH);
        central.add(new JScrollPane(tabela), BorderLayout.CENTER);

        add(central, BorderLayout.CENTER);

        tabela.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
    }

    private void campo(
            JPanel painel,
            GridBagConstraints g,
            int y,
            String texto,
            JTextField campo
    ) {
        componente(painel, g, y, texto, campo);
    }

    private void componente(
            JPanel painel,
            GridBagConstraints g,
            int y,
            String texto,
            java.awt.Component componente
    ) {

        g.gridx = 0;
        g.gridy = y;
        g.weightx = 0;
        g.fill = GridBagConstraints.NONE;

        painel.add(new JLabel(texto), g);

        g.gridx = 1;
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;

        painel.add(componente, g);
    }

    public void limpar() {

        codigo.setText("");
        nome.setText("");
        categoria.setText("");
        descricao.setText("");
        modelo.setText("");
        peso.setText("");
        preco.setText("");
        estoqueMinimo.setText("");
        estoqueMaximo.setText("");

        if (status.getItemCount() > 0) {
            status.setSelectedIndex(0);
        }

        tabela.clearSelection();
    }

    public JTextField getCodigo() {
        return codigo;
    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getCategoria() {
        return categoria;
    }

    public JTextField getDescricao() {
        return descricao;
    }

    public JTextField getModelo() {
        return modelo;
    }

    public JTextField getPeso() {
        return peso;
    }

    public JTextField getPreco() {
        return preco;
    }

    public JTextField getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public JTextField getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public JTextField getPesquisa() {
        return pesquisa;
    }

    public JComboBox<String> getStatus() {
        return status;
    }

    public JTable getTabela() {
        return tabela;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }

    public JButton getNovo() {
        return novo;
    }

    public JButton getSalvar() {
        return salvar;
    }

    public JButton getExcluir() {
        return excluir;
    }

    public JButton getLimpar() {
        return limpar;
    }

    public JButton getBuscar() {
        return buscar;
    }

    public JButton getTodos() {
        return todos;
    }
}
