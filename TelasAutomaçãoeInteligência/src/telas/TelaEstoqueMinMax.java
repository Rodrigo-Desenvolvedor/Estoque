package telas;

import javax.swing.*;
import java.awt.*;

public class TelaEstoqueMinMax extends JFrame {

    private JTextField txtProduto;
    private JTextField txtAtual;
    private JTextField txtMinimo;
    private JTextField txtMaximo;
    private JLabel resultado;

    public TelaEstoqueMinMax() {


        setTitle("Estoque Mínimo e Máximo");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(
            BorderFactory.createEmptyBorder(25, 40, 25, 40));

        JLabel titulo = new JLabel("ESTOQUE MÍNIMO E MÁXIMO");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painel.add(titulo);
        painel.add(Box.createVerticalStrut(30));

        JPanel campos = new JPanel(
            new GridLayout(4,2, 10,15));

        JLabel labelProduto = new JLabel("Produto:");
        campos.add(labelProduto);
        txtProduto = new JTextField();
        txtProduto.setPreferredSize(
            new Dimension(300, 35));
        campos.add(txtProduto);
        JLabel labelAtual = new JLabel("Estoque atual:");
        campos.add(labelAtual);
        txtAtual = new JTextField();
        txtAtual.setPreferredSize(
            new Dimension(300, 35) );

        campos.add(txtAtual);
        JLabel labelMinimo = new JLabel("Estoque mínimo:");
        campos.add(labelMinimo);
        txtMinimo = new JTextField();
        txtMinimo.setPreferredSize(
            new Dimension(300, 35));
        campos.add(txtMinimo);
        JLabel labelMaximo = new JLabel("Estoque máximo:");
        campos.add(labelMaximo);

        txtMaximo = new JTextField();
        txtMaximo.setPreferredSize(
            new Dimension(300, 35));

        campos.add(txtMaximo);
        painel.add(campos);
        painel.add(Box.createVerticalStrut(30));
        JPanel painelBotoes = new JPanel(
            new FlowLayout(
                FlowLayout.CENTER, 20,0 ));

        JButton btnVerificar =
            new JButton("Verificar Estoque");
        btnVerificar.setPreferredSize(
            new Dimension(200, 40)
        );

        painelBotoes.add(btnVerificar);

        JButton btnLimpar =
            new JButton("Limpar");

        btnLimpar.setPreferredSize(
            new Dimension(200, 40));

        painelBotoes.add(btnLimpar);

        painel.add(painelBotoes);
        painel.add(Box.createVerticalStrut(25));


        resultado = new JLabel(" ");

        resultado.setAlignmentX(
            Component.CENTER_ALIGNMENT );

        painel.add(resultado);


        btnVerificar.addActionListener(
            e -> verificarEstoque());

        btnLimpar.addActionListener(e -> {

            txtProduto.setText("");
            txtAtual.setText("");
            txtMinimo.setText("");
            txtMaximo.setText("");

            resultado.setText(" ");
        });


        add(painel);

        setVisible(true);
    }


    private void verificarEstoque() {

        try {

            String produto =
                txtProduto.getText();

            int atual =
                Integer.parseInt(txtAtual.getText());

            int minimo =
                Integer.parseInt(txtMinimo.getText());

            int maximo =
                Integer.parseInt(txtMaximo.getText());

            if (atual < minimo) {

                int reposicao =
                    maximo - atual;

                resultado.setText(
                    "<html><font color='red'>" +
                    "ALERTA: " +
                    produto +
                    " está abaixo do mínimo.<br>" +
                    "Sugestão de reposição: " +
                    reposicao +
                    " unidades." +
                    "</font></html>");
           } else if (atual > maximo) {

                resultado.setText(
                    "<html><font color='orange'>" +
                    "Estoque acima do máximo." +
                    "</font></html>");

            } else {

                resultado.setText(
                    "<html><font color='green'>" +
                    "Estoque adequado." +
                    "</font></html>");
            }


        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Digite valores numéricos válidos.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}