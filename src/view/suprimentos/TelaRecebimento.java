package view.suprimentos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TelaRecebimento extends JPanel {

    private static final long serialVersionUID = 1L;

    // cores da padronização visual
    private static final Color AZUL_MENU = new Color(27, 54, 93);
    private static final Color FUNDO = new Color(245, 247, 250);
    private static final Color BORDA = new Color(226, 232, 240);
    private static final Color TEXTO = new Color(30, 38, 52);

    // campos para os filtros
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
            "Aguardando recebimento",
            "Recebido",
            "Cancelado"
        }
    );

    // modelo da tabela de pedidos aguardando recebimento
    private final DefaultTableModel modeloPedidos = new DefaultTableModel(
        new Object[] { "ID Pedido", "Fornecedor", "Tipo", "Código", "Item", "Quantidade pedida", "Data do pedido", "Situação" }, 0
    ) {
        // impede que o usuário edite os campos da tabela diretamente
        public boolean isCellEditable(int l, int c) {
            return false;
        }
    };

    // cria a tabela a partir do modelo acima
    private final JTable tabelaPedidos = new JTable(modeloPedidos);

    // dados do pedido selecionado
    private final JTextField idPedido = new JTextField(15);
    private final JTextField fornecedor = new JTextField(20);
    private final JTextField tipoItem = new JTextField(15);
    private final JTextField codigo = new JTextField(20);
    private final JTextField item = new JTextField(20);
    private final JTextField quantidadeSolicitada = new JTextField(15);

    // campos da conferência
    private final JTextField quantidadeRecebida = new JTextField(15);

    private final JComboBox<String> localDestino = new JComboBox<String>(
        new String[] {
            "Selecione um local"
        }
    );

    private final JTextField documentoAquisicao = new JTextField(20);
    private final JTextField responsavel = new JTextField(20);

    // campos utilizados quando aplicáveis ao item
    private final JTextField lote = new JTextField(20);
    private final JTextField numeroSerie = new JTextField(20);
    private final JTextField dataFabricacao = new JTextField(15);
    private final JTextField dataValidade = new JTextField(15);

    // construtor da tela
    public TelaRecebimento() {
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
        JLabel titulo = new JLabel("Recebimento / Conferência");
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
        componente(f, g, 0, "ID do Pedido:", idPedidoFiltro);
        componente(f, g, 1, "Tipo do item:", tipoItemFiltro);
        componente(f, g, 2, "Código:", codigoFiltro);
        componente(f, g, 3, "Fornecedor:", fornecedorFiltro);
        componente(f, g, 4, "Situação:", situacaoFiltro);

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

        // painel com os pedidos aguardando recebimento
        JPanel painelPedidos = new JPanel(new BorderLayout());
        painelPedidos.setBackground(FUNDO);

        TitledBorder bordaPedidos = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Pedidos aguardando recebimento");
        bordaPedidos.setTitleColor(TEXTO);
        painelPedidos.setBorder(bordaPedidos);

        // configuração visual da tabela
        tabelaPedidos.setForeground(TEXTO);
        tabelaPedidos.setGridColor(BORDA);

        // cores da linha selecionada
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

        // painel com os dados do pedido selecionado
        JPanel dadosPedido = new JPanel(new GridBagLayout());
        dadosPedido.setBackground(FUNDO);

        TitledBorder bordaDadosPedido = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Dados do Pedido");
        bordaDadosPedido.setTitleColor(TEXTO);
        dadosPedido.setBorder(bordaDadosPedido);

        GridBagConstraints gp = new GridBagConstraints();
        gp.insets = new Insets(4, 4, 4, 4);

        componente(dadosPedido, gp, 0, "ID Pedido:", idPedido);
        componente(dadosPedido, gp, 1, "Fornecedor:", fornecedor);
        componente(dadosPedido, gp, 2, "Tipo do item:", tipoItem);
        componente(dadosPedido, gp, 3, "Código:", codigo);
        componente(dadosPedido, gp, 4, "Item:", item);
        componente(dadosPedido, gp, 5, "Quantidade solicitada:", quantidadeSolicitada);

        // dados do pedido são apenas para consulta
        idPedido.setEditable(false);
        fornecedor.setEditable(false);
        tipoItem.setEditable(false);
        codigo.setEditable(false);
        item.setEditable(false);
        quantidadeSolicitada.setEditable(false);

        // painel com os dados da conferência
        JPanel conferencia = new JPanel(new GridBagLayout());
        conferencia.setBackground(FUNDO);

        TitledBorder bordaConferencia = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Conferência");
        bordaConferencia.setTitleColor(TEXTO);
        conferencia.setBorder(bordaConferencia);

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(4, 4, 4, 4);

        // dados preenchidos durante o recebimento
        componente(conferencia, gc, 0, "Quantidade recebida:", quantidadeRecebida);
        componente(conferencia, gc, 1, "Local de destino:", localDestino);
        componente(conferencia, gc, 2, "Documento da aquisição:", documentoAquisicao);
        componente(conferencia, gc, 3, "Responsável:", responsavel);

        // campos usados somente quando o item exigir
        componente(conferencia, gc, 4, "Lote:", lote);
        componente(conferencia, gc, 5, "Número de série:", numeroSerie);
        componente(conferencia, gc, 6, "Data de fabricação:", dataFabricacao);
        componente(conferencia, gc, 7, "Data de validade:", dataValidade);

        // painel dos botões de recebimento
        JPanel a = new JPanel(new FlowLayout(FlowLayout.LEFT));
        a.setBackground(FUNDO);

        JButton confirmar = new JButton("Confirmar Recebimento");
        JButton cancelar = new JButton("Cancelar");

        configurarBotao(confirmar);
        configurarBotao(cancelar);

        a.add(confirmar);
        a.add(cancelar);

        // junta conferência e botões
        JPanel areaConferencia = new JPanel(new BorderLayout());
        areaConferencia.setBackground(FUNDO);

        areaConferencia.add(conferencia, BorderLayout.CENTER);
        areaConferencia.add(a, BorderLayout.SOUTH);

        // organiza as áreas principais da tela
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.setBackground(FUNDO);

        painelPedidos.setPreferredSize(new Dimension(800, 190));

        centro.add(painelPedidos);
        centro.add(dadosPedido);
        centro.add(areaConferencia);

        // rolagem caso os componentes não caibam na tela
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
    
    public JTable getTabelaPedidos() { 
    	return tabelaPedidos; 
    }
    
    public JTextField getTxtIdPedido() { 
    	return idPedido; 
    }
    
    public JTextField getTxtFornecedor() { 
    	return fornecedor; 
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
    
    public JTextField getTxtQuantidadeSolicitada() { 
    	return quantidadeSolicitada; 
    }
    
    public JTextField getTxtQuantidadeRecebida() { 
    	return quantidadeRecebida; 
    }
    
    public JComboBox<String> getCmbLocalDestino() { 
    	return localDestino; 
    }
    
    public JTextField getTxtDocumentoAquisicao() { 
    	return documentoAquisicao; 
    }
    
    public JTextField getTxtResponsavel() { 
    	return responsavel; 
    }
    
    public JTextField getTxtLote() { 
    	return lote; 
    }
    
    public JTextField getTxtNumeroSerie() { 
    	return numeroSerie; 
    }
    
    public JTextField getTxtDataFabricacao() { 
    	return dataFabricacao; 
    }
    
    public JTextField getTxtDataValidade() { 
    	return dataValidade; 
    }
    
    public DefaultTableModel getModeloPedidos() { 
    	return modeloPedidos; 
    }
}
