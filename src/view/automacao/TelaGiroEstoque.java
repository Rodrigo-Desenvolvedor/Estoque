package telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaGiroEstoque extends JFrame {

    private DefaultTableModel modelo;

    public TelaGiroEstoque() {
        setTitle("Giro de Estoque");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel(
                "ANÁLISE DE GIRO DE ESTOQUE",
                SwingConstants.CENTER);
        titulo.setBorder( BorderFactory.createEmptyBorder(10, 0, 25, 0));
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        String[] colunas = {
                "Produto", "Vendas", "Estoque Médio",
                "Giro", "Classificação"
        };

        modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);

        JButton btnCalcular = new JButton("Calcular Giro");
        btnCalcular.addActionListener(e -> calcularGiro());

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel inferior = new JPanel();
        inferior.add(btnCalcular);
        add(inferior, BorderLayout.SOUTH);

        calcularGiro();
        setVisible(true);
    }

    private void calcularGiro() {
        modelo.setRowCount(0);

        adicionarProduto("Arroz", 100, 35 );
        adicionarProduto("Calabresa", 37, 20);
        adicionarProduto("Coca-Cola", 150, 30);
        adicionarProduto("Ovo", 80, 40);
    }

    private void adicionarProduto(String produto,
                                   double vendas,
                                   double estoqueMedio) {
        double giro = vendas / estoqueMedio;

        String classificacao;

        if (giro >= 4) {
            classificacao = "ALTO";
        } else if (giro >= 2) {
            classificacao = "MÉDIO";
        } else {
            classificacao = "BAIXO";
        }

        modelo.addRow(new Object[]{
                produto,
                vendas,
                estoqueMedio,
                String.format("%.2f", giro),
                classificacao
        });
    }
}
