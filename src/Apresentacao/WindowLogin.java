package Apresentacao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowLogin extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblSenha;
	private JTextField textField_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowLogin window = new WindowLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public WindowLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 66, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogin.setBounds(176, 11, 46, 28);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(93, 63, 207, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 114, 46, 14);
		contentPane.add(lblSenha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 111, 207, 20);
		contentPane.add(textField_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(131, 144, 125, 23);
		contentPane.add(btnEntrar);
		
		JButton btnNovoUsurio = new JButton("Novo Usuário");
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new windowUserInsert().show();
			}
		});
		btnNovoUsurio.setBounds(131, 186, 125, 23);
		contentPane.add(btnNovoUsurio);
		
		
	}
}
