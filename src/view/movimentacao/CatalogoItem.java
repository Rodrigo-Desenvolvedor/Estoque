package view.movimentacao;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.movimentacao.CatalogoItens.Item;
import view.movimentacao.CatalogoItens.TipoItem;


/**
 * Componente usado pelas telas de movimentação para escolher
 * o item que será movimentado.
 *
 * O usuário escolhe o TIPO do item (Produto, Variação/SKU ou Kit),
 * digita o CÓDIGO e o nome aparece automaticamente (somente leitura).
 * Também pode usar o botão "Buscar" para escolher em uma lista.
 *
 * Como usar na tela:
 *
 *     seletorItem = new SeletorItem(true);
 *     ...
 *     if (!seletorItem.validar(this, true)) {
 *         return;
 *     }
 *     CatalogoItens.Item item = seletorItem.getItem();
 */
public class CatalogoItem extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final Color COR_ERRO = new Color(192, 57, 43);

    private final JComboBox<TipoItem> campoTipo;
    private final JTextField campoCodigo = new JTextField(12);
    private final JTextField campoNome = new JTextField(20);
    private final JButton botaoBuscar = new JButton("Buscar");

    private final Color corTextoNormal = campoNome.getForeground();

    // Item encontrado para o código digitado (null se não existe).
    private Item itemSelecionado;


    /**
     * @param permitirKit false para esconder a opção "Kit"
     *                    (ex.: telas em que kit não faz sentido).
     */
    public CatalogoItem(boolean permitirKit) {

        TipoItem[] tipos = permitirKit
            ? TipoItem.values()
            : new TipoItem[] { TipoItem.PRODUTO, TipoItem.VARIACAO };

        campoTipo = new JComboBox<>(tipos);

        montar();
        atualizarDica();
    }


    private void montar() {

        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        campoNome.setEditable(false);

        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(0, 0, 4, 5);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridy = 0;

        // Linha 1: tipo | código | botão buscar
        g.gridx = 0;
        g.weightx = 0;
        add(campoTipo, g);

        g.gridx = 1;
        g.weightx = 1;
        add(campoCodigo, g);

        g.gridx = 2;
        g.weightx = 0;
        g.insets = new Insets(0, 0, 4, 0);
        add(botaoBuscar, g);

        // Linha 2: nome do item (preenchido sozinho)
        g.gridx = 0;
        g.gridy = 1;
        g.gridwidth = 3;
        g.weightx = 1;
        g.insets = new Insets(0, 0, 0, 0);
        add(campoNome, g);


        // Mudou o tipo: apaga o código e o nome
        campoTipo.addItemListener(e -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {

                campoCodigo.setText("");
                resolverCodigo();
                atualizarDica();
            }
        });

        // Enter no campo de código: procura o item
        campoCodigo.addActionListener(e -> resolverCodigo());

        // Saiu do campo de código: procura o item
        campoCodigo.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                resolverCodigo();
            }
        });

        botaoBuscar.addActionListener(e -> abrirBusca());
    }


    private void atualizarDica() {

        campoCodigo.setToolTipText(
            getTipoSelecionado().getDica()
        );
    }


    private TipoItem getTipoSelecionado() {
        return (TipoItem) campoTipo.getSelectedItem();
    }


    /**
     * Procura no catálogo o código digitado e
     * atualiza o nome na tela.
     */
    private void resolverCodigo() {

        String codigo = campoCodigo.getText().trim();

        campoNome.setForeground(corTextoNormal);

        if (codigo.isEmpty()) {

            itemSelecionado = null;
            campoNome.setText("");
            return;
        }

        itemSelecionado = CatalogoItens.buscar(
            getTipoSelecionado(),
            codigo
        );

        if (itemSelecionado == null) {

            campoNome.setForeground(COR_ERRO);
            campoNome.setText("Item não encontrado");
            return;
        }

        // Mostra o código no formato oficial (ex.: esc001 -> ESC001)
        campoCodigo.setText(itemSelecionado.getCodigo());
        campoNome.setText(itemSelecionado.getNome());
    }


    /**
     * Abre uma lista com os itens do tipo escolhido.
     */
    private void abrirBusca() {

        TipoItem tipo = getTipoSelecionado();

        List<Item> itens = CatalogoItens.listar(tipo);

        if (itens.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Não há itens cadastrados do tipo: "
                    + tipo.getRotulo(),
                "Buscar",
                JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        Item escolhido = (Item) JOptionPane.showInputDialog(
            this,
            "Selecione (" + tipo.getRotulo() + "):",
            "Buscar " + tipo.getRotulo().toLowerCase(),
            JOptionPane.QUESTION_MESSAGE,
            null,
            itens.toArray(),
            itens.get(0)
        );

        if (escolhido != null) {

            campoCodigo.setText(escolhido.getCodigo());
            resolverCodigo();
        }
    }


    /**
     * Confere se o item informado é válido.
     * Mostra a mensagem de erro para o usuário, se houver.
     *
     * @param pai         componente usado para centralizar a mensagem
     * @param obrigatorio true se o usuário precisa informar um item
     * @return true se está tudo certo; false se deve interromper
     */
    public boolean validar(Component pai, boolean obrigatorio) {

        resolverCodigo();

        String codigo = campoCodigo.getText().trim();
        TipoItem tipo = getTipoSelecionado();

        if (codigo.isEmpty()) {

            if (!obrigatorio) {
                return true;
            }

            JOptionPane.showMessageDialog(
                pai,
                "Informe o código do item (" + tipo.getRotulo() + ")"
                    + " ou use o botão Buscar.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            campoCodigo.requestFocus();

            return false;
        }

        if (itemSelecionado == null) {

            JOptionPane.showMessageDialog(
                pai,
                "Não existe " + tipo.getRotulo()
                    + " com o código \"" + codigo + "\".\n"
                    + "Confira o código ou use o botão Buscar.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            campoCodigo.requestFocus();

            return false;
        }

        return true;
    }


    /**
     * Item encontrado, ou null se nada foi informado
     * (ou se o código não existe).
     */
    public Item getItem() {
        return itemSelecionado;
    }


    public void limpar() {

        campoTipo.setSelectedIndex(0);
        campoCodigo.setText("");
        resolverCodigo();
    }


    public void focar() {
        campoCodigo.requestFocus();
    }
    public JComboBox<TipoItem> getcampoTipo() {
        return campoTipo;
    }

    public JTextField getcampoCodigo() {
        return campoCodigo;
    }

    public JTextField getcampoNome() {
        return campoNome;
    }

    public  JButton getbotaoBuscar() {
        return  botaoBuscar;
    }

    public Color getcorTextoNormal() {
        return corTextoNormal;
    }
}
