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

public class windowUserInsert extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		textField = new JTextField();
		textField.setBounds(107, 40, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 83, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 129, 134, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(107, 169, 134, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnInsertuser = new JButton("InsertUser");
		btnInsertuser.setBounds(6, 214, 117, 29);
		contentPane.add(btnInsertuser);
	}
}
