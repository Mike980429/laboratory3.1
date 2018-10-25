package model;

import java.util.ArrayList;

import ABB.NodeTree;
import AVL.AVL;

public class FIBA {
	
	private AVL<Integer,Player> root ;
	
	public FIBA() {
		// TODO Auto-generated constructor stub
		 root=new AVL<Integer,Player>();
		
	}
	
	public void addPlayer(int key,Player newPlayer) {
		root.insertar(key,newPlayer);
	}
	
	public Player searchPlayer(double n,Player node) {
		
		if(root.getRoot().getV().getPointGame()==n) {
			return root.getRoot().getV();
		}else {
			if(node.getRoot().getV().getPointGame()<n) {
				return searchPlayer(n,node.);
			}else {

			}
			
		}
		
		
		//Player playerSearch=root.busquedaIterativa(n).getV();
		return playerSearch;
	}

}
