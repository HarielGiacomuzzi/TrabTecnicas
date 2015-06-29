package Apresentacao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField textFieldEmail;
	private JLabel lblSenha;
	private JTextField textFieldSenha;
	private ControlerUsuarios controler;
	
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
		controler = new ControlerUsuarios();
		
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
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(93, 63, 207, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 114, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(93, 111, 207, 20);
		contentPane.add(textFieldSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(131, 144, 125, 23);
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				boolean ok = controler.efetuaLogin(textFieldEmail.getText(), textFieldSenha.getText());
				if(ok){
					JOptionPane.showMessageDialog(null, "Login bem sucedido!");
					WindowLogin.this.dispose();
					new MainWindow();
				} else{
					JOptionPane.showMessageDialog(null, "Login inválido!");
				}
			}
		});
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
