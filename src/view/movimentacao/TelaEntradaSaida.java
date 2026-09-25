package view.movimentacao;

// Importa as classes do Swing utilizadas
// para criar os componentes da interface.
import javax.swing.*;

// Importa a classe utilizada para criar
// margens e espaçamentos nos painéis.
import javax.swing.border.EmptyBorder;

// Importa as classes do AWT utilizadas
// principalmente para cores e organização dos componentes.
import java.awt.*;


// Classe responsável pela tela de Entrada e Saída
// de produtos do estoque.
public class TelaEntradaSaida extends JPanel {

    private static final long serialVersionUID = 1L;

    // Cores da tela
    private final Color COR_FUNDO = new Color(245, 247, 250);
    private final Color COR_BOTAO = new Color(52, 152, 219);

    // Campos do formulário
    private JComboBox<String> campoTipo;

    private JTextField campoProduto;
    private JButton botaoEscolherProduto;

    private JTextField campoCodigo;
    private JTextField campoQuantidade;

    private JComboBox<String> campoMotivo;

    private JTextField campoDocumento;
    private JTextField campoOrigem;
    private JTextField campoDestino;
    private JTextField campoResponsavel;

    private JTextArea campoObservacao;


    public TelaEntradaSaida() {
        criarTela();
    }


    private void criarTela() {

        // Configuração do próprio JPanel
        setLayout(new BorderLayout(15, 15));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(COR_FUNDO);


        // --------------------------------------------------
        // FORMULÁRIO
        // --------------------------------------------------

        JPanel formulario = new JPanel(new GridBagLayout());

        formulario.setBackground(Color.WHITE);

        formulario.setBorder(
            BorderFactory.createTitledBorder(
                "Dados da movimentação"
            )
        );


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;


        // --------------------------------------------------
        // TIPO DE MOVIMENTAÇÃO
        // --------------------------------------------------

        campoTipo = new JComboBox<>(
            new String[]{
                "Entrada",
                "Saída"
            }
        );


        adicionarCampo(
            formulario,
            gbc,
            0,
            "Tipo de movimentação:",
            campoTipo
        );


        // --------------------------------------------------
        // PRODUTO
        // --------------------------------------------------

        campoProduto = new JTextField(20);

        // Impede o usuário de digitar diretamente
        // o nome do produto.
        campoProduto.setEditable(false);


        // Botão para escolher o produto
        botaoEscolherProduto = new JButton(
            "Escolher produto"
        );


        // Quando clicar no botão,
        // abre a janela para escolher o produto.
        botaoEscolherProduto.addActionListener(
            e -> escolherProduto()
        );


        // Painel que contém o campo e o botão
        JPanel painelProduto = new JPanel(
            new BorderLayout(5, 0)
        );

        painelProduto.setBackground(Color.WHITE);


        painelProduto.add(
            campoProduto,
            BorderLayout.CENTER
        );


        painelProduto.add(
            botaoEscolherProduto,
            BorderLayout.EAST
        );


        adicionarCampo(
            formulario,
            gbc,
            1,
            "Produto:",
            painelProduto
        );


        // --------------------------------------------------
        // CÓDIGO DO PRODUTO
        // --------------------------------------------------

        campoCodigo = new JTextField(20);

        // O código será preenchido automaticamente
        // de acordo com o produto escolhido.
        campoCodigo.setEditable(false);


        adicionarCampo(
            formulario,
            gbc,
            2,
            "Código do produto:",
            campoCodigo
        );


        // --------------------------------------------------
        // QUANTIDADE
        // --------------------------------------------------

        campoQuantidade = new JTextField(20);


        adicionarCampo(
            formulario,
            gbc,
            3,
            "Quantidade:",
            campoQuantidade
        );


        // --------------------------------------------------
        // MOTIVO
        // --------------------------------------------------

        campoMotivo = new JComboBox<>(
            new String[]{
                "Compra",
                "Venda",
                "Devolução de cliente",
                "Devolução para fornecedor",
                "Transferência",
                "Ajuste"
            }
        );


        adicionarCampo(
            formulario,
            gbc,
            4,
            "Motivo:",
            campoMotivo
        );


        // --------------------------------------------------
        // DOCUMENTO
        // --------------------------------------------------

        campoDocumento = new JTextField(20);


        adicionarCampo(
            formulario,
            gbc,
            5,
            "Documento relacionado:",
            campoDocumento
        );


        // --------------------------------------------------
        // ORIGEM
        // --------------------------------------------------

        campoOrigem = new JTextField(20);


        adicionarCampo(
            formulario,
            gbc,
            6,
            "Origem:",
            campoOrigem
        );


        // --------------------------------------------------
        // DESTINO
        // --------------------------------------------------

        campoDestino = new JTextField(20);


        adicionarCampo(
            formulario,
            gbc,
            7,
            "Destino:",
            campoDestino
        );


        // --------------------------------------------------
        // RESPONSÁVEL
        // --------------------------------------------------

        campoResponsavel = new JTextField(20);


        adicionarCampo(
            formulario,
            gbc,
            8,
            "Responsável:",
            campoResponsavel
        );


        // --------------------------------------------------
        // OBSERVAÇÃO
        // --------------------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 0;


        formulario.add(
            new JLabel("Observação:"),
            gbc
        );


        campoObservacao = new JTextArea(3, 20);

        campoObservacao.setLineWrap(true);
        campoObservacao.setWrapStyleWord(true);


        gbc.gridx = 1;
        gbc.weightx = 1;


        formulario.add(
            new JScrollPane(campoObservacao),
            gbc
        );


        // --------------------------------------------------
        // BOTÕES
        // --------------------------------------------------

        JPanel botoes = new JPanel(
            new FlowLayout(FlowLayout.RIGHT)
        );


        botoes.setBackground(COR_FUNDO);


        JButton cancelar = new JButton(
            "Cancelar"
        );


        JButton registrar = new JButton(
            "Registrar movimentação"
        );


        registrar.setBackground(COR_BOTAO);
        registrar.setForeground(Color.WHITE);


        // Botão Cancelar
        cancelar.addActionListener(
            e -> limparCampos()
        );


        // Botão Registrar
        registrar.addActionListener(
            e -> registrarMovimentacao()
        );


        botoes.add(cancelar);
        botoes.add(registrar);


        // --------------------------------------------------
        // ADICIONA OS COMPONENTES À TELA
        // --------------------------------------------------

        add(
            new JScrollPane(formulario),
            BorderLayout.CENTER
        );


        add(
            botoes,
            BorderLayout.SOUTH
        );
    }


