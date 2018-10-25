package graphics;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Player;

public class PanelTwo extends JPanel implements ActionListener {

	
	public final static String ADD="agregar";
	public final static String DELETE="eliminar";
	public final static String SEARCH="buscar";
	
	private Graphic main;
	
	private JButton addPlayer;
	private JButton deletePlayer;
	private JButton addPlatform;
	
	private JPanel auxOne;
	private JPanel auxTwo;
	private JPanel join;
	
	private JLabel name;
	private JLabel age;
	private JLabel team;
	private JLabel pointGame;
	private JLabel reboundGame;
	private JLabel assistsGame;
	private JLabel blocksGame;
	private JLabel theftGame;
		
	private JTextField name1;
	private JTextField age1;
	private JTextField team1;
	private JTextField pointGame1;
	private JTextField reboundGame1;
	private JTextField assistsGame1;
	private JTextField blocksGame1;
	private JTextField theftGame1;
	

	public PanelTwo(Graphic main) {
		// TODO Auto-generated constructor stub
		this.main=main;
		
		
		auxOne=new JPanel(new GridLayout(8,2));
		auxTwo=new JPanel(new GridLayout(1,3));
		join=new JPanel(new GridLayout(2,1));
		
		addPlayer=new JButton("Agregar jugador");
		addPlayer.setActionCommand(ADD);
		addPlayer.addActionListener(this);
		
		deletePlayer=new JButton("Eliminar jugador");
		deletePlayer.setActionCommand(DELETE);
		deletePlayer.addActionListener(this);
		deletePlayer.setSize(new Dimension(33,60));
		
		addPlatform=new JButton("Buscar Jugador");
		addPlatform.setActionCommand(SEARCH);
		addPlatform.addActionListener(this);
		
		name=new JLabel("Nombre: ");
		age=new JLabel("Edad: ");
		team=new JLabel("Equipo: ");
		pointGame=new JLabel("Puntos por partido: ");
		reboundGame=new JLabel("Rebotes por partido: ");
		assistsGame=new JLabel("Asistencia por partido: ");
		blocksGame=new JLabel("Bloqueo por partido: ");
		theftGame=new JLabel("Robos por partido: ");

	      name1=new JTextField();
		  age1=new JTextField();
		  team1=new JTextField();
		  pointGame1=new JTextField();
		  reboundGame1=new JTextField();
		  assistsGame1=new JTextField();
		  blocksGame1=new JTextField();
		  theftGame1=new JTextField();
		

		
		setBorder(new TitledBorder("Datos Jugador"));
		
		addPanels();
		add(join);
		
	}
	
	public void addPanels() {
		
		auxOne.add(name);
		auxOne.add(name1);
		auxOne.add(age);
		auxOne.add(age1);
		auxOne.add(team);
		auxOne.add(team1);
		auxOne.add(pointGame);
		auxOne.add(pointGame1);
		auxOne.add(reboundGame);
		auxOne.add(reboundGame1);
		auxOne.add(assistsGame);
		auxOne.add(assistsGame1);
		auxOne.add(blocksGame);
		auxOne.add(blocksGame1);
		auxOne.add(theftGame);
		auxOne.add(theftGame1);
		
		join.add(auxOne);
		
		auxTwo.add(addPlayer);
		auxTwo.add(deletePlayer);
		auxTwo.add(addPlatform);
		auxTwo.setBorder(new TitledBorder("Controlador"));
		join.add(auxTwo);
		
	}
	public void statusPlayer(String name,int age, String team,double pointGame, double d,double e,double f, double g ) {
		
		 name1.setText(name);
		 age1.setText(age+"");
		 team1.setText(team);
		 pointGame1.setText(pointGame1+"");
		 reboundGame1.setText(reboundGame1+"");
		 assistsGame1.setText(assistsGame1+"");
		 blocksGame1.setText(f+"");
		 theftGame1.setText(g+"");
		
		
	}
	
