package view;

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
public class TelaEntradaSaida {


    // Define a cor de fundo utilizada na tela.
    private final Color COR_FUNDO =
            new Color(245, 247, 250);


    // Define a cor utilizada no botão
    // de registrar a movimentação.
    private final Color COR_BOTAO =
            new Color(52, 152, 219);


    // Declara o painel principal da tela.
    //
    // Esse painel será retornado pelo método getPainel()
    // e utilizado dentro da aba "Entrada e Saída".
    private JPanel painel;


    // Construtor da classe.
    //
    // Quando a classe é criada, o método criarTela()
    // é chamado para montar a interface.
    public TelaEntradaSaida() {

        criarTela();

    }


    // Método responsável por criar
    // todos os componentes da tela.
    private void criarTela() {


        // Cria o painel principal utilizando BorderLayout.
        //
        // Os valores 15, 15 definem o espaçamento
        // entre as regiões da tela.
        painel = new JPanel(
                new BorderLayout(15, 15)
        );


        // Adiciona uma margem de 20 pixels
        // em todos os lados do painel.
        painel.setBorder(
                new EmptyBorder(20, 20, 20, 20)
        );


        // Define a cor de fundo da tela.
        painel.setBackground(COR_FUNDO);


        // --------------------------------------------------
        // FORMULÁRIO DE MOVIMENTAÇÃO
        // --------------------------------------------------

        // Cria o painel onde ficarão
        // os dados da movimentação.
        //
        // Estou utilizando GridBagLayout porque ele permite
        // organizar os campos em linhas e colunas.
        JPanel formulario =
                new JPanel(
                        new GridBagLayout()
                );


        // Define o fundo branco do formulário.
        formulario.setBackground(Color.WHITE);


        // Cria uma borda com título para identificar
        // a finalidade desse painel.
        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Dados da movimentação"
                )
        );


        // Cria o objeto responsável por controlar
        // a posição dos componentes no GridBagLayout.
        GridBagConstraints gbc =
                new GridBagConstraints();


        // Define o espaçamento entre os componentes.
        //
        // Os valores representam:
        // cima, esquerda, baixo e direita.
        gbc.insets =
                new Insets(8, 10, 8, 10);


        // Faz os componentes ocuparem
        // o espaço horizontal disponível.
        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        // Permite que os componentes da segunda coluna
        // recebam espaço extra quando a tela aumentar.
        gbc.weightx = 1;


        // --------------------------------------------------
        // TIPO DE MOVIMENTAÇÃO
        // --------------------------------------------------

        // Adiciona o campo que permite escolher
        // se a movimentação será uma entrada ou uma saída.
        adicionarCampo(
                formulario,
                gbc,
                0,
                "Tipo de movimentação:",
                new JComboBox<>(
                        new String[]{
                                "Entrada",
                                "Saída"
                        }
                )
        );


        // --------------------------------------------------
        // PRODUTO
        // --------------------------------------------------

        // Adiciona o campo para informar
        // o nome do produto.
        adicionarCampo(
                formulario,
                gbc,
                1,
                "Produto:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // CÓDIGO DO PRODUTO
        // --------------------------------------------------

        // Adiciona o campo para informar
        // o código do produto.
        adicionarCampo(
                formulario,
                gbc,
                2,
                "Código do produto:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // QUANTIDADE
        // --------------------------------------------------

        // Adiciona o campo para informar
        // a quantidade movimentada.
        adicionarCampo(
                formulario,
                gbc,
                3,
                "Quantidade:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // MOTIVO
        // --------------------------------------------------

        // Adiciona uma caixa de seleção para indicar
        // o motivo da movimentação.
        //
        // Alguns exemplos são compra, venda,
        // devolução, transferência e ajuste.
        adicionarCampo(
                formulario,
                gbc,
                4,
                "Motivo:",
                new JComboBox<>(
                        new String[]{
                                "Compra",
                                "Venda",
                                "Devolução de cliente",
                                "Devolução para fornecedor",
                                "Transferência",
                                "Ajuste"
                        }
                )
        );


        // --------------------------------------------------
        // DOCUMENTO RELACIONADO
        // --------------------------------------------------

        // Adiciona o campo para informar
        // algum documento relacionado à movimentação.
        adicionarCampo(
                formulario,
                gbc,
                5,
                "Documento relacionado:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // ORIGEM
        // --------------------------------------------------

        // Adiciona o campo que identifica
        // a origem da movimentação.
        adicionarCampo(
                formulario,
                gbc,
                6,
                "Origem:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // DESTINO
        // --------------------------------------------------

        // Adiciona o campo que identifica
        // o destino da movimentação.
        adicionarCampo(
                formulario,
                gbc,
                7,
                "Destino:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // RESPONSÁVEL
        // --------------------------------------------------

        // Adiciona o campo para informar
        // quem é o responsável pela movimentação.
        adicionarCampo(
                formulario,
                gbc,
                8,
                "Responsável:",
                new JTextField(20)
        );


        // --------------------------------------------------
        // OBSERVAÇÃO
        // --------------------------------------------------

        // Define a posição da linha da observação.
        gbc.gridx = 0;
        gbc.gridy = 9;


        // Aqui o peso da primeira coluna volta para zero,
        // pois o campo de observação ficará na segunda coluna.
        gbc.weightx = 0;


        // Adiciona o texto "Observação:".
        formulario.add(
                new JLabel("Observação:"),
                gbc
        );


        // Cria uma área de texto maior para permitir
        // que o usuário escreva uma observação.
        //
        // O primeiro número representa a quantidade
        // aproximada de linhas e o segundo a quantidade
        // aproximada de colunas.
        JTextArea observacao =
                new JTextArea(3, 20);


        // Permite que o texto passe automaticamente
        // para a próxima linha quando chegar ao limite.
        observacao.setLineWrap(true);


        // Faz a quebra de linha respeitar as palavras,
        // evitando cortar uma palavra no meio.
        observacao.setWrapStyleWord(true);


        // Move o componente para a segunda coluna.
        gbc.gridx = 1;


        // Permite que a área de observação ocupe
        // o espaço horizontal disponível.
        gbc.weightx = 1;


        // Coloca a área de texto dentro de um JScrollPane.
        //
        // Isso permite rolar o conteúdo caso seja
        // digitada uma observação maior.
        formulario.add(
                new JScrollPane(observacao),
                gbc
        );


        // --------------------------------------------------
        // BOTÕES
        // --------------------------------------------------

        // Cria um painel separado para os botões.
        //
        // FlowLayout será usado para colocar
        // os botões lado a lado.
        JPanel botoes =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );


        // Define a mesma cor de fundo da tela
        // para a área dos botões.
        botoes.setBackground(COR_FUNDO);


        // Cria o botão de cancelar.
        JButton cancelar =
                new JButton("Cancelar");


        // Cria o botão que será utilizado
        // para registrar a movimentação.
        JButton registrar =
                new JButton(
                        "Registrar movimentação"
                );


        // Define a cor do botão de registro.
        registrar.setBackground(COR_BOTAO);


        // Define a cor branca para o texto do botão.
        registrar.setForeground(Color.WHITE);


        // Adiciona o botão de cancelar
        // ao painel de botões.
        botoes.add(cancelar);


        // Adiciona o botão de registrar
        // ao painel de botões.
        botoes.add(registrar);


        // Coloca o formulário dentro de um JScrollPane.
        //
        // Assim, se o formulário ficar maior que
        // o espaço disponível, será possível rolar a tela.
        painel.add(
                new JScrollPane(formulario),
                BorderLayout.CENTER
        );


        // Coloca o painel dos botões na parte inferior.
        painel.add(
                botoes,
                BorderLayout.SOUTH
        );
    }


    // --------------------------------------------------
    // MÉTODO PARA ADICIONAR CAMPOS
    // --------------------------------------------------

    // Esse método foi criado para evitar repetir
    // o mesmo código várias vezes na criação
    // dos campos do formulário.
    //
    // Ele recebe:
    //
    // painel -> onde o campo será colocado;
    // gbc -> controla a posição do componente;
    // linha -> indica em qual linha ficará o campo;
    // texto -> texto que aparecerá no JLabel;
    // componente -> campo que será colocado na tela.
    private void adicionarCampo(
            JPanel painel,
            GridBagConstraints gbc,
            int linha,
            String texto,
            JComponent componente
    ) {


        // Define que o JLabel ficará
        // na primeira coluna.
        gbc.gridx = 0;


        // Define em qual linha o campo ficará.
        gbc.gridy = linha;


        // O JLabel não precisa ocupar
        // espaço extra horizontal.
        gbc.weightx = 0;


        // Adiciona o texto do campo.
        painel.add(
                new JLabel(texto),
                gbc
        );


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Permite que o componente do campo
        // ocupe o espaço horizontal disponível.
        gbc.weightx = 1;


        // Adiciona o componente recebido pelo método.
        //
        // Pode ser um JTextField, JComboBox
        // ou outro componente do Swing.
        painel.add(
                componente,
                gbc
        );
    }


    // Método que retorna o painel principal dessa tela.
    //
    // A classe TelaMovimentacaoRastreabilidade
    // utiliza esse método para colocar essa tela
    // dentro da aba "Entrada e Saída".
    public JPanel getPainel() {

        return painel;

    }
}