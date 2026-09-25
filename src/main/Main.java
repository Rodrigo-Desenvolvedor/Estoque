package main;

import javax.swing.SwingUtilities;
import view.TelaEstoque;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TelaEstoque telaEstoque = new TelaEstoque();
            telaEstoque.setVisible(true);
        });
    }
}
