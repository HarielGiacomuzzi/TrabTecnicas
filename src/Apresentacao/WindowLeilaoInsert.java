package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class WindowLeilaoInsert extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowLeilaoInsert frame = new WindowLeilaoInsert();
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
	public WindowLeilaoInsert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo Leilão");
		lblNewLabel.setBounds(22, 44, 78, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 40, 52, 27);
		contentPane.add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTipoLance = new JLabel("Tipo Lance");
		lblTipoLance.setBounds(22, 91, 78, 16);
		contentPane.add(lblTipoLance);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 87, 52, 27);
		contentPane.add(comboBox_1);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(25, 141, 75, 16);
		contentPane.add(lblDataInicio);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(161, 135, 68, 28);
		contentPane.add(formattedTextField);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(21, 192, 61, 16);
		contentPane.add(lblDataFim);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(161, 186, 68, 28);
		contentPane.add(formattedTextField_1);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(21, 236, 61, 16);
		contentPane.add(lblPreo);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(161, 230, 68, 28);
		contentPane.add(formattedTextField_2);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(267, 44, 61, 16);
		contentPane.add(lblVendedor);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(262, 72, 135, 27);
		contentPane.add(comboBox_2);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(327, 231, 117, 29);
		contentPane.add(btnInsert);
	}
}