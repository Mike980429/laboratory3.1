package ARB;

import java.awt.Color;

import javax.security.auth.x500.X500Principal;

import ABB.ABB;
import ABB.NodeTree;

public class ARB<K extends Comparable<K>, V> extends ABB<K, V> { 
	
	public ARB() {
	
		nill = new NodeTree<K, V>(null, null);
		nill.setColor(Color.BLACK);
		root = nill;
	}
	
	public void insertARB(K k, V v){
		
		NodeTree<K, V> newNode = insertar(k, v);
		newNode.setLeft(nill);
		newNode.setRight(nill);
		newNode.setColor(Color.RED);
		
		insertFixupARB(newNode);
	}
	
	public void insertFixupARB(NodeTree<K, V> newNode){
		
		while(newNode.getFather().getColor() == Color.RED){
			if(newNode.getFather() == newNode.getFather().getFather().getLeft()){
				NodeTree<K, V> node = newNode.getFather().getFather().getRight();
				if(node.getColor() == Color.RED){
					newNode.getFather().setColor(Color.BLACK);
					node.setColor(Color.BLACK);
					newNode.getFather().getFather().setColor(Color.RED);
					newNode =newNode.getFather().getFather();
				}else{
					
					if(newNode == newNode.getFather().getRight()){
						newNode = newNode.getFather();
						rotarIzquierda(newNode);
					}
					
					
					newNode.getFather().setColor(Color.BLACK);
					newNode.getFather().getFather().setColor(Color.RED);
					rotarDerecha(newNode.getFather().getFather());
				}
				
			}else{
				
				NodeTree<K, V> y = newNode.getFather().getFather().getLeft();
				if(y.getColor() == Color.RED){
					newNode.getFather().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					newNode.getFather().getFather().setColor(Color.RED);
					newNode = newNode.getFather().getFather();
				}else{
					if(newNode== newNode.getFather().getLeft()){
						newNode = newNode.getFather();
						rotarDerecha(newNode);
					}
					
					newNode.getFather().setColor(Color.BLACK);
					newNode.getFather().getFather().setColor(Color.RED);
					rotarIzquierda(newNode.getFather().getFather());
				}
				
				
			}
		}
		
		root.setColor(Color.BLACK);
		
	}
	
	public void transplantARB(NodeTree<K, V> nodeOne, NodeTree<K, V> nodeTwo){
		
		transplant(nodeOne, nodeTwo);
		nodeTwo.setFather(nodeOne.getFather());
	}
	
	@Override
	public void eliminar(NodeTree<K, V> nodeDelete) {
	
		NodeTree<K, V> nodeCurrent = nodeDelete;
		NodeTree<K, V> nodeReserver = null;
		Color colorOriginalY = nodeCurrent.getColor();
		if(nodeDelete.getLeft() == nill){
			nodeReserver= nodeDelete.getRight();
			transplantARB(nodeDelete, nodeDelete.getRight());
		}else if(nodeDelete.getRight() == nill){
			nodeReserver = nodeDelete.getLeft();
			transplantARB(nodeDelete, nodeDelete.getLeft());
		}else{
			nodeCurrent = minimum(nodeDelete.getRight());
			colorOriginalY = nodeCurrent.getColor();
			nodeReserver= nodeCurrent.getRight();
			if(nodeCurrent.getFather() == nodeDelete){
				nodeReserver.setFather(nodeCurrent);
			}else{
				transplantARB(nodeCurrent, nodeCurrent.getRight());
				nodeCurrent.setRight(nodeDelete.getRight());
				nodeCurrent.getRight().setFather(nodeCurrent);
			}
			transplantARB(nodeDelete, nodeCurrent);
			nodeCurrent.setLeft(nodeDelete.getLeft());
			nodeCurrent.getLeft().setFather(nodeCurrent);
			nodeCurrent.setColor(nodeDelete.getColor());
		}
		
		if(colorOriginalY == Color.BLACK){
			FixupDeleteARB(nodeReserver);
		}
		
	}
	
	public void FixupDeleteARB(NodeTree<K, V> newNodo){
		
		while(newNodo != root && newNodo.getColor() == Color.BLACK){
			
			if(newNodo == newNodo.getFather().getLeft()){
				NodeTree<K, V> nodeCurrent = newNodo.getFather().getRight();
				if(nodeCurrent.getColor() == Color.RED){
					nodeCurrent.setColor(Color.BLACK);
					newNodo.getFather().setColor(Color.RED);
					rotarIzquierda(newNodo.getFather());
					nodeCurrent= newNodo.getFather().getRight();
				}
				if(nodeCurrent.getLeft().getColor() == Color.BLACK && nodeCurrent.getRight().getColor() == Color.BLACK){
					nodeCurrent.setColor(Color.RED);
					newNodo = newNodo.getFather();
				}else{
					if(nodeCurrent.getRight().getColor() == Color.BLACK){
						nodeCurrent.getLeft().setColor(Color.BLACK);
						nodeCurrent.setColor(Color.RED);
						rotarDerecha(nodeCurrent);
						nodeCurrent = newNodo.getFather().getRight();
					}
					nodeCurrent.setColor(newNodo.getFather().getColor());
					newNodo.getFather().setColor(Color.BLACK);
					nodeCurrent.getRight().setColor(Color.BLACK);
					rotarIzquierda(newNodo.getFather());
					newNodo= root;
				}
			}else{
				
				NodeTree<K, V> nodeCurrent = newNodo.getFather().getLeft();
				if(nodeCurrent.getColor() == Color.RED){
					nodeCurrent.setColor(Color.BLACK);
					newNodo.getFather().setColor(Color.RED);
					rotarDerecha(newNodo.getFather());
				nodeCurrent = newNodo.getFather().getLeft();
				}
				if(nodeCurrent.getRight().getColor() == Color.BLACK && nodeCurrent.getLeft().getColor() == Color.BLACK){
					nodeCurrent.setColor(Color.RED);
					newNodo = newNodo.getFather();
				}else{
					if(nodeCurrent.getLeft().getColor() == Color.BLACK){
						nodeCurrent.getRight().setColor(Color.BLACK);
						nodeCurrent.setColor(Color.RED);
						rotarIzquierda(nodeCurrent);
						nodeCurrent = newNodo.getFather().getLeft();
					}
					nodeCurrent.setColor(newNodo.getFather().getColor());
					newNodo.getFather().setColor(Color.BLACK);
					nodeCurrent.getLeft().setColor(Color.BLACK);
					rotarDerecha(newNodo.getFather());
					newNodo = root;
				}
				
			}
			
		}
		newNodo.setColor(Color.BLACK);
	}
	
}
