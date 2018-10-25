package model;

import ABB.ABB;
import ABB.NodeTree;
import AVL.AVL;

public class Player{

	private Player playerLeft;
	private Player playerRight;

	private String name;
	private int age;
	private String team;
	private double pointGame;
	private double reboundGame;
	private double assistsGame;
	private double blocksGame;
	private double theftGame;
	
	
	
	
	public Player(String name,int age, String team,double pointGame, double reboundGame,double assistsGame,double blocksGame, double theftGame ) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.team=team;
		this.pointGame=pointGame;
		this.reboundGame=reboundGame;
		this.assistsGame=assistsGame;
		this.blocksGame=blocksGame;
		this.theftGame=theftGame;
		this.playerLeft=null;
		this.playerRight=null;
	}

	public double statisticalItem() {
		double statistical=0;
	
		statistical=(pointGame+reboundGame+assistsGame+blocksGame+theftGame)/5;
		
		
		return statistical;
	}
	
	public Player getPlayerLeft() {
		return playerLeft;
	}



	public void setPlayerLeft(Player playerLeft) {
		this.playerLeft = playerLeft;
	}



	public Player getPlayerRight() {
		return playerRight;
	}



	public void setPlayerRight(Player playerRight) {
		this.playerRight = playerRight;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		this.team = team;
	}



	public double getPointGame() {
		return pointGame;
	}



	public void setPointGame(double pointGame) {
		this.pointGame = pointGame;
	}



	public double getReboundGame() {
		return reboundGame;
	}



	public void setReboundGame(double reboundGame) {
		this.reboundGame = reboundGame;
	}



	public double getAssistsGame() {
		return assistsGame;
	}



	public void setAssistsGame(double assistsGame) {
		this.assistsGame = assistsGame;
	}



	public double getBlocksGame() {
		return blocksGame;
	}



	public void setBlocksGame(double blocksGame) {
		this.blocksGame = blocksGame;
	}



	public double getTheftGame() {
		return theftGame;
	}



	public void setTheftGame(double theftGame) {
		this.theftGame = theftGame;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+"--"+this.age+"--"+this.team;
	}

}
