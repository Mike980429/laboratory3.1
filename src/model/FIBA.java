package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import javax.swing.text.html.HTMLDocument.Iterator;

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
	private HashMap<Double,Player> rootBlocksGame ;
	private Queue<Player> rootTheftGame ;
	
	public FIBA() {
		// TODO Auto-generated constructor stub
		root=new ABB<Double,Player>();
		rootReboundGame=new AVL<Double,Player>();
		rootBlocksGame=new HashMap<Double,Player>();
		rootAssistsGame=new ARB<Double,Player>();
		rootTheftGame=new Queue<Player>();
		
	}
	
	public void inicioPrograma() {
		readPlayerSerializable();
		
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
	
	public ArrayList<Player> searchPlayerBlocksGame(double num) {
		
		ArrayList<Player> search=null;
		
		
		java.util.Iterator<Double> iter= rootBlocksGame.keySet().iterator();
		while(iter.hasNext()) {
			Double key=iter.next();
			
			if(rootBlocksGame.get(key).getBlocksGame()==num) {
				search.add(rootBlocksGame.get(key));
			}
		}
		
		
		return search;
	}
	
	public ArrayList<Player> searchPlayerTheftGame(double num) {
		
		ArrayList<Player> search= new ArrayList<>();
		
		for(Player actual :rootTheftGame.getObjetos()) {
			if(actual.getTheftGame()== num) {
				search.add(actual);
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

	public void readPlayerSerializable() {
		
		try {
			FileInputStream fileInput= new FileInputStream(new File("./sources/players.txt"));
			ObjectInputStream reader= new ObjectInputStream(fileInput);
			
			root= (ABB<Double, Player>) reader.readObject();
			reader.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
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
