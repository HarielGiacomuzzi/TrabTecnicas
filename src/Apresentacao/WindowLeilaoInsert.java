package Apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import business.LeilaoFachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WindowLeilaoInsert extends JFrame {

	private JPanel contentPane;
	private JFrame backTo;
	private ControlerLeiloes controler;
	private LeilaoFachada fachada;
	
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
	 * @return 
	 */
	
	public void setBack(JFrame backFrame){
		this.backTo = backFrame;
	}
	
	public WindowLeilaoInsert() {
		this.controler = new ControlerLeiloes(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo Leilão");
		lblNewLabel.setBounds(22, 44, 78, 16);
		contentPane.add(lblNewLabel);
		
		String[] tipos = {"Oferta","Demanda"};
		
		JComboBox comboBoxLeilao = new JComboBox(tipos);
		comboBoxLeilao.setBounds(161, 40, 96, 27);
		contentPane.add(comboBoxLeilao);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.backToPrevious(backTo);
			}
		});
		btnBack.setBounds(6, 6, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblTipoLance = new JLabel("Tipo Lance");
		lblTipoLance.setBounds(22, 91, 78, 16);
		contentPane.add(lblTipoLance);
		
		String[] lances = {"Aberto","Fechado"};
		
		JComboBox comboBoxLance = new JComboBox(lances);
		comboBoxLance.setBounds(161, 87, 96, 27);
		contentPane.add(comboBoxLance);
		
		DateFormat format = new SimpleDateFormat("yyyy--MMMM--dd");
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setBounds(25, 141, 75, 16);
		contentPane.add(lblDataInicio);
		
		JFormattedTextField formattedTextField = new JFormattedTextField(format);
		formattedTextField.setValue(new Date());
	    DateFormatter fmt = (DateFormatter) formattedTextField.getFormatter();
	    fmt.setFormat(DateFormat.getDateInstance());
	    //fmt.setFormat(new SimpleDateFormat("d/M/yyyy"));
	    formattedTextField.setValue(formattedTextField.getValue());
		formattedTextField.setBounds(161, 135, 68, 28);
		contentPane.add(formattedTextField);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setBounds(21, 192, 61, 16);
		contentPane.add(lblDataFim);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField(format);
		formattedTextField_1.setValue(new Date());
	    DateFormatter fmt2 = (DateFormatter) formattedTextField_1.getFormatter();
	    fmt2.setFormat(DateFormat.getDateInstance());
	    //fmt2.setFormat(new SimpleDateFormat("d/M/yyyy"));
	    formattedTextField_1.setValue(formattedTextField_1.getValue());
		formattedTextField_1.setBounds(161, 186, 68, 28);
		contentPane.add(formattedTextField_1);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			@SuppressWarnings({ "deprecation", "static-access" })
			public void actionPerformed(ActionEvent e) {
//				System.out.println(formattedTextField.getValue().toString());
//				String aux[] = formattedTextField.getValue().toString().split("/");
//				int yearBegin = Integer.parseInt(aux[2]);
//				int monthBegin = Integer.parseInt(aux[1]);
//				int dayBegin = Integer.parseInt(aux[0]);
//				
//				String aux2[] = formattedTextField_1.getValue().toString().split("/");
//				int yearEnd = Integer.parseInt(aux2[2]);
//				int monthEnd = Integer.parseInt(aux2[1]);
//				int dayEnd = Integer.parseInt(aux2[0]);
				
				Date a = new Date(Date.parse(formattedTextField.getValue().toString()));
				Date b = new Date(Date.parse(formattedTextField_1.getValue().toString()));
				
				controler.insertLeilao(comboBoxLeilao.getSelectedItem().toString(), comboBoxLance.getSelectedItem().toString(),a, b, fachada.getInstance().getIDUsuarioLogado(), 0.0);
			}
		});
		btnInsert.setBounds(327, 231, 117, 29);
		contentPane.add(btnInsert);
	}
}
