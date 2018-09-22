package model;

public class Player {

	private String name;
	private int age;
	private String team;
	private double pointGame;
	private int reboundGame;
	private int assistsGame;
	private int blocksGame;
	
	
	
	public Player(String name,int age, String team,double pointGame, int reboundGame,int assistsGame,int blocksGame ) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.team=team;
		this.pointGame=pointGame;
		this.reboundGame=reboundGame;
		this.assistsGame=assistsGame;
		this.blocksGame=blocksGame;
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



	public int getReboundGame() {
		return reboundGame;
	}



	public void setReboundGame(int reboundGame) {
		this.reboundGame = reboundGame;
	}



	public int getAssistsGame() {
		return assistsGame;
	}



	public void setAssistsGame(int assistsGame) {
		this.assistsGame = assistsGame;
	}



	public int getBlocksGame() {
		return blocksGame;
	}



	public void setBlocksGame(int blocksGame) {
		this.blocksGame = blocksGame;
	}

}
