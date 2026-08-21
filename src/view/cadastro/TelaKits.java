package view.cadastro;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class TelaKits extends JPanel {

    private static final long serialVersionUID = 1L;

    private final JTextField codigo = new JTextField(10);
    private final JTextField nome = new JTextField(25);
    private final JTextField quantidade = new JTextField(10);
    private final JTextField pesquisa = new JTextField(24);

    private final JComboBox<String> tipo = new JComboBox<>(
            new String[] {
                    "Kit Produto",
                    "Kit Componente"
            }
    );

    private final JComboBox<String> produto = new JComboBox<>();

    private final DefaultTableModel modeloComponentes =
            new DefaultTableModel(
                    new Object[] {
                            "Produto",
                            "Quantidade"
                    },
                    0
            ) {

                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(
                        int linha,
                        int coluna
                ) {
                    return false;
                }
            };

    private final JTable tabelaComponentes =
            new JTable(modeloComponentes);

    private final DefaultTableModel modeloKits =
            new DefaultTableModel(
                    new Object[] {
                            "Código",
                            "Nome do Kit",
                            "Tipo",
                            "Componentes"
                    },
                    0
            ) {

                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(
                        int linha,
                        int coluna
                ) {
                    return false;
                }
            };

    private final JTable tabelaKits =
            new JTable(modeloKits);

    private final JButton adicionar =
            new JButton("Adicionar");

    private final JButton remover =
            new JButton("Remover");

    private final JButton novo =
            new JButton("Novo");

    private final JButton salvar =
            new JButton("Salvar");

    private final JButton excluir =
            new JButton("Excluir");

    private final JButton limpar =
            new JButton("Limpar");

    private final JButton buscar =
            new JButton("Buscar");

    private final JButton todos =
            new JButton("Todos");

    public TelaKits() {

        setLayout(
                new BorderLayout(
                        0,
                        8
                )
        );

        setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        montar();
    }

    private void montar() {

        JPanel topo =
                new JPanel(
                        new BorderLayout(
                                0,
                                8
                        )
                );

        JPanel formulario =
                new JPanel(
                        new GridBagLayout()
                );

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Cadastro de kits - produtos componentes"
                )
        );

        GridBagConstraints g =
                new GridBagConstraints();

        g.insets =
                new Insets(
                        3,
                        4,
                        3,
                        4
                );

        g.anchor =
                GridBagConstraints.WEST;

        g.fill =
                GridBagConstraints.HORIZONTAL;

        campo(
                formulario,
                g,
                0,
                "Código:",
                codigo
        );

        campo(
                formulario,
                g,
                1,
                "Nome do Kit*:",
                nome
        );

        componente(
                formulario,
                g,
                2,
                "Tipo*:",
                tipo
        );

        componente(
                formulario,
                g,
                3,
                "Produto:",
                produto
        );

        campo(
                formulario,
                g,
                4,
                "Quantidade:",
                quantidade
        );

        JPanel botoesComponentes =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                5,
                                0
                        )
                );

        botoesComponentes.add(adicionar);
        botoesComponentes.add(remover);

        componente(
                formulario,
                g,
                5,
                "Componentes:",
                botoesComponentes
        );

        JPanel botoes =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                5,
                                0
                        )
                );

        botoes.add(novo);
        botoes.add(salvar);
        botoes.add(excluir);
        botoes.add(limpar);

        topo.add(
                formulario,
                BorderLayout.CENTER
        );

        topo.add(
                botoes,
                BorderLayout.SOUTH
        );

        add(
                topo,
                BorderLayout.NORTH
        );

        JPanel componentes =
                new JPanel(
                        new BorderLayout()
                );

        componentes.setBorder(
                BorderFactory.createTitledBorder(
                        "Componentes do kit"
                )
        );

        JScrollPane scrollComponentes =
                new JScrollPane(
                        tabelaComponentes
                );

        scrollComponentes.setPreferredSize(
                new Dimension(
                        0,
                        140
                )
        );

        componentes.add(
                scrollComponentes,
                BorderLayout.CENTER
        );

        JPanel pesquisaPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                5,
                                5
                        )
                );

        pesquisaPanel.add(
                new JLabel("Pesquisar kit:")
        );

        pesquisaPanel.add(
                pesquisa
        );

        pesquisaPanel.add(
                buscar
        );

        pesquisaPanel.add(
                todos
        );

        JPanel kits =
                new JPanel(
                        new BorderLayout()
                );

        kits.setBorder(
                BorderFactory.createTitledBorder(
                        "Kits cadastrados"
                )
        );

        kits.add(
                pesquisaPanel,
                BorderLayout.NORTH
        );

        kits.add(
                new JScrollPane(
                        tabelaKits
                ),
                BorderLayout.CENTER
        );

        JPanel centro =
                new JPanel(
                        new BorderLayout(
                                0,
                                8
                        )
                );

        centro.add(
                componentes,
                BorderLayout.NORTH
        );

        centro.add(
                kits,
                BorderLayout.CENTER
        );

        add(
                centro,
                BorderLayout.CENTER
        );

        tabelaComponentes.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        tabelaKits.setSelectionMode(
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

        componente(
                painel,
                g,
                y,
                texto,
                campo
        );
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

        painel.add(
                new JLabel(texto),
                g
        );

        g.gridx = 1;
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;

        painel.add(
                componente,
                g
        );
    }

    public void limpar() {

        codigo.setText("");
        nome.setText("");
        quantidade.setText("");
        pesquisa.setText("");

        if (tipo.getItemCount() > 0) {
            tipo.setSelectedIndex(0);
        }

        if (produto.getItemCount() > 0) {
            produto.setSelectedIndex(0);
        }

        tabelaComponentes.clearSelection();
        tabelaKits.clearSelection();
    }

    public JTextField getCodigo() {
        return codigo;
    }

    public JTextField getNome() {
        return nome;
    }

    public JTextField getQuantidade() {
        return quantidade;
    }

    public JTextField getPesquisa() {
        return pesquisa;
    }

    public JComboBox<String> getTipo() {
        return tipo;
    }

    public JComboBox<String> getProduto() {
        return produto;
    }

    public JTable getTabelaComponentes() {
        return tabelaComponentes;
    }

    public JTable getTabelaKits() {
        return tabelaKits;
    }

    public DefaultTableModel getModeloComponentes() {
        return modeloComponentes;
    }

    public DefaultTableModel getModeloKits() {
        return modeloKits;
    }

    public JButton getAdicionar() {
        return adicionar;
    }

    public JButton getRemover() {
        return remover;
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
