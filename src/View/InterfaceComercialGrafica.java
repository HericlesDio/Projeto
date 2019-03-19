package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class InterfaceComercialGrafica extends JFrame {
	public InterfaceComercialGrafica() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		mnNewMenu.setBounds(0, 0, 107, 22);
		panel.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Vendedor");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Fornecedor");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Produto");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		this.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
