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
public class TelaLoteSerie extends JPanel {


	private static final long serialVersionUID = 1L;

	// Kit não tem lote nem número de série próprios
	// (o controle é feito nos produtos/SKUs que o compõem).
	// Para permitir kit nesta tela, troque para true.
	private static final boolean PERMITIR_KIT = false;

	// Cor de fundo da tela
	private final Color COR_FUNDO =
	        new Color(245, 247, 250);

	// Campos de pesquisa
	// Item pesquisado: produto ou variação (SKU)
	private SeletorItem seletorItem;
	private JComboBox<String> campoTipo;
	private JTextField campoLote;
	private JTextField campoSerie;
	private JTextField campoFabricacao;
	private JTextField campoValidade;
	private JTextField campoFornecedor;

	// Tabela de histórico
	private JTable tabela;
	private DefaultTableModel modeloTabela;

	public TelaLoteSerie() {

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
	    // ÁREA DE PESQUISA
	    // --------------------------------------------------

	    JPanel filtros =
	            new JPanel(new GridBagLayout());

	    filtros.setBackground(Color.WHITE);

	    filtros.setBorder(
	            BorderFactory.createTitledBorder(
	                    "Pesquisa de rastreabilidade"
	            )
	    );

	    GridBagConstraints gbc =
	            new GridBagConstraints();

	    gbc.insets =
	            new Insets(8, 10, 8, 10);

	    gbc.fill =
	            GridBagConstraints.HORIZONTAL;

	    // --------------------------------------------------
	    // ITEM (PRODUTO OU VARIAÇÃO/SKU)
	    // --------------------------------------------------

	    seletorItem =
	            new SeletorItem(PERMITIR_KIT);

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weightx = 0;

	    filtros.add(
	            new JLabel("Item:"),
	            gbc
	    );

	    gbc.gridx = 1;
	    gbc.gridwidth = 3;
	    gbc.weightx = 1;

	    filtros.add(
	            seletorItem,
	            gbc
	    );

	    gbc.gridwidth = 1;

	    // --------------------------------------------------
	    // TIPO
	    // --------------------------------------------------

	    campoTipo =
	            new JComboBox<>(
	                    new String[]{
	                            "Lote",
	                            "Número de Série"
	                    }
	            );

	    adicionarCampo(
	            filtros,
	            gbc,
	            1,
	            "Tipo:",
	            campoTipo
	    );

	    // --------------------------------------------------
	    // LOTE
	    // --------------------------------------------------

	    campoLote =
	            new JTextField(15);

	    adicionarCampo(
	            filtros,
	            gbc,
	            1,
	            "Lote:",
	            campoLote,
	            2
	    );

	    // --------------------------------------------------
	    // NÚMERO DE SÉRIE
	    // --------------------------------------------------

	    campoSerie =
	            new JTextField(15);

	    adicionarCampo(
	            filtros,
	            gbc,
	            2,
	            "Número de série:",
	            campoSerie
	    );

	    // --------------------------------------------------
	    // DATA DE FABRICAÇÃO
	    // --------------------------------------------------

	    campoFabricacao =
	            new JTextField(10);

	    adicionarCampo(
	            filtros,
	            gbc,
	            2,
	            "Data de fabricação:",
	            campoFabricacao,
	            2
	    );

	    // --------------------------------------------------
	    // DATA DE VALIDADE
	    // --------------------------------------------------

	    campoValidade =
	            new JTextField(10);

	    adicionarCampo(
	            filtros,
	            gbc,
	            3,
	            "Data de validade:",
	            campoValidade
	    );

	    // --------------------------------------------------
	    // FORNECEDOR
	    // --------------------------------------------------

	    campoFornecedor =
	            new JTextField(15);

	    adicionarCampo(
	            filtros,
	            gbc,
	            3,
	            "Fornecedor:",
	            campoFornecedor,
	            2
	    );

	    // --------------------------------------------------
	    // BOTÃO PESQUISAR
	    // --------------------------------------------------

	    JButton pesquisar =
	            new JButton("Pesquisar");

	    gbc.gridx = 3;
	    gbc.gridy = 4;
	    gbc.weightx = 0;

	    filtros.add(
	            pesquisar,
	            gbc
	    );

	    // Ação do botão pesquisar
	    pesquisar.addActionListener(
	            e -> pesquisar()
	    );

	    // --------------------------------------------------
	    // TABELA
	    // --------------------------------------------------

	    String[] colunas = {
	            "Data/Hora",
	            "Tipo do item",
	            "Código",
	            "Item",
	            "Movimento",
	            "Quantidade",
	            "Origem",
	            "Destino",
	            "Localização",
	            "Responsável"
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

	    // --------------------------------------------------
	    // HISTÓRICO
	    // --------------------------------------------------

	    JPanel historico =
	            new JPanel(
	                    new BorderLayout()
	            );

	    historico.setBackground(Color.WHITE);

	    historico.setBorder(
	            BorderFactory.createTitledBorder(
	                    "Histórico de rastreabilidade"
	            )
	    );

	    historico.add(
	            new JScrollPane(tabela),
	            BorderLayout.CENTER
	    );

	    // --------------------------------------------------
	    // ADICIONA OS COMPONENTES À TELA
	    // --------------------------------------------------

	    add(
	            filtros,
	            BorderLayout.NORTH
	    );

	    add(
	            historico,
	            BorderLayout.CENTER
	    );
	}

	/**
	 * Adiciona um campo na primeira posição
	 * do grupo de colunas.
	 */
	private void adicionarCampo(
	        JPanel painel,
	        GridBagConstraints gbc,
	        int linha,
	        String texto,
	        javax.swing.JComponent componente
	) {

	    adicionarCampo(
	            painel,
	            gbc,
	            linha,
	            texto,
	            componente,
	            0
	    );
	}

	/**
	 * Adiciona um campo permitindo definir
	 * a coluna onde ele será colocado.
	 */
	private void adicionarCampo(
	        JPanel painel,
	        GridBagConstraints gbc,
	        int linha,
	        String texto,
	        javax.swing.JComponent componente,
	        int coluna
	) {

	    // Coluna do JLabel
	    gbc.gridx = coluna;
	    gbc.gridy = linha;
	    gbc.weightx = 0;

	    painel.add(
	            new JLabel(texto),
	            gbc
	    );

	    // Coluna do componente
	    gbc.gridx = coluna + 1;
	    gbc.weightx = 1;

	    painel.add(
	            componente,
	            gbc
	    );
	}

	/**
	 * Realiza a pesquisa.
	 *
	 * Por enquanto apenas filtra visualmente
	 * os dados existentes na tabela.
	 *
	 * Posteriormente podemos conectar essa função
	 * ao banco de dados.
	 */
	private void pesquisar() {

	    // O item é opcional na pesquisa, mas se for informado
	    // o código precisa existir no cadastro.
	    if (!seletorItem.validar(this, false)) {
	        return;
	    }

	    CatalogoItens.Item item =
	            seletorItem.getItem();

	    // Por enquanto a tabela está vazia.
	    // Aqui futuramente será feita a consulta
	    // ao banco de dados.

	    JOptionPane.showMessageDialog(
	            this,
	            "Pesquisa realizada.\n\n"
	            + (item == null ? "" : "Item (" + item.getTipo() + "): "
	                    + item.descricao() + "\n\n")
	            + "Em breve esta função será conectada "
	            + "ao banco de dados.",
	            "Pesquisa",
	            JOptionPane.INFORMATION_MESSAGE
	    );
	}
	 public  JComboBox<String>  getcampoTipo() {
	        return campoTipo;
	    }

	    public JTextField getcampoLote() {
	        return  campoLote;
	    }

	    public  JTextField getcampoSerie() {
	        return campoSerie;
	    }

	    public JTextField getcampoFabricacao() {
	        return campoFabricacao;
	    }

	    public JTextField getcampoValidade() {
	        return campoValidade;
	    }

	    public JTextField getcampoFornecedor() {
	        return  campoFornecedor;
	    }

	    public JTable gettabela() {
	        return tabela;
	    }
	    public DefaultTableModel getModeloTabela() {
	        return modeloTabela;
	    }
}
