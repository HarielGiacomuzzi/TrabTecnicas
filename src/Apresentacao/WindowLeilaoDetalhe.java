package Apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;

import oracle.jrockit.jfr.JITracer;
import business.Leilao;
import business.LeilaoFachada;
import business.FachadaException;

public class WindowLeilaoDetalhe extends JFrame {
	
	private JPanel contentPane;
	private ControlerLeiloes controler;
	private JFrame backTo;
	private Leilao leilao;
	private LeilaoFachada fachada;
	
	public void setBack(JFrame frame) {
		this.backTo = frame;
		
	}
	
	public WindowLeilaoDetalhe(int idLeilao) {
		fachada = LeilaoFachada.getInstance();
		this.controler = new ControlerLeiloes(this);
		try{
		
			leilao = fachada.getLeilaoByID(idLeilao);			
			
			getContentPane().setLayout(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 600, 600);
			
			JLabel lblNewLabel = new JLabel("Leilao do usuário:");
			lblNewLabel.setBounds(73, 11, 125, 14);
			getContentPane().add(lblNewLabel);
			
			JLabel labelNomeUsuario = new JLabel(fachada.getNomeByID(leilao.getIdVendedor()));
			labelNomeUsuario.setBounds(208, 11, 46, 14);
			getContentPane().add(labelNomeUsuario);
			
			JList listBens = new JList();
			listBens.setModel(controler.getListBens(leilao.getId()));
			listBens.setBounds(10, 94, 200, 215);
			getContentPane().add(listBens);
			
			JLabel lblBens = new JLabel("Bens:");
			lblBens.setBounds(10, 69, 46, 14);
			getContentPane().add(lblBens);
			
			JLabel lblNewLabel_1 = new JLabel(controler.total.toString());
			lblNewLabel_1.setBounds(10, 365, 87, 14);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblValor = new JLabel("0");
			lblValor.setBounds(101, 365, 46, 14);
			getContentPane().add(lblValor);
			
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(73, 36, 46, 14);
			getContentPane().add(lblTipo);
			
			String tipo;
			if(leilao.getTipoLeilao().equals("D")){
				tipo = "Demanda";
			} else{
				tipo = "Oferta";
			}
			
			JLabel lblTipoLeilao = new JLabel(tipo);
			lblTipoLeilao.setBounds(208, 36, 97, 14);
			getContentPane().add(lblTipoLeilao);
			
			JLabel lblLances = new JLabel("Lances");
			lblLances.setBounds(308, 69, 46, 14);
			
			JLabel lblTipoLances = new JLabel("Lances ocultos");
			lblTipoLances.setBounds(308, 69, 90, 14);
			
			
			JList listLances = new JList();
			listLances.setBounds(251, 94, 200, 215);
			
			if(leilao.getTipoLance().equals("A")){
				getContentPane().add(lblLances);
				getContentPane().add(listLances);
			} else {
				getContentPane().add(lblTipoLances);
			}
			JLabel lblDataInicio = new JLabel("Data de Inicio:");
			lblDataInicio.setBounds(10, 405, 87, 14);
			getContentPane().add(lblDataInicio);
			
			JLabel lblDatainicio = new JLabel(leilao.getDataInicio().toString().substring(0,10));
			lblDatainicio.setBounds(98, 405, 75, 14);
			getContentPane().add(lblDatainicio);
			
			JLabel lblDataFinal = new JLabel("Data Final:");
			lblDataFinal.setBounds(208, 405, 64, 14);
			getContentPane().add(lblDataFinal);
			
			JLabel lblDatafinal = new JLabel(leilao.getDataFim().toString().substring(0,10));
			lblDatafinal.setBounds(282, 405, 75, 14);
			getContentPane().add(lblDatafinal);
			
			JLabel lblStatus = new JLabel("Status:");
			lblStatus.setBounds(367, 405, 46, 14);
			getContentPane().add(lblStatus);
			
			JLabel lblStatusAtual = new JLabel(leilao.getStatus());
			lblStatusAtual.setBounds(423, 405, 73, 14);
			getContentPane().add(lblStatusAtual);
			
			JButton btnAddBem = new JButton("Adicionar Bem");
			btnAddBem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controler.insertBem(leilao.getId());
				}
			});
			btnAddBem.setBounds(10, 320, 139, 23);
			getContentPane().add(btnAddBem);
			
			JButton btnAddLance = new JButton("Adicionar Lance");
			btnAddLance.setBounds(251, 320, 140, 23);
			getContentPane().add(btnAddLance);
			
			JButton btnBack = new JButton("Back");
			btnBack.setBounds(362, 7, 89, 23);
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controler.backToPrevious(backTo);
				}
			});
			getContentPane().add(btnBack);
		} catch(FachadaException ex){
			ex.printStackTrace();
		}
	}
}
