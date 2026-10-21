package view.suprimentos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TelaCompras extends JPanel {

    private static final long serialVersionUID = 1L;

    // cores da padronização visual
    private static final Color AZUL_MENU = new Color(27, 54, 93);
    private static final Color FUNDO = new Color(245, 247, 250);
    private static final Color BORDA = new Color(226, 232, 240);
    private static final Color TEXTO = new Color(30, 38, 52);

    // campos para os filtros
    private final JTextField idSolicitacaoFiltro = new JTextField(15);
    private final JTextField idPedidoFiltro = new JTextField(15);

    private final JComboBox<String> tipoItemFiltro = new JComboBox<String>(
        new String[] {
            "Todos",
            "Produto",
            "Variação",
            "Kit"
        }
    );

    private final JTextField codigoFiltro = new JTextField(20);
    private final JTextField fornecedorFiltro = new JTextField(20);

    private final JComboBox<String> situacaoFiltro = new JComboBox<String>(
        new String[] {
            "Todas",
            "Aprovada",
            "Pedido gerado",
            "Aguardando recebimento",
            "Recebido",
            "Cancelado"
        }
    );

    // modelo da tabela de solicitações aprovadas
    private final DefaultTableModel modeloSolicitacoes = new DefaultTableModel(
        new Object[] { "ID da Solicitação", "Tipo", "Código", "Item", "Quantidade aprovada", "Data da solicitação", "Situação" }, 0
    ) {
        public boolean isCellEditable(int l, int c) {
            return false;
        }
    };

    // cria a tabela a partir do modelo acima
    private final JTable tabelaSolicitacoes = new JTable(modeloSolicitacoes);

    // dados que vêm da solicitação aprovada
    private final JTextField idSolicitacao = new JTextField(15);
    private final JTextField tipoItem = new JTextField(15);
    private final JTextField codigo = new JTextField(20);
    private final JTextField item = new JTextField(20);
    private final JTextField quantidadeAprovada = new JTextField(15);

    // fornecedor escolhido pelo usuário
    private final JComboBox<String> fornecedor = new JComboBox<String>(
        new String[] {
            "Selecione um fornecedor"
        }
    );

    // dados do pedido de compra
    private final JTextField idPedido = new JTextField(15);
    private final JTextField dataPedido = new JTextField(15);
    private final JTextField situacaoPedido = new JTextField(20);

    // modelo da tabela de pedidos de compra
    private final DefaultTableModel modeloPedidos = new DefaultTableModel(
        new Object[] { "ID Pedido", "Fornecedor", "Tipo", "Código", "Item", "Quantidade", "Data", "Situação" }, 0
    ) {
        public boolean isCellEditable(int l, int c) {
            return false;
        }
    };

    // cria a tabela a partir do modelo acima
    private final JTable tabelaPedidos = new JTable(modeloPedidos);

    // construtor da tela
    public TelaCompras() {
        // organização principal da tela
        setLayout(new BorderLayout(8, 8));

        // margem ao redor da tela
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // cor de fundo
        setBackground(FUNDO);

        // monta os componentes
        montar();
    }

    // monta a parte visual da tela
    private void montar() {
        // título principal
        JLabel titulo = new JLabel("Compras / Pedido de Compra");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 20f));
        titulo.setForeground(AZUL_MENU);

        // painel com os filtros
        JPanel f = new JPanel(new GridBagLayout());
        f.setBackground(FUNDO);

        // borda e título do painel de filtros
        TitledBorder bordaFiltros = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Filtros");
        bordaFiltros.setTitleColor(TEXTO);
        f.setBorder(bordaFiltros);

        // configuração que organiza os campos do painel
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);

        // adiciona os campos de filtro
        componente(f, g, 0, "ID da Solicitação:", idSolicitacaoFiltro);
        componente(f, g, 1, "ID do Pedido:", idPedidoFiltro);
        componente(f, g, 2, "Tipo do item:", tipoItemFiltro);
        componente(f, g, 3, "Código:", codigoFiltro);
        componente(f, g, 4, "Fornecedor:", fornecedorFiltro);
        componente(f, g, 5, "Situação:", situacaoFiltro);

        // painel dos botões de filtro
        JPanel b = new JPanel(new FlowLayout(FlowLayout.LEFT));
        b.setBackground(FUNDO);

        JButton filtrar = new JButton("Filtrar");
        JButton limpar = new JButton("Limpar");

        // aplica o padrão visual aos botões
        configurarBotao(filtrar);
        configurarBotao(limpar);

        b.add(filtrar);
        b.add(limpar);

        // título, filtros e botões na parte superior
        JPanel n = new JPanel(new BorderLayout());
        n.setBackground(FUNDO);

        n.add(titulo, BorderLayout.NORTH);
        n.add(f, BorderLayout.CENTER);
        n.add(b, BorderLayout.SOUTH);

        // tabela com as solicitações aprovadas
        JPanel painelSolicitacoes = new JPanel(new BorderLayout());
        painelSolicitacoes.setBackground(FUNDO);

        TitledBorder bordaSolicitacoes = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Solicitações aprovadas");
        bordaSolicitacoes.setTitleColor(TEXTO);
        painelSolicitacoes.setBorder(bordaSolicitacoes);

        // configuração visual da tabela
        tabelaSolicitacoes.setForeground(TEXTO);
        tabelaSolicitacoes.setGridColor(BORDA);
        tabelaSolicitacoes.setSelectionBackground(AZUL_MENU);
        tabelaSolicitacoes.setSelectionForeground(Color.WHITE);

        // cor do cabeçalho da tabela
        tabelaSolicitacoes.getTableHeader().setBackground(AZUL_MENU);
        tabelaSolicitacoes.getTableHeader().setForeground(Color.WHITE);

        // permite selecionar uma única linha por vez
        tabelaSolicitacoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollSolicitacoes = new JScrollPane(tabelaSolicitacoes);
        scrollSolicitacoes.setBorder(BorderFactory.createLineBorder(BORDA));
        painelSolicitacoes.add(scrollSolicitacoes);

        // painel com os dados para gerar o pedido
        JPanel dadosPedido = new JPanel(new GridBagLayout());
        dadosPedido.setBackground(FUNDO);

        TitledBorder bordaDadosPedido = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Gerar Pedido de Compra");
        bordaDadosPedido.setTitleColor(TEXTO);
        dadosPedido.setBorder(bordaDadosPedido);

        GridBagConstraints gd = new GridBagConstraints();
        gd.insets = new Insets(4, 4, 4, 4);

        // dados vindos da solicitação aprovada
        componente(dadosPedido, gd, 0, "ID da Solicitação:", idSolicitacao);
        componente(dadosPedido, gd, 1, "Tipo do item:", tipoItem);
        componente(dadosPedido, gd, 2, "Código:", codigo);
        componente(dadosPedido, gd, 3, "Item:", item);
        componente(dadosPedido, gd, 4, "Quantidade aprovada:", quantidadeAprovada);

        // fornecedor é escolhido pelo usuário
        componente(dadosPedido, gd, 5, "Fornecedor:", fornecedor);

        // dados gerados para o pedido de compra
        componente(dadosPedido, gd, 6, "ID do Pedido de Compra:", idPedido);
        componente(dadosPedido, gd, 7, "Data do pedido:", dataPedido);
        componente(dadosPedido, gd, 8, "Situação:", situacaoPedido);

        // campos que não devem ser digitados manualmente
        idSolicitacao.setEditable(false);
        tipoItem.setEditable(false);
        codigo.setEditable(false);
        item.setEditable(false);
        quantidadeAprovada.setEditable(false);

        idPedido.setEditable(false);
        dataPedido.setEditable(false);
        situacaoPedido.setEditable(false);

        // botões para gerar ou cancelar a operação
        JPanel botoesPedido = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoesPedido.setBackground(FUNDO);

        JButton gerarPedido = new JButton("Gerar Pedido de Compra");
        JButton cancelar = new JButton("Limpar / Cancelar");

        configurarBotao(gerarPedido);
        configurarBotao(cancelar);

        botoesPedido.add(gerarPedido);
        botoesPedido.add(cancelar);

        // junta os dados do pedido e seus botões
        JPanel areaPedido = new JPanel(new BorderLayout());
        areaPedido.setBackground(FUNDO);

        areaPedido.add(dadosPedido, BorderLayout.CENTER);
        areaPedido.add(botoesPedido, BorderLayout.SOUTH);

        // tabela com os pedidos de compra
        JPanel painelPedidos = new JPanel(new BorderLayout());
        painelPedidos.setBackground(FUNDO);

        TitledBorder bordaPedidos = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Pedidos de Compra");
        bordaPedidos.setTitleColor(TEXTO);
        painelPedidos.setBorder(bordaPedidos);

        // configuração visual da tabela
        tabelaPedidos.setForeground(TEXTO);
        tabelaPedidos.setGridColor(BORDA);
        tabelaPedidos.setSelectionBackground(AZUL_MENU);
        tabelaPedidos.setSelectionForeground(Color.WHITE);

        // cor do cabeçalho da tabela
        tabelaPedidos.getTableHeader().setBackground(AZUL_MENU);
        tabelaPedidos.getTableHeader().setForeground(Color.WHITE);

        // permite selecionar uma única linha por vez
        tabelaPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPedidos = new JScrollPane(tabelaPedidos);
        scrollPedidos.setBorder(BorderFactory.createLineBorder(BORDA));
        painelPedidos.add(scrollPedidos);

        // botões relacionados aos pedidos existentes
        JPanel botoesTabela = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoesTabela.setBackground(FUNDO);

        JButton verDetalhes = new JButton("Ver Detalhes");
        JButton receberPedido = new JButton("Receber Pedido");

        configurarBotao(verDetalhes);
        configurarBotao(receberPedido);

        botoesTabela.add(verDetalhes);
        botoesTabela.add(receberPedido);
        painelPedidos.add(botoesTabela, BorderLayout.SOUTH);

        // organiza todas as áreas no centro da tela
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(FUNDO);

        painelSolicitacoes.setPreferredSize(new Dimension(800, 180));
        painelPedidos.setPreferredSize(new Dimension(800, 180));

        centro.add(painelSolicitacoes);
        centro.add(areaPedido);
        centro.add(painelPedidos);

        // rolagem da tela caso todos os componentes não caibam
        JScrollPane scrollTela = new JScrollPane(centro);
        scrollTela.setBorder(null);
        scrollTela.getVerticalScrollBar().setUnitIncrement(16);

        add(n, BorderLayout.NORTH);
        add(scrollTela, BorderLayout.CENTER);
    }

    // aplica o mesmo padrão visual aos botões
    private void configurarBotao(JButton botao) {
        botao.setBackground(AZUL_MENU);
        botao.setForeground(Color.WHITE);

        // retira o foco do botão (contorno)
        botao.setFocusPainted(false);
    }

    // método auxiliar que adiciona um label na esquerda do seu campo
    private void componente(JPanel p, GridBagConstraints g, int y, String r, Component t) {
        // texto do campo na coluna 0
        g.gridx = 0;
        g.gridy = y;
        g.weightx = 0;
        g.fill = GridBagConstraints.NONE;

        JLabel label = new JLabel(r);
        label.setForeground(TEXTO);
        p.add(label, g);

        // campo correspondente na coluna 1
        g.gridx = 1;
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;

        t.setForeground(TEXTO);
        p.add(t, g);
    }

    // permite que o Controller acesse os campos da tela
    public JTextField getTxtIdSolicitacaoFiltro() { 
    	return idSolicitacaoFiltro; 
    }
    
    public JTextField getTxtIdPedidoFiltro() { 
    	return idPedidoFiltro; 
    }
    
    public JComboBox<String> getCmbTipoItemFiltro() { 
    	return tipoItemFiltro; 
    }
    
    public JTextField getTxtCodigoFiltro() { 
    	return codigoFiltro; 
    }
    
    public JTextField getTxtFornecedorFiltro() { 
    	return fornecedorFiltro; 
    }
    
    public JComboBox<String> getCmbSituacaoFiltro() { 
    	return situacaoFiltro; 
    }
    
    public JTable getTabelaSolicitacoes() { 
    	return tabelaSolicitacoes; 
    }
    
    public JTextField getTxtIdSolicitacao() { 
    	return idSolicitacao; 
    }
    
    public JTextField getTxtTipoItem() { 
    	return tipoItem; 
    }
    
    public JTextField getTxtCodigo() { 
    	return codigo; 
    }
    
    public JTextField getTxtItem() { 
    	return item; 
    }
    
    public JTextField getTxtQuantidadeAprovada() { 
    	return quantidadeAprovada; 
    }
    
    public JComboBox<String> getCmbFornecedor() { 
    	return fornecedor; 
    }
    
    public JTextField getTxtIdPedido() { 
    	return idPedido; 
    }
    
    public JTextField getTxtDataPedido() { 
    	return dataPedido; 
    }
    
    public JTextField getTxtSituacaoPedido() { 
    	return situacaoPedido; 
    }
    
    public JTable getTabelaPedidos() { 
    	return tabelaPedidos; 
    }
    
    public DefaultTableModel getModeloSolicitacoes() { 
    	return modeloSolicitacoes; 
    }
    
    public DefaultTableModel getModeloPedidos() { 
    	return modeloPedidos; 
    }
}
