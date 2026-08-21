package br.com.estoque.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaPrincipal extends JFrame {

    private final JTabbedPane abas = new JTabbedPane();

    public TelaPrincipal() {

        super("ERP - Modulo Estoque");

        montar();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 650));
        setSize(1100, 760);
        setLocationRelativeTo(null);
    }

    private void montar() {

        setJMenuBar(criarMenu());

        JPanel inicio = new JPanel(new GridBagLayout());

        JLabel texto = new JLabel(
                "Selecione uma funcionalidade no menu acima."
        );

        texto.setFont(
                texto.getFont().deriveFont(Font.BOLD, 18f)
        );

        inicio.add(texto);

        abas.addTab("Inicio", inicio);

        add(abas, BorderLayout.CENTER);
    }

    private JMenuBar criarMenu() {

        JMenuBar barra = new JMenuBar();

        JMenu cadastros = new JMenu("Cadastros");

        JMenuItem produtos = item("Produtos", 1);
        JMenuItem variacoes = item("Variacoes", 2);
        JMenuItem kits = item("Kits", 3);

        cadastros.add(produtos);
        cadastros.add(variacoes);
        cadastros.add(kits);

        barra.add(cadastros);

        return barra;
    }

    private JMenuItem item(
            String titulo,
            final int modulo
    ) {

        JMenuItem item = new JMenuItem(titulo);

        item.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        abrirModulo(modulo);
                    }
                }
        );

        return item;
    }

    private void abrirModulo(int modulo) {

        String titulo;
        JPanel painel;

        if (modulo == 1) {

            titulo = "Produtos";

            if (selecionar(titulo)) return;

            painel = new TelaProdutos();

        } else if (modulo == 2) {

            titulo = "Variacoes";

            if (selecionar(titulo)) return;

            painel = new TelaVariacoes();

        } else {

            titulo = "Kits";

            if (selecionar(titulo)) return;

            painel = new TelaKits();
        }

        abrirAba(titulo, painel);
    }

    private boolean selecionar(String titulo) {

        int i = abas.indexOfTab(titulo);

        if (i >= 0) {

            abas.setSelectedIndex(i);

            return true;
        }

        return false;
    }

    public void abrirAba(
            String titulo,
            JPanel painel
    ) {

        int i = abas.indexOfTab(titulo);

        if (i >= 0) {

            abas.setSelectedIndex(i);

            return;
        }

        abas.addTab(titulo, painel);

        abas.setTabComponentAt(
                abas.indexOfComponent(painel),
                cabecalhoFechavel(titulo, painel)
        );

        abas.setSelectedComponent(painel);
    }

    private JPanel cabecalhoFechavel(
            String titulo,
            final Component painel
    ) {

        JPanel p = new JPanel(
                new FlowLayout(
                        FlowLayout.LEFT,
                        3,
                        0
                )
        );

        p.setOpaque(false);

        p.add(new JLabel(titulo));

        JButton fechar = new JButton("x");

        fechar.setMargin(
                new Insets(0, 4, 0, 4)
        );

        fechar.setToolTipText("Fechar aba");

        fechar.addActionListener(
                new ActionListener() {

                    public void actionPerformed(
                            ActionEvent e
                    ) {

                        abas.remove(painel);
                    }
                }
        );

        p.add(fechar);

        return p;
    }
}