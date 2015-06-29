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

public class MainWindow {

	private JFrame frame;
	private LeilaoFachada leilaoFachada;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Leilões");
		btnNewButton_1.setBounds(149, 215, 123, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert cadastro leilao aqui
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Bens");
		btnNewButton_2.setBounds(289, 215, 107, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//inser caadastro bens aqui
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnVisualizarLeiles = new JButton("Visualizar Leilões");
		btnVisualizarLeiles.setBounds(10, 215, 119, 23);
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
		lblNomeUsuar.setBounds(119, 11, 46, 14);
		try {
			lblNomeUsuar.setText(leilaoFachada.getNomeUsuarioLogado());
		} catch (FachadaException e1) {
			
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		frame.getContentPane().add(lblNomeUsuar);
		frame.setVisible(true);
	}

}
