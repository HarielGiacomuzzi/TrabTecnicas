package Apresentacao;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class windowUserInsert extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldCNPJ;
	private JTextField textFieldEmail;
	private JTextField textFieldSenha;
	private ControlerUsuarios controler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowUserInsert frame = new windowUserInsert();
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
	public windowUserInsert() {
		controler = new ControlerUsuarios();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// add back button here				
			}
		});
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(16, 46, 61, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(16, 89, 61, 16);
		contentPane.add(lblCpf);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(16, 135, 61, 16);
		contentPane.add(lblCnpj);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(16, 175, 61, 16);
		contentPane.add(lblEmail);		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(16, 228, 61, 16);
		contentPane.add(lblSenha);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(107, 40, 134, 28);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(107, 83, 134, 28);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldCNPJ = new JTextField();
		textFieldCNPJ.setBounds(107, 129, 134, 28);
		contentPane.add(textFieldCNPJ);
		textFieldCNPJ.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(107, 169, 134, 28);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(107, 216, 134, 28);
		contentPane.add(textFieldSenha);
		
		JButton btnInsertuser = new JButton("Cadastrar");
		btnInsertuser.setBounds(6, 273, 117, 29);
		btnInsertuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Nome deve ser preenchido!");
				} else{
					boolean ok = controler.insertUsuario(textFieldNome.getText(), textFieldCPF.getText(), textFieldCNPJ.getText(), textFieldEmail.getText(), textFieldSenha.getText());
					if(ok){
						JOptionPane.showMessageDialog(null, "Usuario Cadastrado com Sucesso!");
					} 
				}
			}
		});
		contentPane.add(btnInsertuser);
		
		
		

		

	}
}
