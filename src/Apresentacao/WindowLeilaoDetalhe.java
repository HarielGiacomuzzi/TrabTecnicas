package Apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WindowLeilaoDetalhe extends JFrame {
	
	private JPanel contentPane;
	private ControlerLeiloes controler;
	private JFrame backTo;
	
	public void setBack(JFrame frame) {
		this.backTo = frame;
		
	}
	
	public WindowLeilaoDetalhe(int idLeilao) {
		this.controler = new ControlerLeiloes(this);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		JLabel lblNewLabel = new JLabel("Leilao do usuário:");
		lblNewLabel.setBounds(73, 11, 125, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel labelNomeUsuario = new JLabel("New label");
		labelNomeUsuario.setBounds(208, 11, 46, 14);
		getContentPane().add(labelNomeUsuario);
		
		JList listBens = new JList();
		listBens.setBounds(10, 94, 200, 215);
		getContentPane().add(listBens);
		
		JLabel lblBens = new JLabel("Bens:");
		lblBens.setBounds(10, 69, 46, 14);
		getContentPane().add(lblBens);
		
		JLabel lblNewLabel_1 = new JLabel("Valor total:");
		lblNewLabel_1.setBounds(10, 365, 87, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblValor = new JLabel("0");
		lblValor.setBounds(101, 365, 46, 14);
		getContentPane().add(lblValor);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(73, 36, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblTipoLeilao = new JLabel("Aberto ou fechado");
		lblTipoLeilao.setBounds(208, 36, 97, 14);
		getContentPane().add(lblTipoLeilao);
		
		JLabel lblLances = new JLabel("Lances");
		lblLances.setBounds(308, 69, 46, 14);
		getContentPane().add(lblLances);
		
		JList listLances = new JList();
		listLances.setBounds(251, 94, 200, 215);
		getContentPane().add(listLances);
		
		JLabel lblDataInicio = new JLabel("Data de Inicio:");
		lblDataInicio.setBounds(10, 405, 87, 14);
		getContentPane().add(lblDataInicio);
		
		JLabel lblDatainicio = new JLabel("DataInicio");
		lblDatainicio.setBounds(98, 405, 73, 14);
		getContentPane().add(lblDatainicio);
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setBounds(208, 405, 64, 14);
		getContentPane().add(lblDataFinal);
		
		JLabel lblDatafinal = new JLabel("DataFinal");
		lblDatafinal.setBounds(282, 405, 46, 14);
		getContentPane().add(lblDatafinal);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(367, 405, 46, 14);
		getContentPane().add(lblStatus);
		
		JLabel lblStatusAtual = new JLabel("StatusAtual");
		lblStatusAtual.setBounds(423, 405, 73, 14);
		getContentPane().add(lblStatusAtual);
		
		JButton btnAddBem = new JButton("Adicionar Bem");
		btnAddBem.setBounds(10, 320, 139, 23);
		getContentPane().add(btnAddBem);
		
		JButton btnAddLance = new JButton("Adicionar Lance");
		btnAddLance.setBounds(251, 320, 117, 23);
		getContentPane().add(btnAddLance);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(362, 7, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.backToPrevious(backTo);
			}
		});
		getContentPane().add(btnBack);
	}
}
