package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import ABB.ABB;
import ABB.NodeTree;
import ARB.ARB;
import AVL.AVL;
import hashTable.HashTable;
import queue.Queue;

public class FIBA {
	
	private ABB<Double,Player> root ;
	private AVL<Double,Player> rootReboundGame ;
	private ARB<Double,Player> rootAssistsGame ;
	private HashTable<Double,Player> rootBlocksGame ;
	private Queue<Player> rootTheftGame ;
	
	public FIBA() {
		// TODO Auto-generated constructor stub
		root=new ABB<Double,Player>();
		rootReboundGame=new AVL<Double,Player>();
		rootBlocksGame=new HashTable<Double,Player>();
		rootAssistsGame=new ARB<Double,Player>();
		rootTheftGame=new Queue<Player>();
		
	}
	
	public void addPlayer(Player newPlayer) throws Exception{
		root.insertar(newPlayer.statisticalItem(),newPlayer);
		rootReboundGame.insertar(newPlayer.getReboundGame(),newPlayer);
		rootBlocksGame.put(newPlayer.getBlocksGame(),newPlayer);
		rootAssistsGame.insertar(newPlayer.getAssistsGame(),newPlayer);
		rootTheftGame.enQueue(newPlayer);
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
		if(rootReboundGame.getRoot().getV().getPointGame()==num) {
			return rootReboundGame.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=rootReboundGame.getRoot();
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
		
		ArrayList<Player> search=null;
		
		
		
			
		}
		
		return search;
	}
	public Player searchPlayerTheftGame(double num) {
		
		Player search=null;
		if(rootTheftGame.getRoot().getV().getPointGame()==num) {
			return rootTheftGame.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=rootTheftGame.getRoot();
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
		if(rootAssistsGame.getRoot().getV().getPointGame()==num) {
			return rootAssistsGame.getRoot().getV();
		}else {
			NodeTree<Double, Player> node=rootAssistsGame.getRoot();
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
