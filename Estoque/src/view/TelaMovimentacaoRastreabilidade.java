package view;

// Importa todas as classes necessárias do Swing,
// que é a biblioteca que estou usando para criar a interface gráfica.
import javax.swing.*;

// Importa a classe que permite criar espaços/margens
// dentro dos componentes da tela.
import javax.swing.border.EmptyBorder;

// Importa classes do AWT, que são usadas principalmente
// para cores, fontes e organização dos componentes.
import java.awt.*;


// Classe responsável pela tela principal de
// Movimentação e Rastreabilidade do módulo de Estoque.
//
// Ela herda de JFrame, ou seja, essa classe representa
// uma janela do sistema.
public class TelaMovimentacaoRastreabilidade extends JFrame {

    // Define a cor principal que será utilizada no cabeçalho da tela.
    // Estou deixando uma cor mais escura para dar destaque ao título.
    private final Color COR_PRINCIPAL = new Color(33, 47, 61);

    // Define a cor de fundo da tela.
    // É uma cor clara para deixar a interface mais limpa.
    private final Color COR_FUNDO = new Color(245, 247, 250);


    // Construtor da tela.
    // Ele é executado quando crio um objeto dessa classe.
    public TelaMovimentacaoRastreabilidade() {

        // Define o título que aparece na parte superior da janela.
        setTitle("ERP - Movimentação e Rastreabilidade");

        // Define o tamanho da janela.
        // O primeiro valor é a largura e o segundo é a altura.
        setSize(1100, 700);

        // Faz a janela aparecer centralizada na tela.
        setLocationRelativeTo(null);

        // Define o que acontece quando o usuário fecha essa janela.
        // DISPOSE_ON_CLOSE fecha apenas essa tela,
        // sem necessariamente encerrar o sistema inteiro.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Chama o método responsável por montar todos
        // os componentes visuais da tela.
        criarTela();
    }


    // Método responsável por criar e organizar
    // os componentes da tela.
    private void criarTela() {

        // Cria o painel principal da janela.
        //
        // Estou usando BorderLayout para dividir a tela
        // em regiões, como Norte, Centro, Sul etc.
        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Define a cor de fundo do painel principal.
        painelPrincipal.setBackground(COR_FUNDO);


        // Cria o painel que será utilizado como cabeçalho.
        JPanel cabecalho = new JPanel(new BorderLayout());

        // Define a cor de fundo do cabeçalho.
        cabecalho.setBackground(COR_PRINCIPAL);

        // Cria uma margem interna no cabeçalho.
        //
        // Os valores representam:
        // cima, esquerda, baixo e direita.
        cabecalho.setBorder(new EmptyBorder(15, 20, 15, 20));


        // Cria o texto principal que será exibido no cabeçalho.
        JLabel titulo = new JLabel("Movimentação e Rastreabilidade");

        // Define a cor branca para o título.
        titulo.setForeground(Color.WHITE);

        // Define a fonte do título.
        // Estou usando Arial, negrito e tamanho 24.
        titulo.setFont(new Font("Arial", Font.BOLD, 24));


        // Cria um segundo texto abaixo do título.
        // Ele serve para indicar que essa tela faz parte
        // do controle de estoque.
        JLabel subtitulo = new JLabel("Controle de estoque");

        // Define a cor cinza clara para o subtítulo.
        titulo.setForeground(Color.WHITE);
        subtitulo.setForeground(Color.LIGHT_GRAY);

        // Define a fonte do subtítulo.
        // Nesse caso não uso negrito.
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 13));


        // Cria um painel para colocar o título e o subtítulo juntos.
        JPanel textos = new JPanel();

        // Utilizo BoxLayout para organizar os componentes
        // verticalmente, um abaixo do outro.
        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        // Deixa o fundo desse painel transparente,
        // para aparecer a cor do cabeçalho.
        textos.setOpaque(false);

        // Adiciona o título ao painel de textos.
        textos.add(titulo);

        // Cria um pequeno espaço vertical entre o título
        // e o subtítulo.
        textos.add(Box.createVerticalStrut(5));

        // Adiciona o subtítulo abaixo do título.
        textos.add(subtitulo);


        // Coloca o painel de textos no cabeçalho.
        //
        // WEST significa que ele ficará no lado esquerdo.
        cabecalho.add(textos, BorderLayout.WEST);


        // Adiciona o cabeçalho ao painel principal.
        //
        // NORTH faz com que o cabeçalho fique na parte superior.
        painelPrincipal.add(cabecalho, BorderLayout.NORTH);


        // Cria as abas que serão utilizadas para separar
        // as diferentes funcionalidades da tela.
        JTabbedPane abas = new JTabbedPane();


        // Primeira aba:
        // responsável pelo controle de entrada e saída
        // dos produtos no estoque.
        //
        // O método getPainel() pega o painel criado
        // pela classe TelaEntradaSaida.
        abas.addTab(
                "Entrada e Saída",
                new TelaEntradaSaida().getPainel()
        );


        // Segunda aba:
        // responsável pelo controle de lotes e números de série.
        abas.addTab(
                "Lote e Série",
                new TelaLoteSerie().getPainel()
        );


        // Terceira aba:
        // responsável pelo controle de produtos em diferentes
        // locais ou posições do estoque.
        abas.addTab(
                "Multilocalização",
                new TelaMultilocalizacao().getPainel()
        );


        // Define a fonte utilizada nos nomes das abas.
        // Estou usando Arial, negrito e tamanho 14.
        abas.setFont(new Font("Arial", Font.BOLD, 14));


        // Adiciona as abas no centro da tela.
        //
        // CENTER faz com que elas ocupem o espaço principal
        // que sobrou abaixo do cabeçalho.
        painelPrincipal.add(abas, BorderLayout.CENTER);


        // Define o painel principal como o conteúdo
        // que será exibido dentro da janela.
        setContentPane(painelPrincipal);
    }


    // Método principal do programa.
    //
    // É por ele que a tela pode ser executada diretamente.
    public static void main(String[] args) {

        // O SwingUtilities.invokeLater garante que a interface
        // gráfica seja criada e executada na thread correta do Swing.
        SwingUtilities.invokeLater(() -> {

            // Cria um objeto da tela de Movimentação
            // e Rastreabilidade.
            TelaMovimentacaoRastreabilidade tela =
                    new TelaMovimentacaoRastreabilidade();

            // Torna a janela visível para o usuário.
            tela.setVisible(true);
        });
    }
}