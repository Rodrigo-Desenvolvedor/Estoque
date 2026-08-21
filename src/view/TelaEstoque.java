package view.estoque;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaEstoque extends JFrame {
	private final JTabbedPane abasEstoque = new JTabbedPane();
	private final Usuario usuario;
	
	public TelaEstoque(Usuario usuario) {
		/*é basicamente um titulo invisivel*/
		super("Sistema de Gestão de Estoque");
		this.usuario = usuario;
		montar();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(700,500));
		setSize(1200,800);
		setLocationRelativeTo(null);
		addWindowListener( new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					sair(); }
				}
			);
		}
	
	private void montar() {
		setJMenuBar(criarMenu());
		JPanel inicio = new JPanel(new GridBagLayout());
		JLabel texto = new JLabel("Seleciona uma função acima");
		texto.setFont(texto.getFont().deriveFont(Font.BOLD, 18f));
		inicio.add(texto);
		abasEstoque.addTab("Início",inicio);
		add(abasEstoque, BorderLayout.CENTER);
		JPanel rodape = new JPanel(new GridBagLayout());
		rodape.setBorder(BorderFactory.createEmptyBorder(4,8,4,8));
		rodape.add(new JLabel("Usuario: " + usuario.getNome() + " (" + usuario.getPerfil() + ")"), BorderLayout.WEST);
		rodape.add(new JLabel("Sistema Estoque - Java Desktop"), BorderLayout.EAST);
		add(rodape, BorderLayout.SOUTH);
	}
	
	private JMenuBar criarMenu() {
		JMenuBar barra = new JMenuBar();
		
		/*por enquanto deixei assim, mas vai mudar esta parte do JMenu*/
		JMenu cadastro = new JMenu("Cadastro"),
		movimentacao = new JMenu("Movimentacao"),
		inventario = new JMenu("Inventario"),
		automacao = new JMenu("Automacao"),
		relatorio = new JMenu("Relatorio"),
		sistema = new JMenu("Sistema");
		
		/*esta parte preciso de um pouco mais de informações para completar*/
		JMenuItem usuario = new JMenuItem();
		
		/*Precisa de muitas mudanças e das outras partes como model*/
		usuarios.setEnabled("ADMIN".equals(usuario.getPerfil()));
		cadastro.add(usuarios);
		
		JMenuItem sobre = new JMenuItem("Sobre");
		
		sair = new JMenuItem("Sair");
		sobre.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				          sair();
					}
				}
			);
		sistema.add(sobre);
		sistema.addSeparator();
		sistema.add(sair);
		barra.add(cadastro);
		barra.add(movimentacao);
		barra.add(inventario);
		barra.add(automacao);
		barra.add(relatorio);
		barra.add(sistema);
		return barra;
	}
	
	private JMenuItem Item(String titulo, final int modulo) {
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
	
	/*Vai ter mais mudanças esta parte*/
	private void abrirModulo(int modulo) {
	    String titulo;
	    JPanel painel;
	    if (modulo == 1) {
	    	titulo = "Cadastro";
	    	if (selecionar(titulo)) return;
	    	painel = new cadastro();
	    	} else if (modulo == 2) {
	    		titulo = "Movimentacao";
	    	if (selecionar(titulo)) return;
	    	painel = new movimentacao();
	    	} else if (modulo == 3) {
	    		titulo = "Inventario";
	    	if (selecionar(titulo)) return;
	    	painel = new inventario();
	    	} else if (modulo == 4) {
	    		titulo = "Automacao";
	    	if (selecionar(titulo)) return;
	    	painel = new automacao();
	    	} else (modulo == 5) {
	    		titulo = "Relatorio";
	    	if (selecionar(titulo)) return;
	    	painel = new relatorio();
	    	}
	    abrirAba(titulo, painel);
	}
	
	public void abrirAba(String titulo, JPanel painel) {
		int i = abasEstoque.indexOfTab(titulo);
	    if (i >= 0) {
	      abasEstoque.setSelectedIndex(i);
	      return;
	    }
	    abasEstoque.addTab(titulo, painel);
	    abasEstoque.setTabComponentAt(
	      abasEstoque.indexOfComponent(painel),
	      cabecalhoFechavel(titulo, painel)
	    );
	    abasEstoque.setSelectedComponent(painel);
	  }

	  private boolean selecionar(String titulo) {
	    int i = abasEstoque.indexOfTab(titulo);
	    if (i >= 0) {
	      abasEstoque.setSelectedIndex(i);
	      return true;
	    }
	    return false;
	}
	  
	  
	private JPanel cabecalhoFechavel(String titulo, final Component painel) {
		    JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
		    p.setOpaque(false);
		    p.add(new JLabel(titulo));
		    JButton fechar = new JButton("x");
		    fechar.setMargin(new Insets(0, 4, 0, 4));
		    fechar.setToolTipText("Fechar aba");
		    fechar.addActionListener(
		    new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        abasEstoque.remove(painel);
		        }
		     }
		 );
		 p.add(fechar);
		 return p;
	}
	
	
	private void sair() {
	    if (
	      JOptionPane.showConfirmDialog(
	        this,
	        "Deseja encerrar o sistema?",
	        "Sair",
	        JOptionPane.YES_NO_OPTION
	      ) == JOptionPane.YES_OPTION
	    ) {
	      dispose();
	      System.exit(0);
	    }
	  }
}