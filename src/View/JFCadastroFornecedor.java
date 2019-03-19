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

public class JFCadastroFornecedor extends JFrame {
	private static Comercial objComercial = new Comercial();


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
	public JFCadastroFornecedor() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setBounds(58, 11, 129, 27);
		panel.add(lblCadastroCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(23, 57, 46, 14);
		panel.add(lblNome);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome = textField.getText();
			}
		});
		textField.setBounds(79, 54, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CNPJ:");
		lblCpf.setBounds(23, 88, 46, 14);
		panel.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 cnpj = textField.getText();
			}
		});
		textField_1.setBounds(79, 85, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 telefone = textField.getText();
			}
		});
		textField_2.setBounds(79, 116, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email = textField.getText();
			}
		});
		textField_3.setBounds(79, 147, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dataCadSTR = textField.getText();
			}
		});
		textField_4.setBounds(79, 178, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 codigo = textField.getText();
			}
		});
		textField_5.setBounds(79, 210, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 nomeContato = textField.getText();
			}
		});
		textField_6.setBounds(79, 241, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(23, 119, 46, 14);
		panel.add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(23, 150, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(23, 181, 46, 14);
		panel.add(lblData);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(23, 213, 46, 14);
		panel.add(lblCodigo);
		
		JLabel lblLimiteCred = new JLabel("Nome contrato");
		lblLimiteCred.setBounds(23, 244, 59, 14);
		panel.add(lblLimiteCred);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn();	
			}
		});
		btnCadastrar.setBounds(335, 209, 89, 23);
		panel.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(293, 119, 46, 14);
		panel.add(lblNewLabel);

		 

}
	void btn() {
		textField.getText();
		textField_1.getText();
		textField_2.getText();
		textField_3.getText();
		textField_4.getText();
		textField_5.getText();
		textField_6.getText();
		try {

			System.out.println("Cadastro Cliente");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int code;
			
			code = Integer.parseInt(codigo);		

			try {
				dataCad = sdf.parse(dataCadSTR);
				System.out.println("Data valida");

			} catch (Exception ee) {
				System.out.println("Data inválida!!!");
				System.out.println(ee.getMessage());
			}
			Fornecedor fornecedores = new Fornecedor(code, nome, telefone, email, dataCad, cnpj, nomeContato);

			objComercial.inserirPessoa(fornecedores);

			System.out.println("Cadastro realizado com sucesso");

		} catch (SisComException ee) {
			System.out.println(ee.getMessage());
		}
		
	}
}