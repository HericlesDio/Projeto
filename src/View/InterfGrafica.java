package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.SisComException;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class InterfGrafica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfGrafica frame = new InterfGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InterfGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new JFCadastroCliente().setVisible(true); 
			}
		});
		mnCadastro.add(mntmCliente);

		JMenuItem mntmVendedor = new JMenuItem("Vendedor");
		mntmVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFCadastroVendedor().setVisible(true); 
			}
		});
		mnCadastro.add(mntmVendedor);

		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFCadastroFornecedor().setVisible(true); 
			}
		});
		mnCadastro.add(mntmFornecedor);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFCadastroProduto().setVisible(true); 
			}
		});
		mnCadastro.add(mntmProduto);

		JMenu mnExcluir = new JMenu("Excluir");
		menuBar.add(mnExcluir);

		JMenuItem mntmClientefornecedorvendedor = new JMenuItem("Cliente/Fornecedor/Vendedor");
		mntmClientefornecedorvendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFExcluiPessoa().setVisible(true);
			}
		});
		mnExcluir.add(mntmClientefornecedorvendedor);

		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mntmProduto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFExcluiProduto().setVisible(true);
			}
		});
		mnExcluir.add(mntmProduto_1);

		JMenuItem mntmCompra = new JMenuItem("Compra");
		mntmCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFExcluiCompra().setVisible(true);
			}
		});
		mnExcluir.add(mntmCompra);

		JMenuItem mntmVenda = new JMenuItem("Venda");
		mntmVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFExcluiVenda().setVisible(true);
			}
		});
		mnExcluir.add(mntmVenda);

		JMenu mnComprasvendas = new JMenu("Compras/Vendas");
		menuBar.add(mnComprasvendas);

		JMenuItem mntmCompraDeFornecedor = new JMenuItem("Compra de Fornecedor");
		mntmCompraDeFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            new JFCompraFornecedor().setVisible(true);
			        } catch (SisComException ee) {
			        	
			        }
			}
		});
		mnComprasvendas.add(mntmCompraDeFornecedor);

		JMenuItem mntmVendaParaCliente = new JMenuItem("Venda para Cliente");
		mntmVendaParaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFVendasCliente().setVisible(true);
			}
		});
		mnComprasvendas.add(mntmVendaParaCliente);

		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);

		JMenuItem mntmConsultarCliente = new JMenuItem("Consultar Cliente");
		mntmConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnConsultas.add(mntmConsultarCliente);

		JMenuItem mntmConsultarVendedor = new JMenuItem("Consultar Vendedor");
		mntmConsultarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFConsultarVendedor().setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarVendedor);

		JMenuItem mntmConsultarFornecedor = new JMenuItem("Consultar Fornecedor");
		mntmConsultarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFConsultarFornecedor().setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarFornecedor);

		JMenuItem mntmConsultarProduto = new JMenuItem("Consultar Produto");
		mntmConsultarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFConsultarProduto().setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarProduto);

		JMenuItem mntmConsultarCompra = new JMenuItem("Consultar Compra");
		mntmConsultarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFConsultarCompra().setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarCompra);

		JMenuItem mntmConsultarVenda = new JMenuItem("Consultar Venda");
		mntmConsultarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new JFConsultarVenda().setVisible(true);
			}
		});
		mnConsultas.add(mntmConsultarVenda);

}
}
