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
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.text.SimpleDateFormat;

public class WindowLeilaoInsert extends JFrame {

	private JPanel contentPane;
	private ControlerLeiloes controler;
	JComboBox comboBoxLance;
	JComboBox comboBoxLeilao;
	private JFormattedTextField formattedTextFieldDataFim;
	private JFormattedTextField formattedTextFieldDataIni;
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
		controler = new ControlerLeiloes();
		setTitle("Cadastro de Leil„o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo Leil√£o");
		lblNewLabel.setBounds(22, 44, 78, 16);
		contentPane.add(lblNewLabel);
		
		String[] tipos = {"Oferta","Demanda"};
		
		comboBoxLeilao = new JComboBox(tipos);
		comboBoxLeilao.setBounds(161, 40, 96, 27);
		contentPane.add(comboBoxLeilao);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTipoLance = new JLabel("Tipo Lance");
		lblTipoLance.setBounds(22, 91, 78, 16);
		contentPane.add(lblTipoLance);
		
		String[] lances = {"Aberto","Fechado"};
		
		comboBoxLance = new JComboBox(lances);
		comboBoxLance.setBounds(161, 87, 96, 27);
		contentPane.add(comboBoxLance);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(25, 141, 75, 16);
		contentPane.add(lblDataInicio);
		
		formattedTextFieldDataIni = new JFormattedTextField();
		formattedTextFieldDataIni.setBounds(161, 135, 68, 28);
		contentPane.add(formattedTextFieldDataIni);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(21, 192, 61, 16);
		contentPane.add(lblDataFim);
		
		formattedTextFieldDataFim = new JFormattedTextField();
		formattedTextFieldDataFim.setBounds(161, 186, 68, 28);
		contentPane.add(formattedTextFieldDataFim);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(327, 231, 117, 29);
		btnInsert.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String dataIni = formattedTextFieldDataIni.getText();
				String dataFim = formattedTextFieldDataFim.getText();
				try{
				Date dateIni;
				Date dateFim;
				
					dateIni = formatter.parse(dataIni);
					dateFim = formatter.parse(dataFim);
				
					
				
				
				int id = controler.getIdUsuarioLogado();
				boolean ok = controler.insertLeilao((String)comboBoxLeilao.getSelectedItem(), (String)comboBoxLance.getSelectedItem(), dateIni, dateFim, id, 0.0);
				if(ok){
					JOptionPane.showMessageDialog(null, "Leilao Cadastrado com Sucesso!");
				}
				} catch(Exception ex){
				}
			}
		});
		contentPane.add(btnInsert);
	}
}
