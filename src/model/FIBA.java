package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ABB.NodeTree;
import AVL.AVL;

public class FIBA {
	
	private AVL<Double,Player> root ;
//	private AVL<Double,Player> rootReboundGame ;
//	private AVL<Double,Player> rootAssistsGame ;
//	private AVL<Double,Player> rootBlocksGame ;
//	private AVL<Double,Player> rootTheftGame ;
	
	public FIBA() {
		// TODO Auto-generated constructor stub
		root=new AVL<Double,Player>();
//		rootReboundGame=new AVL<Double,Player>();
//		rootBlocksGame=new AVL<Double,Player>();
//		rootAssistsGame=new AVL<Double,Player>();
//		rootTheftGame=new AVL<Double,Player>();
		
	}
	
	public void addPlayer(Player newPlayer) {
		root.insertar(newPlayer.getPointGame(),newPlayer);
//		rootReboundGame.insertar(newPlayer.getReboundGame(),newPlayer);
//		rootBlocksGame.insertar(newPlayer.getBlocksGame(),newPlayer);
//		rootAssistsGame.insertar(newPlayer.getAssistsGame(),newPlayer);
//		rootTheftGame.insertar(newPlayer.getTheftGame(),newPlayer);
	}
	
	
	
	
	
	
	public Player searchPlayerPointGame(double num) {
		
		Player search=null;
		if(root.getRoot().getV().getPointGame()==num) {
			return root.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=root.getRoot();
			while(node != null){
				if(node.getV().getPointGame()> num){
					node = node.getLeft();
					
				}else if(node.getV().getPointGame()== num){
					search=node.getV();
				}else {
					node = node.getRight();
				}
			}
		
			
		}
		
		return search;
	}

	public Player searchPlayerReboundGame(double num) {
		
		Player search=null;
		if(root.getRoot().getV().getPointGame()==num) {
			return root.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=root.getRoot();
			while(node != null){
				if(node.getV().getPointGame()> num){
					node = node.getLeft();
					
				}else if(node.getV().getPointGame()== num){
					search=node.getV();
				}else {
					node = node.getRight();
				}
			}
		
			
		}
		
		return search;
	}
	
	public Player searchPlayerBlocksGame(double num) {
		
		Player search=null;
		if(root.getRoot().getV().getPointGame()==num) {
			return root.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=root.getRoot();
			while(node != null){
				if(node.getV().getPointGame()> num){
					node = node.getLeft();
					
				}else if(node.getV().getPointGame()== num){
					search=node.getV();
				}else {
					node = node.getRight();
				}
			}
		
			
		}
		
		return search;
	}
	public Player searchPlayerTheftGame(double num) {
		
		Player search=null;
		if(root.getRoot().getV().getPointGame()==num) {
			return root.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=root.getRoot();
			while(node != null){
				if(node.getV().getPointGame()> num){
					node = node.getLeft();
					
				}else if(node.getV().getPointGame()== num){
					search=node.getV();
				}else {
					node = node.getRight();
				}
			}
		
			
		}
		
		return search;
	}
	public Player searchPlayerAssistsGame(double num) {
		
		Player search=null;
		if(root.getRoot().getV().getPointGame()==num) {
			return root.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=root.getRoot();
			while(node != null){
				if(node.getV().getPointGame()> num){
					node = node.getLeft();
					
				}else if(node.getV().getPointGame()== num){
					search=node.getV();
				}else {
					node = node.getRight();
				}
			}
		
			
		}
		
		return search;
	}

	
	
	
	
	
	
	
	
	public void savePlayerSerializable( ){
		
		try{
			FileOutputStream fileOutputStream = new FileOutputStream(new File("./sources/players.txt"));
			ObjectOutputStream objectOutput= new ObjectOutputStream(fileOutputStream);
			
			objectOutput.writeObject(root);
			objectOutput.close();
		}catch (FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
}