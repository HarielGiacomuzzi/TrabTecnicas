package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class WindowBemInsert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBemInsert frame = new WindowBemInsert();
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
	public WindowBemInsert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(18, 60, 61, 16);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 56, 52, 27);
		contentPane.add(comboBox);
		
		JLabel lblDescrioBreve = new JLabel("Descrição Breve");
		lblDescrioBreve.setBounds(18, 102, 117, 16);
		contentPane.add(lblDescrioBreve);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 96, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDescrioCompleta = new JLabel("Descrição Completa");
		lblDescrioCompleta.setBounds(18, 158, 134, 16);
		contentPane.add(lblDescrioCompleta);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(180, 158, 188, 94);
		contentPane.add(textArea);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(6, 223, 117, 29);
		contentPane.add(btnInsert);
		
	}
}