	public void statusEntry(boolean status) {

		name1.setEnabled(status);	
		age1.setEnabled(status);
		team1.setEnabled(status);
		pointGame1.setEnabled(status);
		reboundGame1.setEnabled(status);
		assistsGame1.setEnabled(status);
		blocksGame1.setEnabled(status);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals(ADD)) {
			
			try {
				if(name1.isEnabled()==false) {
					this.statusEntry(true);
				}else {
					main.addPlayer(name1.getText(),Integer.parseInt(age1.getText()), 
							team1.getText(),Double.parseDouble(pointGame1.getText()),
							Integer.parseInt(reboundGame1.getText()),Integer.parseInt(assistsGame1.getText()),
							Integer.parseInt(blocksGame1.getText()),Integer.parseInt(theftGame1.getText())
							);
					this.statusEntry(false);
					
				}
			} catch (Exception e2) {
				// TODO: handle exception
				
			}	
		}else if(e.getActionCommand().equals(DELETE)) {
			String nick=JOptionPane.showInputDialog("Dijite el nickname del jugador a eliminar");
			main.deletePlayer(nick);
		}else if(e.getActionCommand().equals(SEARCH)) {
			try {
				
					String message=JOptionPane.showInputDialog(null,"Rubros de busqueda por jugador, dijite: "
							+"\n"+"1.Puntos por partido"+"\n"+ "2.Rebotes por partido" +"\n"+"3.Asistencias por partido"+"\n"+"4.Robos por partido"
							+"\n"+ "5.bloqueos por partido")	;
					int num=Integer.parseInt(message);
					

			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Antes de ingresar a la plataforma seleccione el Jugador");
			}

		}
		
	}
	
	public Graphic getMain() {
		return main;
	}

	public void setMain(Graphic main) {
		this.main = main;
	}

	public JButton getAddPlayer() {
		return addPlayer;
	}

	public void setAddPlayer(JButton addPlayer) {
		this.addPlayer = addPlayer;
	}

	public JButton getDeletePlayer() {
		return deletePlayer;
	}

	public void setDeletePlayer(JButton deletePlayer) {
		this.deletePlayer = deletePlayer;
	}

	public JButton getAddPlatform() {
		return addPlatform;
	}

	public void setAddPlatform(JButton addPlatform) {
		this.addPlatform = addPlatform;
	}

	public JPanel getAuxOne() {
		return auxOne;
	}

	public void setAuxOne(JPanel auxOne) {
		this.auxOne = auxOne;
	}

	public JPanel getAuxTwo() {
		return auxTwo;
	}

	public void setAuxTwo(JPanel auxTwo) {
		this.auxTwo = auxTwo;
	}

	public JPanel getJoin() {
		return join;
	}

	public void setJoin(JPanel join) {
		this.join = join;
	}
	public void setName(JLabel name) {
		this.name = name;
	}

	public JLabel getAge() {
		return age;
	}

	public void setAge(JLabel age) {
		this.age = age;
	}

	public JLabel getTeam() {
		return team;
	}

	public void setTeam(JLabel team) {
		this.team = team;
	}

	public JLabel getPointGame() {
		return pointGame;
	}

	public void setPointGame(JLabel pointGame) {
		this.pointGame = pointGame;
	}

	public JLabel getReboundGame() {
		return reboundGame;
	}

	public void setReboundGame(JLabel reboundGame) {
		this.reboundGame = reboundGame;
	}

	public JLabel getAssistsGame() {
		return assistsGame;
	}

	public void setAssistsGame(JLabel assistsGame) {
		this.assistsGame = assistsGame;
	}

	public JLabel getBlocksGame() {
		return blocksGame;
	}

	public void setBlocksGame(JLabel blocksGame) {
		this.blocksGame = blocksGame;
	}

	public JLabel getTheftGame() {
		return theftGame;
	}

	public void setTheftGame(JLabel theftGame) {
		this.theftGame = theftGame;
	}

	public JTextField getName1() {
		return name1;
	}

	public void setName1(JTextField name1) {
		this.name1 = name1;
	}

	public JTextField getAge1() {
		return age1;
	}

	public void setAge1(JTextField age1) {
		this.age1 = age1;
	}

	public JTextField getTeam1() {
		return team1;
	}

	public void setTeam1(JTextField team1) {
		this.team1 = team1;
	}

	public JTextField getPointGame1() {
		return pointGame1;
	}

	public void setPointGame1(JTextField pointGame1) {
		this.pointGame1 = pointGame1;
	}

	public JTextField getReboundGame1() {
		return reboundGame1;
	}

	public void setReboundGame1(JTextField reboundGame1) {
		this.reboundGame1 = reboundGame1;
	}

	public JTextField getAssistsGame1() {
		return assistsGame1;
	}

	public void setAssistsGame1(JTextField assistsGame1) {
		this.assistsGame1 = assistsGame1;
	}

	public JTextField getBlocksGame1() {
		return blocksGame1;
	}

	public void setBlocksGame1(JTextField blocksGame1) {
		this.blocksGame1 = blocksGame1;
	}

	public JTextField getTheftGame1() {
		return theftGame1;
	}

	public void setTheftGame1(JTextField theftGame1) {
		this.theftGame1 = theftGame1;
	}




}
