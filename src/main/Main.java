package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import view.TelaEstoque;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            TelaEstoque telaEstoque = new TelaEstoque();
            telaEstoque.setVisible(true);
        });
    }
}
