package AVL;

import java.awt.HeadlessException;

import javax.swing.text.AbstractDocument.LeafElement;

import ABB.ABB;
import ABB.NodeTree;

public class AVL<K extends Comparable<K>, V> extends ABB<K, V> {

	public AVL() {
		nill = null;
		root = nill;
	}
	
	public int height(NodeTree<K, V> node){
		if(node==null){
			return 0;
		}else{
			return node.getRollingFactor();
		}
	}
	
	public int getBalance(NodeTree<K, V> node){
		if(node == null)
			return 0;
		return height(node.getLeft()) - height(node.getRight());
	}
	
	@Override
	public NodeTree<K, V> rotarIzquierda(NodeTree<K, V> nodeCurrent) {
		// TODO Auto-generated method stub

		NodeTree<K, V> node = nodeCurrent.getRight();
		NodeTree<K, V> nodeTwo = node.getLeft();
		
		node.setLeft(nodeCurrent);
		nodeCurrent.setRight(nodeTwo);
		
		nodeCurrent.setRollingFactor(Math.max(height(nodeCurrent.getLeft()), height(nodeCurrent.getRight())) + 1);
		node.setRollingFactor(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		
		return node;
		
	}
	
	@Override
	public NodeTree<K, V> rotarDerecha(NodeTree<K, V> nodeCurrent) {
		// TODO Auto-generated method stub
		
		NodeTree<K, V> node = nodeCurrent.getLeft();
		NodeTree<K, V> nodeTwo = node.getRight();
		
		node.setRight(nodeCurrent);
		nodeCurrent.setLeft(nodeTwo);
		
		nodeCurrent.setRollingFactor(Math.max(height(nodeCurrent.getLeft()), height(nodeCurrent.getLeft())) + 1);
		node.setRollingFactor(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		
		return node;
	}
	

	public NodeTree<K, V> insertAVL( NodeTree<K, V> node, NodeTree<K, V> newNodo){
		
		boolean nodeExisting = false;
		if(node == null)
			return new NodeTree<K, V>(newNodo.getK(), newNodo.getV());
		
		if(node.getK().compareTo(newNodo.getK()) > 0){
			node.setLeft(insertAVL(node.getLeft(), newNodo));
		}else if(newNodo.getK().compareTo(node.getK()) > 0){
			node.setRight(insertAVL(node.getRight(), newNodo));
		}else{
			node=newNodo;
			nodeExisting = true;

		}
		
		if(!nodeExisting){
			node.setRollingFactor(1 + Math.max(height(node.getLeft()), height(node.getLeft())));
			
			int balance = getBalance(node);
			
			if(balance > 1 && node.getLeft().getK().compareTo(newNodo.getK()) > 0){
				return rotarDerecha(node);
			}
			if(balance < -1 && newNodo.getK().compareTo(node.getRight().getK()) > 0){
				return rotarIzquierda(node);
			}
			
			if(balance > 1 && newNodo.getK().compareTo(node.getLeft().getK()) > 0){
				node.setLeft(rotarIzquierda(node.getLeft()));
				return rotarDerecha(node);
			}
			
			if(balance < -1 && node.getRight().getK().compareTo(newNodo.getK()) > 0){
				node.setRight(rotarDerecha(node.getRight()));
				return rotarIzquierda(node);
			}
		}
		
		return node;
	}
	
	public NodeTree<K, V> eliminarAVL( NodeTree<K, V> node, K key){
		
		if(node == null)
			return node;
		
		if(node.getK().compareTo(key) > 0){
			node.setLeft(eliminarAVL(node.getLeft(), key));
		}else if(key.compareTo(node.getK()) > 0){
			node.setRight(eliminarAVL(node.getRight(), key));
		}else{
			
			if((node.getLeft() == null) || (node.getRight() == null)){ //El problema debe estar aqui, porque no se hace distincion cuando los dos hijos son null
				
				NodeTree<K, V> current = null;
				if(current == node.getLeft())
					current = node.getRight();
				else
					current = node.getLeft();
				
				if(current == null){
					current = node;
					node = null;
				}else{
					node = current;
				}
				
				
			}else{
				NodeTree<K, V> current = minValueNode(node.getRight());
				node.setK(current.getK());
				node.setRight(eliminarAVL(node.getRight(), current.getK()));
			}
		}
		if(node == null)
			return node;
		
		node.setRollingFactor(Math.max(height(node.getLeft()), height(root.getRight())) + 1);
		
		int balance = getBalance(node);
		
		if(balance > 1 && getBalance(node.getLeft()) >= 0)
			return rotarDerecha(node);
		
		if(balance > 1 && getBalance(node.getLeft()) < 0){
			node.setLeft(rotarIzquierda(node.getLeft()));
			return rotarDerecha(node);
		}
		
		if(balance < -1 && getBalance(node.getRight()) <= 0)
			return rotarIzquierda(node);
		
		 if (balance < -1 && getBalance(node.getRight()) > 0){
			 node.setRight(rotarDerecha(node.getRight()));
			 return rotarIzquierda(node);
		 }
	            
	     return node;
					
	}
	
	@Override
	public NodeTree<K, V> insertar(K k, V v) {
		// TODO Auto-generated method stub

		NodeTree<K, V> newNodo = new NodeTree<K, V>(k, v);
		if(root == null){
			root = newNodo;
		}else{
			root = insertAVL(root, newNodo);
		}
		return newNodo;
	}
	
	public void delete(K k){
		eliminarAVL(root, k);
	}
	
	public NodeTree<K, V> minValueNode(NodeTree<K, V> node){
		NodeTree<K, V> current = node;
		while(current.getLeft() != null)
			current = current.getLeft();
		
		return current;
	}
	
	
}
