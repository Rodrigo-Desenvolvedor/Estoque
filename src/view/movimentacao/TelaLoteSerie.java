package view.movimentacao;

// Importa as classes do Swing que estou usando
// para criar os componentes da interface gráfica.
import javax.swing.*;

// Importa a classe utilizada para criar
// espaçamentos e margens nos painéis.
import javax.swing.border.EmptyBorder;

// Importa o modelo utilizado pela tabela
// para definir suas colunas e seus dados.
import javax.swing.table.DefaultTableModel;

// Importa classes do AWT, utilizadas principalmente
// para cores, layouts e espaçamentos.
import java.awt.*;


// Classe responsável pela tela de controle de Lote e Série.
public class TelaLoteSerie {


    // Define a cor de fundo utilizada na tela.
    private final Color COR_FUNDO =
            new Color(245, 247, 250);


    // Declara o painel principal da tela.
    //
    // Esse painel será retornado pelo método getPainel()
    // para ser colocado na aba "Lote e Série".
    private JPanel painel;


    // Construtor da classe.
    //
    // Quando a tela é criada, o método criarTela()
    // é chamado para montar todos os componentes.
    public TelaLoteSerie() {

        criarTela();

    }


    // Método responsável por criar e organizar
    // todos os elementos visuais da tela.
    private void criarTela() {


        // Cria o painel principal utilizando BorderLayout.
        //
        // Os valores 15, 15 definem o espaçamento
        // horizontal e vertical entre os componentes.
        painel = new JPanel(
                new BorderLayout(15, 15)
        );


        // Cria uma margem de 20 pixels
        // em todos os lados da tela.
        painel.setBorder(
                new EmptyBorder(20, 20, 20, 20)
        );


        // Define a cor de fundo do painel.
        painel.setBackground(COR_FUNDO);


        // --------------------------------------------------
        // ÁREA DE PESQUISA
        // --------------------------------------------------

        // Cria o painel onde ficarão os campos
        // utilizados para pesquisar informações
        // de rastreabilidade.
        //
        // Estou usando GridBagLayout porque preciso
        // organizar os campos em linhas e colunas.
        JPanel filtros =
                new JPanel(
                        new GridBagLayout()
                );


        // Define o fundo branco da área de pesquisa.
        filtros.setBackground(Color.WHITE);


        // Cria uma borda com título para deixar claro
        // qual é a função dessa área.
        filtros.setBorder(
                BorderFactory.createTitledBorder(
                        "Pesquisa de rastreabilidade"
                )
        );


        // Cria o objeto responsável por controlar
        // a posição dos componentes dentro do GridBagLayout.
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


        // --------------------------------------------------
        // CAMPO PRODUTO
        // --------------------------------------------------

        // Cria o texto que identifica
        // o campo do produto.
        JLabel produtoLabel =
                new JLabel("Produto:");


        // Cria o campo onde será informado
        // o produto que será pesquisado.
        JTextField produto =
                new JTextField(20);


        // --------------------------------------------------
        // CAMPO TIPO
        // --------------------------------------------------

        // Cria o texto que identifica
        // o tipo de rastreabilidade.
        JLabel tipoLabel =
                new JLabel("Tipo:");


        // Cria uma caixa de seleção.
        //
        // O usuário poderá escolher entre rastrear
        // por lote ou por número de série.
        JComboBox<String> tipo =
                new JComboBox<>(
                        new String[]{
                                "Lote",
                                "Número de Série"
                        }
                );


        // --------------------------------------------------
        // CAMPO LOTE
        // --------------------------------------------------

        // Cria o texto que identifica
        // o campo de lote.
        JLabel loteLabel =
                new JLabel("Lote:");


        // Cria o campo onde será informado
        // o número ou código do lote.
        JTextField lote =
                new JTextField(15);


        // --------------------------------------------------
        // CAMPO NÚMERO DE SÉRIE
        // --------------------------------------------------

        // Cria o texto que identifica
        // o número de série.
        JLabel serieLabel =
                new JLabel("Número de série:");


        // Cria o campo onde será informado
        // o número de série do produto.
        JTextField serie =
                new JTextField(15);


        // --------------------------------------------------
        // DATA DE FABRICAÇÃO
        // --------------------------------------------------

        // Cria o texto que identifica
        // a data de fabricação.
        JLabel fabricacaoLabel =
                new JLabel("Data de fabricação:");


        // Cria o campo onde será informada
        // a data de fabricação.
        JTextField fabricacao =
                new JTextField(10);


        // --------------------------------------------------
        // DATA DE VALIDADE
        // --------------------------------------------------

        // Cria o texto que identifica
        // a data de validade.
        JLabel validadeLabel =
                new JLabel("Data de validade:");


        // Cria o campo onde será informada
        // a data de validade.
        JTextField validade =
                new JTextField(10);


        // --------------------------------------------------
        // FORNECEDOR
        // --------------------------------------------------

        // Cria o texto que identifica
        // o campo do fornecedor.
        JLabel fornecedorLabel =
                new JLabel("Fornecedor:");


        // Cria o campo onde será informado
        // o fornecedor do produto.
        JTextField fornecedor =
                new JTextField(15);


        // --------------------------------------------------
        // PRIMEIRA LINHA
        // --------------------------------------------------

        // Define que o primeiro componente ficará
        // na primeira coluna e primeira linha.
        gbc.gridx = 0;
        gbc.gridy = 0;


        // Adiciona o texto "Produto:" na primeira coluna.
        filtros.add(
                produtoLabel,
                gbc
        );


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo de produto.
        filtros.add(
                produto,
                gbc
        );


        // Move para a terceira coluna.
        gbc.gridx = 2;


        // Adiciona o texto "Tipo:".
        filtros.add(
                tipoLabel,
                gbc
        );


        // Move para a quarta coluna.
        gbc.gridx = 3;


        // Adiciona a caixa de seleção do tipo.
        filtros.add(
                tipo,
                gbc
        );


        // --------------------------------------------------
        // SEGUNDA LINHA
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a segunda linha.
        gbc.gridx = 0;
        gbc.gridy = 1;


        // Adiciona o texto "Lote:".
        filtros.add(
                loteLabel,
                gbc
        );


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo de lote.
        filtros.add(
                lote,
                gbc
        );


        // Move para a terceira coluna.
        gbc.gridx = 2;


        // Adiciona o texto "Número de série:".
        filtros.add(
                serieLabel,
                gbc
        );


        // Move para a quarta coluna.
        gbc.gridx = 3;


        // Adiciona o campo de número de série.
        filtros.add(
                serie,
                gbc
        );


        // --------------------------------------------------
        // TERCEIRA LINHA
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a terceira linha.
        gbc.gridx = 0;
        gbc.gridy = 2;


        // Adiciona o texto da data de fabricação.
        filtros.add(
                fabricacaoLabel,
                gbc
        );


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo de fabricação.
        filtros.add(
                fabricacao,
                gbc
        );


        // Move para a terceira coluna.
        gbc.gridx = 2;


        // Adiciona o texto da data de validade.
        filtros.add(
                validadeLabel,
                gbc
        );


        // Move para a quarta coluna.
        gbc.gridx = 3;


        // Adiciona o campo de validade.
        filtros.add(
                validade,
                gbc
        );


        // --------------------------------------------------
        // QUARTA LINHA
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a quarta linha.
        gbc.gridx = 0;
        gbc.gridy = 3;


        // Adiciona o texto "Fornecedor:".
        filtros.add(
                fornecedorLabel,
                gbc
        );


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo de fornecedor.
        filtros.add(
                fornecedor,
                gbc
        );


        // Cria o botão que será utilizado
        // para realizar a pesquisa.
        JButton pesquisar =
                new JButton("Pesquisar");


        // Coloca o botão na quarta coluna.
        gbc.gridx = 3;


        // Adiciona o botão ao painel de filtros.
        filtros.add(
                pesquisar,
                gbc
        );


        // --------------------------------------------------
        // TABELA DE HISTÓRICO
        // --------------------------------------------------

        // Define os nomes das colunas da tabela.
        //
        // Essas colunas representam as principais
        // informações necessárias para acompanhar
        // a rastreabilidade do produto.
        String[] colunas = {
                "Data/Hora",
                "Produto",
                "Movimento",
                "Quantidade",
                "Origem",
                "Destino",
                "Localização",
                "Responsável"
        };


        // Cria o modelo da tabela.
        //
        // A tabela começa sem registros,
        // pois os dados serão adicionados posteriormente.
        DefaultTableModel modeloTabela =
                new DefaultTableModel(
                        new Object[][]{},
                        colunas
                );


        // Cria a tabela utilizando o modelo criado.
        JTable tabela =
                new JTable(modeloTabela);


        // Define a altura das linhas da tabela
        // para facilitar a visualização.
        tabela.setRowHeight(28);


        // Cria o painel responsável por apresentar
        // o histórico de rastreabilidade.
        JPanel historico =
                new JPanel(
                        new BorderLayout()
                );


        // Define o fundo branco do painel.
        historico.setBackground(Color.WHITE);


        // Cria uma borda com o título
        // "Histórico de rastreabilidade".
        historico.setBorder(
                BorderFactory.createTitledBorder(
                        "Histórico de rastreabilidade"
                )
        );


        // Coloca a tabela dentro de um JScrollPane.
        //
        // Isso permite que o usuário possa rolar
        // a tabela quando houver muitos registros.
        historico.add(
                new JScrollPane(tabela),
                BorderLayout.CENTER
        );


        // --------------------------------------------------
        // ORGANIZAÇÃO FINAL DA TELA
        // --------------------------------------------------

        // Coloca a área de pesquisa na parte superior
        // da tela.
        painel.add(
                filtros,
                BorderLayout.NORTH
        );


        // Coloca o histórico no centro da tela.
        //
        // Dessa forma, a tabela ocupa a maior parte
        // do espaço disponível.
        painel.add(
                historico,
                BorderLayout.CENTER
        );
    }


    // Retorna o painel principal dessa tela.
    //
    // Esse método é utilizado pela classe
    // TelaMovimentacaoRastreabilidade para colocar
    // essa tela dentro da aba "Lote e Série".
    public JPanel getPainel() {

        return painel;

    }
}