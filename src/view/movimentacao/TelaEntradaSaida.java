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

    // Item movimentado: produto, variação (SKU) ou kit
    private SeletorItem seletorItem;

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


    // Usado pela TelaMovimentacaoRastreabilidade
    public JPanel getPainel() {
        return this;
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
        // ITEM (PRODUTO, VARIAÇÃO/SKU OU KIT)
        // --------------------------------------------------

        // O usuário escolhe o tipo do item, digita o código
        // (ou usa o botão Buscar) e o nome aparece sozinho.
        seletorItem = new SeletorItem(true);


        adicionarCampo(
            formulario,
            gbc,
            1,
            "Item:",
            seletorItem
        );


        // --------------------------------------------------
        // QUANTIDADE
        // --------------------------------------------------

        campoQuantidade = new JTextField(20);


        adicionarCampo(
            formulario,
            gbc,
            2,
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
            3,
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
            4,
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
            5,
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
            6,
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
            7,
            "Responsável:",
            campoResponsavel
        );


        // --------------------------------------------------
        // OBSERVAÇÃO
        // --------------------------------------------------

        gbc.gridx = 0;
        gbc.gridy = 8;
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
    // LIMPAR CAMPOS
    // --------------------------------------------------

    private void limparCampos() {

        campoTipo.setSelectedIndex(0);


        seletorItem.limpar();

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


String quantidade =
            campoQuantidade.getText().trim();


        String motivo =
            (String) campoMotivo.getSelectedItem();


        String responsavel =
            campoResponsavel.getText().trim();


        // --------------------------------------------------
        // VALIDAÇÃO DO ITEM (PRODUTO, VARIAÇÃO/SKU OU KIT)
        // --------------------------------------------------

        // Confere se o código existe no cadastro.
        // A própria mensagem de erro é mostrada pelo seletor.

        if (!seletorItem.validar(this, true)) {

            return;
        }


        CatalogoItens.Item item =
            seletorItem.getItem();


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

            + "Tipo do item: " + item.getTipo() + "\n"

            + "Código: " + item.getCodigo() + "\n"

            + "Item: " + item.getNome() + "\n"

            + "Quantidade: " + quantidade + "\n"

            + "Motivo: " + motivo,

            "Movimentação",

            JOptionPane.INFORMATION_MESSAGE
        );
    }
     public  JComboBox<String>  getcampoTipo() {
        return campoTipo;
    }

    public JTextField getcampoQuantidade() {
        return campoQuantidade;
    }

    public JComboBox<String> getcampoMotivo() {
        return campoMotivo;
    }

    public JTextField getcampoOrigem() {
        return campoOrigem;
    }

    public JTextField getcampoDestino() {
        return campoDestino;
    }

    public JTextField getcampoResponsavel() {
        return  campoResponsavel;
    }

    public JTextArea getcampoObservacao() {
        return campoObservacao;
    }
}
