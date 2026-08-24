package telas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TelaAlertaReposicao extends JFrame {

    private DefaultTableModel modelo;
    public TelaAlertaReposicao() {
        setTitle("Alerta de Reposição");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titulo = new JLabel(
                "PRODUTOS QUE NECESSITAM DE REPOSIÇÃO",
                SwingConstants.CENTER);
        titulo.setBorder( BorderFactory.createEmptyBorder(10, 0, 25, 0));
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        

        String[] colunas = {
                "Produto", "Estoque Atual", "Estoque Mínimo",
                "Estoque Máximo", "Reposição", "Status"
        };

        modelo = new DefaultTableModel(colunas, 0);
        JTable tabela = new JTable(modelo);

        JButton btnVerificar = new JButton("Verificar Estoque");
        btnVerificar.addActionListener(e -> carregarAlertas());

        add(titulo, BorderLayout.NORTH);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel inferior = new JPanel();
        inferior.add(btnVerificar);
        add(inferior, BorderLayout.SOUTH);

        carregarAlertas();
        setVisible(true);
    }

    private void carregarAlertas() {
        modelo.setRowCount(0);

        adicionarProduto("Arroz", 5, 10, 50);
        adicionarProduto("Calabresa", 18, 10, 40);
        adicionarProduto("Coca-Cola", 3, 5, 50);
        adicionarProduto("Ovo", 7, 8, 50);
    }

    private void adicionarProduto(String produto, int atual,
                                   int minimo, int maximo) {
        if (atual < minimo) {
            int reposicao = maximo - atual;

            modelo.addRow(new Object[]{
                    produto,
                    atual,
                    minimo,
                    maximo,
                    reposicao,
                    "REPOR ESTOQUE"
            });
        }
    }
}
