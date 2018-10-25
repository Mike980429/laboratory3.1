package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelThree extends JDialog implements ActionListener, ListSelectionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String SHOOT="disparar";
	public static final String RETURN="volver";
	public static final String ADDWEAPON="agregarArma";
	
	public static final String LISTP="lista jugadores";
	public static final String LISTW="lista armas";
	
	private JButton shoot;
	private JButton returnMenu;
	private JButton addWeapon;
	
	
//	private JList<Player> players;
	private Graphic main;
//	private JList<Weapon> weapons;
	
	
	private JPanel aux;
	private JPanel auxOne;
//	private Player actual;
	
	public PanelThree(Graphic main) {
		// TODO Auto-generated constructor stub
		
		this.main=main;
		
		aux=new JPanel(new BorderLayout());
		auxOne=new JPanel(new GridLayout(2,1));
		
		shoot=new JButton("Disparar");
		shoot.setActionCommand(SHOOT);
		shoot.addActionListener(this);
		
		returnMenu=new JButton("Volver al menu");
		returnMenu.setActionCommand(RETURN);
		returnMenu.addActionListener(this);
		
		addWeapon=new JButton("Agregar arma");
		addWeapon.setActionCommand(ADDWEAPON);
		addWeapon.addActionListener(this);
		
		
//		players=new JList<Player>();
//		players.addListSelectionListener(this);
		
		//players.setSize(new Dimension(60,60));
//		weapons=new JList<Weapon>();
		
		

		
		addPanel();
		add(aux);
		pack();
	}
	
	
	public void addPanel() {
		
		JPanel a=new JPanel(new GridLayout(1,3));
		a.setBorder(new TitledBorder("Lista Armas Juego"));
		a.add(shoot);
		a.add(addWeapon);
		a.add(returnMenu);
//		auxOne.add(weapons);
		auxOne.add(a);
//		aux.add(players,BorderLayout.CENTER);
		
		JLabel image=new JLabel();
		ImageIcon ima=new ImageIcon("./sources/1.jpg");
		Icon c=new ImageIcon(ima.getImage());
		image.setIcon(c);
		aux.setBorder(new TitledBorder("Listado de jugadores en Partida"));
		aux.add(auxOne,BorderLayout.EAST);
		aux.add(image,BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(RETURN)) {
			this.setVisible(false);
		}else if(e.getActionCommand().equals(SHOOT)) {

			try {
				main.viewListWeapon();
//				actual.shootPlayer();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Seleccione el jugador");
			}
			
		}else if(e.getActionCommand().equals(ADDWEAPON)) {
			String type=JOptionPane.showInputDialog(null,"Dijite el tipo de arma: ");
			String numBullets=JOptionPane.showInputDialog(null,"Dijite numero de balas: ");
//			actual.addWeapon(type, Integer.parseInt(numBullets));
			main.viewListWeapon();
			
		}
		
	}
//	public Player getActual() {
//		return actual;
//	}
	
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(!e.getValueIsAdjusting()){
//			actual=players.getSelectedValue();
			main.viewListWeapon();
			
		}else {
//			actual=main.getPanelOne().getActual();
		}
		
	}
	
//	public JList getPlayers() {
//		return players;
//	}
	
//	public JList getWeapons() {
//		return weapons;
//	}

}
