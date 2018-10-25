package graphics;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.*;

public class PanelOne extends JPanel implements ListSelectionListener{

	private Graphic main;  
	private JScrollPane scroll;
	private JList<Player> players;

	private JPanel aux;
	private Player actual;
	
	public PanelOne(Graphic main) {
		// TODO Auto-generated constructor stub
		
		this.main=main;
		players=new JList<Player>();
		players.addListSelectionListener(this);
		players.setSelectedIndex(0);
		scroll=new JScrollPane();

		aux=new JPanel(new GridLayout());
		aux.setSize(new Dimension(366,66));
		
		aux.add(players);
		add(aux);
		setBorder(new TitledBorder("Lista Jugadores "));
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(!e.getValueIsAdjusting()){
			actual=players.getSelectedValue();
			main.getPanelTwo().statusPlayer(actual.getName(),actual.getAge(),actual.getTeam()
					,actual.getPointGame(),actual.getReboundGame(),actual.getAssistsGame()
					,actual.getBlocksGame(),actual.getTheftGame() );
			
		}
		
	}

	public Player getActual() 	{
		return actual;
	}
	public Graphic getMain() {
		return main;
	}


	public void setMain(Graphic main) {
		this.main = main;
	}


	public JScrollPane getScroll() {
		return scroll;
	}


	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}


	public JList<Player> getPlayers() {
		return players;
	}


	public void setPlayers(JList<Player> players) {
		this.players = players;
	}


	public JPanel getAux() {
		return aux;
	}


	public void setAux(JPanel aux) {
		this.aux = aux;
	}
	
}
