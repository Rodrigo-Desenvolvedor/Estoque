package view.suprimentos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TelaMRP extends JPanel {

    private static final long serialVersionUID = 1L;

    // cores da padronização visual
    private static final Color AZUL_MENU = new Color(27, 54, 93);
    private static final Color FUNDO = new Color(245, 247, 250);
    private static final Color BORDA = new Color(226, 232, 240);
    private static final Color TEXTO = new Color(30, 38, 52);
    private static final Color CINZA = Color.GRAY;

    // tipo do item para filtro
    private final JComboBox<String> tipoItem = new JComboBox<String>(
        new String[] {
            "Todos",
            "Produto",
            "Variação",
            "Kit"
        }
    );

    // código do item para filtro
    private final JTextField codigo = new JTextField(20);

    // lista de categorias para filtro
    private final JComboBox<String> categoria = new JComboBox<String>(
        new String[] {
            "Todas",
            "Eletrônicos",
            "Laboratório",
            "Equipamentos"
        }
    );

    // lista de status para filtro
    private final JComboBox<String> status = new JComboBox<String>(
        new String[] {
            "Todos",
            "Pendente",
            "Aprovado",
            "Recusado",
            "Sem ação"
        }
    );

    // campos sobre os detalhes da sugestão selecionada
    private final JTextField quantidadeSugerida = new JTextField(15);
    private final JTextField quantidadeReservada = new JTextField(15);
    private final JTextField quantidadeSolicitada = new JTextField(15);
    private final JTextField dataPrevista = new JTextField(15);
    private final JTextField responsavel = new JTextField(20);
    private final JTextArea justificativa = new JTextArea(3, 30);

    // modelo da tabela e nomes das colunas
    private final DefaultTableModel modelo = new DefaultTableModel(
        new Object[] { "Tipo", "Código", "Item", "Estoque atual", "Estoque mínimo", "Estoque máximo", "Lead time", "Sugestão", "Status" }, 0
    ) {
        // impede que o usuário edite os campos da tabela diretamente
        public boolean isCellEditable(int l, int c) {
            return false;
        }
    };

    // cria a tabela a partir do modelo acima
    private final JTable tabela = new JTable(modelo);

    // construtor da tela
    public TelaMRP() {
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
        JLabel titulo = new JLabel("Sugestões de Reposição - MRP");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 20f));
        titulo.setForeground(AZUL_MENU);

        // painel (adesivo) com os filtros
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
        componente(f, g, 0, "Tipo do item:", tipoItem);
        componente(f, g, 1, "Código:", codigo);
        componente(f, g, 2, "Categoria:", categoria);
        componente(f, g, 3, "Status:", status);

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

        add(n, BorderLayout.NORTH);

        // painel central com a tabela de sugestões
        JPanel c = new JPanel(new BorderLayout());
        c.setBackground(FUNDO);

        // borda e título do painel de sugestões
        TitledBorder bordaTabela = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Sugestões geradas pelo MRP");
        bordaTabela.setTitleColor(TEXTO);
        c.setBorder(bordaTabela);

        // configuração visual da tabela
        tabela.setForeground(TEXTO);
        tabela.setGridColor(BORDA);

        // as cores mudam quando a linha é selecionada
        tabela.setSelectionBackground(AZUL_MENU);
        tabela.setSelectionForeground(Color.WHITE);

        // cor do cabeçalho da tabela
        tabela.getTableHeader().setBackground(AZUL_MENU);
        tabela.getTableHeader().setForeground(Color.WHITE);

        // JScrollPane permite rolagem quando se têm muitas linhas
        JScrollPane scrollTabela = new JScrollPane(tabela);
        scrollTabela.setBorder(BorderFactory.createLineBorder(BORDA));

        c.add(scrollTabela);
        add(c, BorderLayout.CENTER);

        // permite selecionar uma única linha da tabela por vez
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // painel (adesivo) coms os detalhes da sugestão
        JPanel d = new JPanel(new GridBagLayout());
        d.setBackground(FUNDO);

        // borda e título do painel de detalhes
        TitledBorder bordaDetalhes = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(BORDA), "Detalhes da sugestão");
        bordaDetalhes.setTitleColor(TEXTO);
        d.setBorder(bordaDetalhes);

        GridBagConstraints gd = new GridBagConstraints();
        gd.insets = new Insets(4, 4, 4, 4);

        // campos de detalhes da sugestão
        componente(d, gd, 0, "Quantidade sugerida:", quantidadeSugerida);
        componente(d, gd, 1, "Quantidade reservada:", quantidadeReservada);
        componente(d, gd, 2, "Quantidade já solicitada/em pedido:", quantidadeSolicitada);
        componente(d, gd, 3, "Data prevista de reposição:", dataPrevista);
        componente(d, gd, 4, "Responsável:", responsavel);

        // a justificativa quebra de linha automaticamente (evita scroll horizontal); quebra entre palavras, não no meio delas
        justificativa.setLineWrap(true);
        justificativa.setWrapStyleWord(true);
        justificativa.setForeground(TEXTO);

        // acrescenta rolagem no campo de justificativa
        JScrollPane scrollJustificativa = new JScrollPane(justificativa);
        scrollJustificativa.setBorder(BorderFactory.createLineBorder(BORDA));

        componente(d, gd, 5, "Justificativa:", scrollJustificativa);

        // painel (adesivo) dos botões da sugestão
        JPanel a = new JPanel(new FlowLayout(FlowLayout.LEFT));
        a.setBackground(FUNDO);

        JButton aprovar = new JButton("Aprovar sugestão");
        JButton alterar = new JButton("Alterar quantidade");
        JButton recusar = new JButton("Recusar");
        JButton gerar = new JButton("Gerar solicitação");

        // padrão visual dos botões da sugestão
        configurarBotao(aprovar);
        configurarBotao(alterar);
        configurarBotao(recusar);
        configurarBotao(gerar);

        a.add(aprovar);
        a.add(alterar);
        a.add(recusar);
        a.add(gerar);

        // junta os detalhes e os botões na parte inferior da tela
        JPanel s = new JPanel(new BorderLayout());
        s.setBackground(FUNDO);

        s.add(d, BorderLayout.CENTER);
        s.add(a, BorderLayout.SOUTH);

        add(s, BorderLayout.SOUTH);
    }

    // getters dos campos para Controller
    public JComboBox<String> getCmbTipoItem() { 
    	return tipoItem; 
    }
    
    public JTextField getTxtCodigo() { 
    	return codigo; 
    }
    
    public JComboBox<String> getCmbCategoria() { 
    	return categoria; 
    }
    
    public JComboBox<String> getCmbStatus() { 
    	return status; 
    }
    
    public JTextField getTxtQuantidadeSugerida() { 
    	return quantidadeSugerida; 
    }
    
    public JTextField getTxtQuantidadeReservada() { 
    	return quantidadeReservada;
    }
    
    public JTextField getTxtQuantidadeSolicitada() { 
    	return quantidadeSolicitada; 
    }
    
    public JTextField getTxtDataPrevista() { 
    	return dataPrevista; 
    }
    
    public JTextField getTxtResponsavel() { 
    	return responsavel; 
    }
    
    public JTextArea getTxtJustificativa() { 
    	return justificativa; 
    }
    
    public JTable getTabela() { 
    	return tabela; 
    }
    

    // aplica o mesmo padrão visual aos botões
    private void configurarBotao(JButton botao) {
        botao.setBackground(AZUL_MENU);
        botao.setForeground(Color.WHITE);
        // retira o foco do botão (contorno)
        botao.setFocusPainted(false);
    }

    // método auxiliar que adiciona um label na esquerda do seu campo, no GridBagLayout
    // exemplo: componente(f, g, 0, "Tipo do item:", tipoItem);
    // f é o painel; g é a posição do gridBagLayout; 0 é a linha; "Tipo do item" é o texto do label; tipoItem é o campo à direita
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
}