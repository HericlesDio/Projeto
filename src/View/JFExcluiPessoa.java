package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.Comercial;
import Controller.SisComException;
import Model.Cliente;
import Model.Fornecedor;
import utilitarios.Console;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;

public class JFExcluiPessoa extends JFrame {
	private static Comercial objComercial = new Comercial();


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nome;
	private String telefone;
	private String email;
	private String dataCadSTR;
	private Date dataCad = null;
	private String cnpj;
	private	String nomeContato;
	
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
	public JFExcluiPessoa() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(165, 5, 97, 21);
		panel.add(menuBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(267, 14, 2, 2);
		panel.add(scrollPane);

		 

}
}