    // --------------------------------------------------
    // MÉTODO PARA ADICIONAR CAMPOS
    // --------------------------------------------------

    private void adicionarCampo(
        JPanel painel,
        GridBagConstraints gbc,
        int linha,
        String texto,
        JComponent componente
    ) {

        // Primeira coluna - descrição
        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.weightx = 0;


        painel.add(
            new JLabel(texto),
            gbc
        );


        // Segunda coluna - campo
        gbc.gridx = 1;
        gbc.weightx = 1;


        painel.add(
            componente,
            gbc
        );
    }


    // --------------------------------------------------
    // ESCOLHER PRODUTO
    // --------------------------------------------------

    private void escolherProduto() {

        /*
         * Lista de produtos relacionados
         * ao ambiente escolar.
         */

        String[] produtos = {

            "Caderno",

            "Caneta",

            "Lápis",

            "Borracha",

            "Apontador",

            "Régua",

            "Mochila escolar",

            "Estojo",

            "Uniforme escolar",

            "Papel sulfite",

            "Cartolina",

            "Cola branca",

            "Tesoura escolar",

            "Marcador de texto",

            "Pasta escolar"
        };


        // Abre uma janela para o usuário escolher
        // um dos produtos disponíveis.

        String produtoSelecionado =
            (String) JOptionPane.showInputDialog(

                this,

                "Selecione o produto:",

                "Escolher produto",

                JOptionPane.QUESTION_MESSAGE,

                null,

                produtos,

                produtos[0]
            );


        // Verifica se o usuário realmente
        // escolheu algum produto.

        if (produtoSelecionado != null) {

            // Coloca o nome do produto
            // no campo Produto.

            campoProduto.setText(
                produtoSelecionado
            );


            // Define o código automaticamente.

            switch (produtoSelecionado) {

                case "Caderno":
                    campoCodigo.setText("ESC001");
                    break;


                case "Caneta":
                    campoCodigo.setText("ESC002");
                    break;


                case "Lápis":
                    campoCodigo.setText("ESC003");
                    break;


                case "Borracha":
                    campoCodigo.setText("ESC004");
                    break;


                case "Apontador":
                    campoCodigo.setText("ESC005");
                    break;


                case "Régua":
                    campoCodigo.setText("ESC006");
                    break;


                case "Mochila escolar":
                    campoCodigo.setText("ESC007");
                    break;


                case "Estojo":
                    campoCodigo.setText("ESC008");
                    break;


                case "Uniforme escolar":
                    campoCodigo.setText("ESC009");
                    break;


                case "Papel sulfite":
                    campoCodigo.setText("ESC010");
                    break;


                case "Cartolina":
                    campoCodigo.setText("ESC011");
                    break;


                case "Cola branca":
                    campoCodigo.setText("ESC012");
                    break;


                case "Tesoura escolar":
                    campoCodigo.setText("ESC013");
                    break;


                case "Marcador de texto":
                    campoCodigo.setText("ESC014");
                    break;


                case "Pasta escolar":
                    campoCodigo.setText("ESC015");
                    break;
            }
        }
    }


