package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowLeilaoView extends JFrame {

	private JPanel contentPane;
	private ControlerLeiloes controler;
	private JFrame backTo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowLeilaoView frame = new WindowLeilaoView();
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
	public WindowLeilaoView() {
		this.controler = new ControlerLeiloes(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.backToPrevious(backTo);
			}
		});
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblLeiloesAtivos = new JLabel("Leiloes Ativos");
		lblLeiloesAtivos.setBounds(6, 60, 117, 16);
		contentPane.add(lblLeiloesAtivos);
		
		JList list = new JList();
		list.setBounds(141, 60, 257, 183);
		contentPane.add(list);
		
		JButton btnInserirLance = new JButton("Inserir Lance");
		btnInserirLance.setBounds(6, 96, 117, 29);
		contentPane.add(btnInserirLance);
	}

	public void setBack(JFrame frame) {
		this.backTo = frame;
		
	}

}
