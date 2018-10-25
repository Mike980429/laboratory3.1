package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void addPlayer(Player newPlayer) throws Exception{
		root.insertar(newPlayer.statisticalItem(),newPlayer);
		rootReboundGame.insertar(newPlayer.getReboundGame(),newPlayer);
		rootBlocksGame.put(newPlayer.getBlocksGame(),newPlayer);
		rootAssistsGame.insertar(newPlayer.getAssistsGame(),newPlayer);
		rootTheftGame.enQueue(newPlayer);
	}
	
		public void readArchive(String address) {

		String line = "";
		String separator = ",";
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(address));
		    while ((line = br.readLine()) != null) {                
		        String[] datos = line.split(separator);
		    
		       System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    if (br != null) {
		        try {
		            br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		
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
	
//	public void persistenceOn() throws FileNotFoundException, IOException, ClassNotFoundException {
//		// TODO test it
//		// initialize players added:
//		ObjectInputStream hashMapReader = new ObjectInputStream(new FileInputStream(./docs));
//		this.playersAdded = (HashMap<String, Integer>) hashMapReader.readObject();
//		hashMapReader.close();
//		// initialize bts tree:
//		ObjectInputStream btsReader = new ObjectInputStream(new FileInputStream(BTS_OBJECT_PATH));
//		this.BTSTree = (BinarySearchTree) btsReader.readObject();
//		btsReader.close();
//		// initialize avl tree:
//		ObjectInputStream avlReader = new ObjectInputStream(new FileInputStream(AVL_OBJECT_PATH));
//		this.AVlTree = (AVLTree) avlReader.readObject();
//		avlReader.close();
//		// initialize red black tree:
//		ObjectInputStream rbReader = new ObjectInputStream(new FileInputStream(RBT_OBJECT_PATH));
//		this.RBTree = (RedBlackTree) rbReader.readObject();
//		rbReader.close();
//		// initialize queue with availabe indexs
//		ObjectInputStream queueReader = new ObjectInputStream(new FileInputStream(QUEUE_OBJECT_PATH));
//		this.availableIndexs = (Queue<Integer>) queueReader.readObject();
//		queueReader.close();
//
//	}
	
	
	
	
	
}
