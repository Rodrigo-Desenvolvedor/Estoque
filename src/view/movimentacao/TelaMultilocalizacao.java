package view.movimentacao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


// Classe responsável pela tela de Multilocalização.
public class TelaMultilocalizacao extends JPanel {

    private static final long serialVersionUID = 1L;

    // Cor de fundo da tela
    private final Color COR_FUNDO =
            new Color(245, 247, 250);

    // Campos da consulta
    // Item consultado: produto, variação (SKU) ou kit
    private SeletorItem seletorItemPesquisa;

    // Campos da transferência
    private JTextField campoOrigem;
    private JTextField campoDestino;

    // Item transferido: produto, variação (SKU) ou kit
    private SeletorItem seletorItemTransferencia;

    private JTextField campoQuantidade;
    private JTextField campoLote;
    private JTextField campoSerie;
    private JTextField campoDocumento;
    private JTextField campoObservacao;

    // Tabela de estoque
    private JTable tabela;
    private DefaultTableModel modeloTabela;


    public TelaMultilocalizacao() {
        criarTela();
    }


    // Usado pela TelaMovimentacaoRastreabilidade
    public JPanel getPainel() {
        return this;
    }


    /**
     * Cria a interface da tela.
     */
    private void criarTela() {

        // Configura o próprio JPanel
        setLayout(new BorderLayout(15, 15));

        setBorder(
                new EmptyBorder(20, 20, 20, 20)
        );

        setBackground(COR_FUNDO);


        // --------------------------------------------------
        // ÁREA DE PESQUISA DO PRODUTO
        // --------------------------------------------------

        JPanel produtoPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT
                        )
                );

        produtoPanel.setBackground(Color.WHITE);

        produtoPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Consulta de estoque por localização"
                )
        );


        produtoPanel.add(
                new JLabel("Item:")
        );


        // Tipo (Produto / Variação (SKU) / Kit) + código + nome
        seletorItemPesquisa =
                new SeletorItem(true);


        produtoPanel.add(
                seletorItemPesquisa
        );


        // Botão pesquisar
        JButton pesquisar =
                new JButton("Pesquisar");


        produtoPanel.add(
                pesquisar
        );


        // Ação do botão pesquisar
        pesquisar.addActionListener(
                e -> pesquisarProduto()
        );


        // --------------------------------------------------
        // TABELA DE ESTOQUE POR LOCALIZAÇÃO
        // --------------------------------------------------

        String[] colunas = {
                "Local",
                "Quantidade",
                "Lote",
                "Número de Série"
        };


        modeloTabela =
                new DefaultTableModel(
                        new Object[][]{},
                        colunas
                );


        tabela =
                new JTable(modeloTabela);


        tabela.setRowHeight(28);


        // Impede edição direta das células
        tabela.setDefaultEditor(
                Object.class,
                null
        );


        JPanel estoqueLocal =
                new JPanel(
                        new BorderLayout()
                );


        estoqueLocal.setBackground(Color.WHITE);


        estoqueLocal.setBorder(
                BorderFactory.createTitledBorder(
                        "Estoque por local"
                )
        );


        estoqueLocal.add(
                new JScrollPane(tabela),
                BorderLayout.CENTER
        );


        // --------------------------------------------------
        // ÁREA DE TRANSFERÊNCIA ENTRE LOCAIS
        // --------------------------------------------------

        JPanel transferencia =
                new JPanel(
                        new GridBagLayout()
                );


        transferencia.setBackground(Color.WHITE);


        transferencia.setBorder(
                BorderFactory.createTitledBorder(
                        "Transferência entre locais"
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();


        gbc.insets =
                new Insets(7, 10, 7, 10);


        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        gbc.weightx = 1;


        // --------------------------------------------------
        // ORIGEM
        // --------------------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Origem:"),
                gbc
        );


        campoOrigem =
                new JTextField(15);


        gbc.gridx = 1;
        gbc.weightx = 1;


        transferencia.add(
                campoOrigem,
                gbc
        );


        // --------------------------------------------------
        // DESTINO
        // --------------------------------------------------

        gbc.gridx = 2;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Destino:"),
                gbc
        );


        campoDestino =
                new JTextField(15);


        gbc.gridx = 3;
        gbc.weightx = 1;


        transferencia.add(
                campoDestino,
                gbc
        );


        // --------------------------------------------------
        // ITEM (PRODUTO, VARIAÇÃO/SKU OU KIT)
        // --------------------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Item:"),
                gbc
        );


        seletorItemTransferencia =
                new SeletorItem(true);


        gbc.gridx = 1;
        gbc.weightx = 1;


        transferencia.add(
                seletorItemTransferencia,
                gbc
        );


        // --------------------------------------------------
        // QUANTIDADE
        // --------------------------------------------------

        gbc.gridx = 2;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Quantidade:"),
                gbc
        );


        campoQuantidade =
                new JTextField(15);


        gbc.gridx = 3;
        gbc.weightx = 1;


        transferencia.add(
                campoQuantidade,
                gbc
        );


        // --------------------------------------------------
        // LOTE
        // --------------------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Lote:"),
                gbc
        );


        campoLote =
                new JTextField(15);


        gbc.gridx = 1;
        gbc.weightx = 1;


        transferencia.add(
                campoLote,
                gbc
        );


        // --------------------------------------------------
        // NÚMERO DE SÉRIE
        // --------------------------------------------------

        gbc.gridx = 2;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Nº de Série:"),
                gbc
        );


        campoSerie =
                new JTextField(15);


        gbc.gridx = 3;
        gbc.weightx = 1;


        transferencia.add(
                campoSerie,
                gbc
        );


        // --------------------------------------------------
        // DOCUMENTO
        // --------------------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Documento:"),
                gbc
        );


        campoDocumento =
                new JTextField(15);


        gbc.gridx = 1;
        gbc.weightx = 1;


        transferencia.add(
                campoDocumento,
                gbc
        );


        // --------------------------------------------------
        // OBSERVAÇÃO
        // --------------------------------------------------

        gbc.gridx = 2;
        gbc.weightx = 0;


        transferencia.add(
                new JLabel("Observação:"),
                gbc
        );


        campoObservacao =
                new JTextField(15);


        gbc.gridx = 3;
        gbc.weightx = 1;


        transferencia.add(
                campoObservacao,
                gbc
        );


        // --------------------------------------------------
        // BOTÃO DE TRANSFERÊNCIA
        // --------------------------------------------------

        JButton transferir =
                new JButton(
                        "Realizar Transferência"
                );


        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.weightx = 0;


        transferencia.add(
                transferir,
                gbc
        );


        // Ação do botão
        transferir.addActionListener(
                e -> realizarTransferencia()
        );


        // --------------------------------------------------
        // ORGANIZAÇÃO FINAL
        // --------------------------------------------------

        add(
                produtoPanel,
                BorderLayout.NORTH
        );


        add(
                estoqueLocal,
                BorderLayout.CENTER
        );


        add(
                transferencia,
                BorderLayout.SOUTH
        );
    }


    /**
     * Realiza a pesquisa do produto.
     */
    private void pesquisarProduto() {

        // O item (produto, SKU ou kit) é obrigatório na consulta.
        // A mensagem de erro é mostrada pelo próprio seletor.
        if (!seletorItemPesquisa.validar(this, true)) {

            return;
        }


        CatalogoItens.Item item =
                seletorItemPesquisa.getItem();


        // Limpa os registros atuais
        modeloTabela.setRowCount(0);


        /*
         * Dados de exemplo relacionados
         * a uma escola.
         *
         * Futuramente esses dados podem
         * vir do banco de dados.
         */

        modeloTabela.addRow(
                new Object[]{
                        "Almoxarifado",
                        100,
                        "L001",
                        "N/A"
                }
        );


        modeloTabela.addRow(
                new Object[]{
                        "Sala dos Professores",
                        25,
                        "L002",
                        "N/A"
                }
        );


        modeloTabela.addRow(
                new Object[]{
                        "Biblioteca",
                        15,
                        "L003",
                        "N/A"
                }
        );


        modeloTabela.addRow(
                new Object[]{
                        "Secretaria",
                        30,
                        "L004",
                        "N/A"
                }
        );


        JOptionPane.showMessageDialog(

                this,

                "Pesquisa realizada para o item:\n"
                        + item.getTipo() + ": "
                        + item.descricao(),

                "Pesquisa",

                JOptionPane.INFORMATION_MESSAGE
        );
    }


    /**
     * Realiza a transferência entre locais.
     */
    private void realizarTransferencia() {

        String origem =
                campoOrigem.getText().trim();


        String destino =
                campoDestino.getText().trim();


String quantidade =
                campoQuantidade
                        .getText()
                        .trim();


        // --------------------------------------------------
        // VALIDAÇÃO DA ORIGEM
        // --------------------------------------------------

        if (origem.isEmpty()) {

            JOptionPane.showMessageDialog(

                    this,

                    "Informe o local de origem.",

                    "Atenção",

                    JOptionPane.WARNING_MESSAGE
            );


            campoOrigem.requestFocus();

            return;
        }


        // --------------------------------------------------
        // VALIDAÇÃO DO DESTINO
        // --------------------------------------------------

        if (destino.isEmpty()) {

            JOptionPane.showMessageDialog(

                    this,

                    "Informe o local de destino.",

                    "Atenção",

                    JOptionPane.WARNING_MESSAGE
            );


            campoDestino.requestFocus();

            return;
        }


        // --------------------------------------------------
        // VERIFICA ORIGEM E DESTINO
        // --------------------------------------------------

        if (origem.equalsIgnoreCase(destino)) {

            JOptionPane.showMessageDialog(

                    this,

                    "O local de origem não pode ser "
                            + "igual ao local de destino.",

                    "Atenção",

                    JOptionPane.WARNING_MESSAGE
            );


            campoDestino.requestFocus();

            return;
        }


        // --------------------------------------------------
        // VALIDAÇÃO DO ITEM (PRODUTO, VARIAÇÃO/SKU OU KIT)
        // --------------------------------------------------

        if (!seletorItemTransferencia.validar(this, true)) {

            return;
        }


        CatalogoItens.Item item =
                seletorItemTransferencia.getItem();


        // --------------------------------------------------
        // VALIDAÇÃO DA QUANTIDADE
        // --------------------------------------------------

        if (quantidade.isEmpty()) {

            JOptionPane.showMessageDialog(

                    this,

                    "Informe a quantidade.",

                    "Atenção",

                    JOptionPane.WARNING_MESSAGE
            );


            campoQuantidade.requestFocus();

            return;
        }


        // Verifica se a quantidade é válida
        try {

            double valor =
                    Double.parseDouble(
                            quantidade.replace(",", ".")
                    );


            if (valor <= 0) {

                JOptionPane.showMessageDialog(

                        this,

                        "A quantidade deve ser maior que zero.",

                        "Atenção",

                        JOptionPane.WARNING_MESSAGE
                );


                campoQuantidade.requestFocus();

                return;
            }


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(

                    this,

                    "Informe uma quantidade válida.",

                    "Atenção",

                    JOptionPane.WARNING_MESSAGE
            );


            campoQuantidade.requestFocus();

            return;
        }


        // --------------------------------------------------
        // CONFIRMAÇÃO
        // --------------------------------------------------

        JOptionPane.showMessageDialog(

                this,

                "Transferência realizada com sucesso!\n\n"

                        + "Item (" + item.getTipo() + "): "
                        + item.descricao() + "\n"

                        + "Origem: " + origem + "\n"

                        + "Destino: " + destino + "\n"

                        + "Quantidade: " + quantidade,

                "Transferência",

                JOptionPane.INFORMATION_MESSAGE
        );


        limparTransferencia();
    }


    /**
     * Limpa os campos da transferência.
     */
    private void limparTransferencia() {

        campoOrigem.setText("");

        campoDestino.setText("");

        seletorItemTransferencia.limpar();

        campoQuantidade.setText("");

        campoLote.setText("");

        campoSerie.setText("");

        campoDocumento.setText("");

        campoObservacao.setText("");
    }
     public JTextField getcampoQuantidade() {
        return campoQuantidade;
    }

    public JTextField getcampoOrigem() {
        return campoOrigem;
    }

    public JTextField getcampoDestino() {
        return campoDestino;
    }

    public JTextField getcampoLote() {
        return  campoLote;
    }

    public JTextField getcampoSerie() {
        return campoSerie;
    }
    
    public JTextField getcampoDocumento() {
        return   campoDocumento;
    }
    
    public JTextField getcampoObservacao() {
        return   campoObservacao;
    }

    public DefaultTableModel getModeloTabela() {
        return modeloTabela;
    }
    
    public JTable getTabela() {
        return tabela;
    }

    
}
