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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowBemInsert extends JFrame {

	private JPanel contentPane;
	private JFrame backTo;
	private ControlerBens controler;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int idLeilao;
	private JTextField textField_3;

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
		this.controler = new ControlerBens(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.previousWindow(backTo);
			}
		});
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(18, 60, 61, 16);
		contentPane.add(lblCategoria);
		
		JLabel lblDescrioBreve = new JLabel("Descricao Breve");
		lblDescrioBreve.setBounds(18, 102, 117, 16);
		contentPane.add(lblDescrioBreve);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 96, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDescrioCompleta = new JLabel("Descrição Completa");
		lblDescrioCompleta.setBounds(18, 158, 134, 16);
		contentPane.add(lblDescrioCompleta);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(180, 158, 188, 94);
		contentPane.add(textArea);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(idLeilao);
				System.out.println(textField_1.getText());
				System.out.println(textArea.getText());
				System.out.println(textField_2.getText());
				controler.insertBem(idLeilao, textField_1.getText(), textArea.getText(), textField_2.getText(),Double.parseDouble(textField_3.getText()));
			}
		});
		btnInsert.setBounds(6, 223, 117, 29);
		contentPane.add(btnInsert);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 58, 134, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(338, 58, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(282, 61, 46, 14);
		contentPane.add(lblValor);
		
	}

	public void setBack(JFrame frame) {
		this.backTo = frame;
	}
	
	public void setIdLeilao(int i){
		this.idLeilao = i;
		
	}
}
