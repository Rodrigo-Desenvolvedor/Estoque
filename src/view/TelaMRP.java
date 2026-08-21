package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;




public class TelaMRP extends JPanel {

    private static final long serialVersionUID = 1L;

    private final JTextField produto = new JTextField(20);

    private final JComboBox<String> categoria = new JComboBox<String>(
        new String[] {
            "Todas",
            "Eletrônicos",
            "Laboratório",
            "Equipamentos"
        }
    );

    private final JComboBox<String> status = new JComboBox<String>(
        new String[] {
            "Todos",
            "Pendente",
            "Aprovado",
            "Recusado",
            "Sem ação"
        }
    );
    
    private final JTextField quantidadeSugerida = new JTextField(15);
    private final JTextField dataPrevista = new JTextField(15);
    private final JTextField responsavel = new JTextField(20);
    private final JTextArea justificativa = new JTextArea(3, 30);
    
    
    private final DefaultTableModel modelo = new DefaultTableModel(
    	    new Object[] { "Item", "Estoque atual", "Estoque mínimo", "Lead time", "Sugestão", "Status" },
    	    0
    	  ) {
    	    public boolean isCellEditable(int l, int c) {
    	      return false;
    	    }
    	  };
    	  private final JTable tabela = new JTable(modelo);
    	  
    

    public TelaMRP() {
    	setLayout(new BorderLayout(8, 8));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        montar();
        preencherDadosExemplo();
        preencherDetalhesExemplo();
    }

    private void montar() {
        JLabel titulo = new JLabel("Sugestões de Reposição - MRP");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 20f));

        JPanel f = new JPanel(new GridBagLayout());
        f.setBorder(BorderFactory.createTitledBorder("Filtros"));

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 4, 4, 4);

        componente(f, g, 0, "Produto:", produto);
        componente(f, g, 1, "Categoria:", categoria);
        componente(f, g, 2, "Status:", status);

        JPanel b = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton filtrar = new JButton("Filtrar");
        JButton limpar = new JButton("Limpar");

        b.add(filtrar);
        b.add(limpar);

        JPanel n = new JPanel(new BorderLayout());
        n.add(titulo, BorderLayout.NORTH);
        n.add(f, BorderLayout.CENTER);
        n.add(b, BorderLayout.SOUTH);

        add(n, BorderLayout.NORTH);
        
        JPanel c = new JPanel(new BorderLayout());
        c.setBorder(BorderFactory.createTitledBorder("Sugestões geradas pelo MRP"));
        c.add(new JScrollPane(tabela));

        add(c, BorderLayout.CENTER);

        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        
        JPanel d = new JPanel(new GridBagLayout());
        d.setBorder(BorderFactory.createTitledBorder("Detalhes da sugestão"));

        GridBagConstraints gd = new GridBagConstraints();
        gd.insets = new Insets(4, 4, 4, 4);

        componente(d, gd, 0, "Quantidade sugerida:", quantidadeSugerida);
        componente(d, gd, 1, "Data prevista de reposição:", dataPrevista);
        componente(d, gd, 2, "Responsável:", responsavel);

        justificativa.setLineWrap(true);
        justificativa.setWrapStyleWord(true);

        componente(d, gd, 3, "Justificativa:", new JScrollPane(justificativa));

        JPanel a = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton aprovar = new JButton("Aprovar sugestão");
        JButton alterar = new JButton("Alterar quantidade");
        JButton recusar = new JButton("Recusar");
        JButton gerar = new JButton("Gerar solicitação");

        a.add(aprovar);
        a.add(alterar);
        a.add(recusar);
        a.add(gerar);

        JPanel s = new JPanel(new BorderLayout());
        s.add(d, BorderLayout.CENTER);
        s.add(a, BorderLayout.SOUTH);

        add(s, BorderLayout.SOUTH);
    }
    
    private void preencherDadosExemplo() {
        modelo.setRowCount(0);

        modelo.addRow(new Object[] {
            "Cabo HDMI",
            "3",
            "10",
            "5 dias",
            "Comprar 7",
            "Pendente"
        });

        modelo.addRow(new Object[] {
            "Kit Arduino",
            "2",
            "8",
            "10 dias",
            "Comprar 6",
            "Pendente"
        });

        modelo.addRow(new Object[] {
            "Mouse USB",
            "15",
            "10",
            "3 dias",
            "Sem ação",
            "OK"
        });

        modelo.addRow(new Object[] {
            "Projetor",
            "1",
            "3",
            "7 dias",
            "Comprar 2",
            "Pendente"
        });
    }
    
    
    private void preencherDetalhesExemplo() {
        quantidadeSugerida.setText("Comprar 7 unidades");
        dataPrevista.setText("25/08/2026");
        responsavel.setText("Almoxarifado");

        justificativa.setText(
            "O estoque atual está abaixo do estoque mínimo definido para o item."
        );
    }
    

    private void componente(
        JPanel p,
        GridBagConstraints g,
        int y,
        String r,
        Component t
    ) {
        g.gridx = 0;
        g.gridy = y;
        g.weightx = 0;
        g.fill = GridBagConstraints.NONE;
        p.add(new JLabel(r), g);

        g.gridx = 1;
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        p.add(t, g);
    }
}