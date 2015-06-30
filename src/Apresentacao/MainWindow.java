package Apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.JScrollPane;
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
	private ControlerPrincipal controler;
	private ControlerLeiloes controlerLeiloes;
	private JTable table_1;
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
		controlerLeiloes = new ControlerLeiloes();
		initialize();
		controler = new ControlerPrincipal(this.frame);
		
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
				controler.InsertLeilao();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Bens");
		btnNewButton_2.setBounds(289, 215, 107, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.insertBens();
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnVisualizarLeiles = new JButton("Visualizar Leilões");
		btnVisualizarLeiles.setBounds(10, 215, 119, 23);
		btnVisualizarLeiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.ViewLeilao();
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
		
		DefaultTableModel modelo = controlerLeiloes.getLeiloesTableModel();	
		JTable table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.setBounds(10, 61, 374, 142);
		/*
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(375, 61, -353, 137);
		frame.getContentPane().add(scrollPane);
		*/
		table_1 = new JTable();
		table_1.setModel(modelo);
		table_1.setBounds(34, 61, 329, 118);
		frame.getContentPane().add(table_1);
		frame.setVisible(true);
	}
}
