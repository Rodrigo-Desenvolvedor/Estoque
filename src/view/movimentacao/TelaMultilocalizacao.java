package view.movimentacao;

// Importa as classes do Swing que estou usando
// para criar os componentes da interface gráfica.
import javax.swing.*;

// Importa a classe usada para criar margens
// dentro dos painéis.
import javax.swing.border.EmptyBorder;

// Importa o modelo usado para criar e controlar
// os dados que aparecem na tabela.
import javax.swing.table.DefaultTableModel;

// Importa classes do AWT, utilizadas para
// layout, cores, espaçamentos e outros recursos visuais.
import java.awt.*;


// Classe responsável pela tela de Multilocalização.
public class TelaMultilocalizacao {


    // Define a cor de fundo que será utilizada
    // na tela.
    private final Color COR_FUNDO =
            new Color(245, 247, 250);


    // Declaro o painel principal da tela.
    //
    // Esse painel será retornado pelo método getPainel()
    // e colocado como uma das abas da tela principal.
    private JPanel painel;


    // Construtor da classe.
    //
    // Quando a classe for criada, o método criarTela()
    // será chamado para montar a interface.
    public TelaMultilocalizacao() {
        criarTela();
    }


    // Método responsável por criar todos os componentes
    // e organizar a tela de Multilocalização.
    private void criarTela() {


        // Cria o painel principal.
        //
        // Estou usando BorderLayout com espaçamento de 15
        // pixels entre as regiões.
        painel = new JPanel(
                new BorderLayout(15, 15)
        );

        // Adiciona uma margem de 20 pixels
        // em todos os lados do painel.
        painel.setBorder(
                new EmptyBorder(20, 20, 20, 20)
        );

        // Define a cor de fundo do painel.
        painel.setBackground(COR_FUNDO);


        // --------------------------------------------------
        // ÁREA DE PESQUISA DO PRODUTO
        // --------------------------------------------------

        // Cria um painel para colocar o campo
        // de pesquisa do produto e o botão.
        JPanel produtoPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT
                        )
                );

        // Define o fundo branco para esse painel.
        produtoPanel.setBackground(Color.WHITE);


        // Cria uma borda com título para identificar
        // a função dessa área.
        produtoPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Consulta de estoque por localização"
                )
        );


        // Adiciona o texto "Produto:" no painel.
        produtoPanel.add(
                new JLabel("Produto:")
        );


        // Cria o campo onde o usuário poderá
        // informar o produto que deseja pesquisar.
        //
        // O número 25 representa aproximadamente
        // a quantidade de colunas do campo.
        JTextField produto =
                new JTextField(25);


        // Adiciona o campo de produto ao painel.
        produtoPanel.add(produto);


        // Cria o botão que será utilizado
        // para realizar a pesquisa.
        JButton pesquisar =
                new JButton("Pesquisar");


        // Adiciona o botão ao painel.
        produtoPanel.add(pesquisar);


        // --------------------------------------------------
        // TABELA DE ESTOQUE POR LOCALIZAÇÃO
        // --------------------------------------------------

        // Define os nomes das colunas que serão
        // exibidas na tabela.
        //
        // Cada coluna representa uma informação
        // relacionada ao estoque.
        String[] colunas = {
                "Local",
                "Quantidade",
                "Lote",
                "Número de Série"
        };


        // Cria o modelo que será utilizado pela tabela.
        //
        // Nesse momento a tabela começa vazia,
        // porque os dados serão adicionados posteriormente.
        DefaultTableModel modeloTabela =
                new DefaultTableModel(
                        new Object[][]{},
                        colunas
                );


        // Cria a tabela utilizando o modelo
        // que foi criado anteriormente.
        JTable tabela =
                new JTable(modeloTabela);


        // Define a altura das linhas da tabela.
        tabela.setRowHeight(28);


        // Cria um painel para apresentar
        // o estoque separado por local.
        JPanel estoqueLocal =
                new JPanel(new BorderLayout());


        // Define o fundo branco desse painel.
        estoqueLocal.setBackground(Color.WHITE);


        // Cria uma borda com o título
        // "Estoque por local".
        estoqueLocal.setBorder(
                BorderFactory.createTitledBorder(
                        "Estoque por local"
                )
        );


        // Coloca a tabela dentro de um JScrollPane.
        //
        // Isso permite que o usuário possa rolar a tabela
        // caso existam muitos registros.
        estoqueLocal.add(
                new JScrollPane(tabela),
                BorderLayout.CENTER
        );


        // --------------------------------------------------
        // ÁREA DE TRANSFERÊNCIA ENTRE LOCAIS
        // --------------------------------------------------

        // Cria o painel responsável pela transferência
        // de produtos de um local para outro.
        //
        // Estou usando GridBagLayout porque preciso
        // organizar vários campos em linhas e colunas.
        JPanel transferencia =
                new JPanel(
                        new GridBagLayout()
                );


        // Define o fundo branco da área de transferência.
        transferencia.setBackground(Color.WHITE);


        // Cria uma borda com título para identificar
        // essa parte da tela.
        transferencia.setBorder(
                BorderFactory.createTitledBorder(
                        "Transferência entre locais"
                )
        );


        // Cria o objeto que controla a posição
        // dos componentes dentro do GridBagLayout.
        GridBagConstraints gbc =
                new GridBagConstraints();


        // Define o espaçamento entre os componentes.
        //
        // Os valores representam:
        // cima, esquerda, baixo e direita.
        gbc.insets =
                new Insets(7, 10, 7, 10);


        // Faz os componentes ocuparem horizontalmente
        // o espaço disponível.
        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        // Define que as colunas poderão receber
        // espaço extra quando a janela aumentar.
        gbc.weightx = 1;


        // --------------------------------------------------
        // ORIGEM E DESTINO
        // --------------------------------------------------

        // Define a coluna e a linha onde
        // o primeiro componente será colocado.
        gbc.gridx = 0;
        gbc.gridy = 0;


        // Adiciona o texto que identifica
        // o local de origem da transferência.
        transferencia.add(
                new JLabel("Origem:"),
                gbc
        );


        // Cria o campo onde será informado
        // o local de origem.
        JTextField origem =
                new JTextField(15);


        // Move para a próxima coluna.
        gbc.gridx = 1;


        // Adiciona o campo de origem.
        transferencia.add(
                origem,
                gbc
        );


        // Move para a terceira coluna.
        gbc.gridx = 2;


        // Adiciona o texto que identifica
        // o local de destino.
        transferencia.add(
                new JLabel("Destino:"),
                gbc
        );


        // Cria o campo onde será informado
        // o local de destino.
        JTextField destino =
                new JTextField(15);


        // Move para a quarta coluna.
        gbc.gridx = 3;


        // Adiciona o campo de destino.
        transferencia.add(
                destino,
                gbc
        );


        // --------------------------------------------------
        // PRODUTO E QUANTIDADE
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a segunda linha.
        gbc.gridx = 0;
        gbc.gridy = 1;


        // Adiciona o texto "Produto:".
        transferencia.add(
                new JLabel("Produto:"),
                gbc
        );


        // Cria o campo onde será informado
        // o produto que será transferido.
        JTextField produtoTransferencia =
                new JTextField(15);


        // Coloca o campo de produto na segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo ao painel.
        transferencia.add(
                produtoTransferencia,
                gbc
        );


        // Move para a terceira coluna.
        gbc.gridx = 2;


        // Adiciona o texto "Quantidade:".
        transferencia.add(
                new JLabel("Quantidade:"),
                gbc
        );


        // Cria o campo onde será informada
        // a quantidade que será transferida.
        JTextField quantidade =
                new JTextField(15);


        // Move para a quarta coluna.
        gbc.gridx = 3;


        // Adiciona o campo de quantidade.
        transferencia.add(
                quantidade,
                gbc
        );


        // --------------------------------------------------
        // LOTE E NÚMERO DE SÉRIE
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a terceira linha.
        gbc.gridx = 0;
        gbc.gridy = 2;


        // Adiciona o texto "Lote:".
        transferencia.add(
                new JLabel("Lote:"),
                gbc
        );


        // Cria o campo para informar
        // o lote do produto.
        JTextField lote =
                new JTextField(15);


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo de lote.
        transferencia.add(
                lote,
                gbc
        );


        // Move para a terceira coluna.
        gbc.gridx = 2;


        // Adiciona o texto "Nº de Série:".
        transferencia.add(
                new JLabel("Nº de Série:"),
                gbc
        );


        // Cria o campo para informar
        // o número de série do produto.
        JTextField serie =
                new JTextField(15);


        // Move para a quarta coluna.
        gbc.gridx = 3;


        // Adiciona o campo de número de série.
        transferencia.add(
                serie,
                gbc
        );


        // --------------------------------------------------
        // DOCUMENTO
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a quarta linha.
        gbc.gridx = 0;
        gbc.gridy = 3;


        // Adiciona o texto "Documento:".
        transferencia.add(
                new JLabel("Documento:"),
                gbc
        );


        // Cria o campo para informar
        // o documento relacionado à transferência.
        JTextField documento =
                new JTextField(15);


        // Move para a segunda coluna.
        gbc.gridx = 1;


        // Adiciona o campo de documento.
        transferencia.add(
                documento,
                gbc
        );


        // --------------------------------------------------
        // OBSERVAÇÃO
        // --------------------------------------------------

        // Volta para a primeira coluna
        // e vai para a quinta linha.
        gbc.gridx = 0;
        gbc.gridy = 4;


        // Adiciona o texto "Observação:".
        transferencia.add(
                new JLabel("Observação:"),
                gbc
        );


        // Cria o campo para adicionar
        // alguma observação sobre a transferência.
        JTextField observacao =
                new JTextField(15);


        // Coloca o campo na segunda coluna.
        gbc.gridx = 1;


        // Faz o campo ocupar três colunas.
        //
        // Dessa forma, o campo de observação
        // fica mais largo.
        gbc.gridwidth = 3;


        // Adiciona o campo de observação.
        transferencia.add(
                observacao,
                gbc
        );


        // --------------------------------------------------
        // BOTÃO DE TRANSFERÊNCIA
        // --------------------------------------------------

        // Cria o botão responsável por realizar
        // a transferência entre os locais.
        JButton transferir =
                new JButton(
                        "Realizar Transferência"
                );


        // Define a posição do botão.
        //
        // Ele ficará na quarta coluna.
        gbc.gridx = 3;

        // Vai para a sexta linha.
        gbc.gridy = 5;

        // Volta a ocupar apenas uma coluna.
        gbc.gridwidth = 1;


        // Adiciona o botão ao painel.
        transferencia.add(
                transferir,
                gbc
        );


        // --------------------------------------------------
        // ORGANIZAÇÃO DOS PAINÉIS NA TELA
        // --------------------------------------------------

        // Adiciona a área de pesquisa na parte superior
        // da tela.
        painel.add(
                produtoPanel,
                BorderLayout.NORTH
        );


        // Adiciona a tabela no centro da tela.
        //
        // Como está no CENTER, ela ocupa a maior
        // parte do espaço disponível.
        painel.add(
                estoqueLocal,
                BorderLayout.CENTER
        );


        // Adiciona a área de transferência
        // na parte inferior da tela.
        painel.add(
                transferencia,
                BorderLayout.SOUTH
        );
    }


    // Método que retorna o painel principal dessa tela.
    //
    // A classe TelaMovimentacaoRastreabilidade utiliza
    // esse método para colocar essa tela dentro
    // da aba "Multilocalização".
    public JPanel getPainel() {
        return painel;
    }
}