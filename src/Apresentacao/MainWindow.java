package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import business.FachadaException;
import business.LeilaoFachada;
import javax.swing.JList;
import javax.swing.JTable;

public class MainWindow {

	private JFrame frame;
	private LeilaoFachada leilaoFachada;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		leilaoFachada = LeilaoFachada.getInstance();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Leilões");
		btnNewButton_1.setBounds(147, 264, 123, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WindowLeilaoInsert().show();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Bens");
		btnNewButton_2.setBounds(288, 302, 107, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inser caadastro bens aqui
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnVisualizarLeiles = new JButton("Visualizar Leilões");
		btnVisualizarLeiles.setBounds(10, 302, 119, 23);
		btnVisualizarLeiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert ver leiloes aqui.f
			}
		});
		frame.getContentPane().add(btnVisualizarLeiles);
		
		JLabel lblLogadoComo = new JLabel("Logado como:");
		lblLogadoComo.setBounds(34, 11, 107, 14);
		frame.getContentPane().add(lblLogadoComo);
		
		JLabel lblNomeUsuar = new JLabel("New label");
		lblNomeUsuar.setBounds(119, 11, 123, 14);
		try {
			lblNomeUsuar.setText(leilaoFachada.getNomeUsuarioLogado());
		} catch (FachadaException e1) {
			
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		frame.getContentPane().add(lblNomeUsuar);
		
		JLabel lblLeiles = new JLabel("Leil\u00F5es");
		lblLeiles.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblLeiles);
		
		table = new JTable();
		table.setBounds(10, 61, 374, 192);
		frame.getContentPane().add(table);
		frame.setVisible(true);
	}
}