    // --------------------------------------------------
    // LIMPAR CAMPOS
    // --------------------------------------------------

    private void limparCampos() {

        campoTipo.setSelectedIndex(0);


        campoProduto.setText("");

        campoCodigo.setText("");

        campoQuantidade.setText("");


        campoMotivo.setSelectedIndex(0);


        campoDocumento.setText("");

        campoOrigem.setText("");

        campoDestino.setText("");

        campoResponsavel.setText("");


        campoObservacao.setText("");
    }


    // --------------------------------------------------
    // REGISTRAR MOVIMENTAÇÃO
    // --------------------------------------------------

    private void registrarMovimentacao() {

        String tipo =
            (String) campoTipo.getSelectedItem();


        String produto =
            campoProduto.getText().trim();


        String codigo =
            campoCodigo.getText().trim();


        String quantidade =
            campoQuantidade.getText().trim();


        String motivo =
            (String) campoMotivo.getSelectedItem();


        String responsavel =
            campoResponsavel.getText().trim();


        // --------------------------------------------------
        // VALIDAÇÃO DO PRODUTO
        // --------------------------------------------------

        if (produto.isEmpty()) {

            JOptionPane.showMessageDialog(

                this,

                "Escolha um produto.",

                "Atenção",

                JOptionPane.WARNING_MESSAGE
            );


            botaoEscolherProduto.requestFocus();

            return;
        }


        // --------------------------------------------------
        // VALIDAÇÃO DO CÓDIGO
        // --------------------------------------------------

        if (codigo.isEmpty()) {

            JOptionPane.showMessageDialog(

                this,

                "Escolha um produto para gerar o código.",

                "Atenção",

                JOptionPane.WARNING_MESSAGE
            );


            botaoEscolherProduto.requestFocus();

            return;
        }


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


        // Verifica se a quantidade
        // é realmente um número.

        try {

            int quantidadeNumero =
                Integer.parseInt(quantidade);


            if (quantidadeNumero <= 0) {

                JOptionPane.showMessageDialog(

                    this,

                    "A quantidade deve ser maior que zero.",

                    "Atenção",

                    JOptionPane.WARNING_MESSAGE
                );


                campoQuantidade.requestFocus();

                return;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(

                this,

                "Digite uma quantidade válida.",

                "Atenção",

                JOptionPane.WARNING_MESSAGE
            );


            campoQuantidade.requestFocus();

            return;
        }


        // --------------------------------------------------
        // VALIDAÇÃO DO RESPONSÁVEL
        // --------------------------------------------------

        if (responsavel.isEmpty()) {

            JOptionPane.showMessageDialog(

                this,

                "Informe o responsável pela movimentação.",

                "Atenção",

                JOptionPane.WARNING_MESSAGE
            );


            campoResponsavel.requestFocus();

            return;
        }


        // --------------------------------------------------
        // CONFIRMAÇÃO
        // --------------------------------------------------

        JOptionPane.showMessageDialog(

            this,

            "Movimentação registrada com sucesso!\n\n"

            + "Tipo: " + tipo + "\n"

            + "Produto: " + produto + "\n"

            + "Código: " + codigo + "\n"

            + "Quantidade: " + quantidade + "\n"

            + "Motivo: " + motivo,

            "Movimentação",

            JOptionPane.INFORMATION_MESSAGE
        );
    }
}