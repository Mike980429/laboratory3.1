package ABB;

import java.awt.Color;

import java.util.ArrayList;

public class NodeTree <K,V> { 

	private K k;
	private V v;
	private NodeTree<K, V> father;
	private NodeTree<K, V> right;
	private NodeTree<K, V> left;
	private Color color;
	private int rollingFactor;
	
	public NodeTree(K k, V v) {
		// TODO Auto-generated constructor stub
		this.k = k;
		this.v=v;
		right = null;
		left = null;
		father = null;
		rollingFactor = 1;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}
	
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	public NodeTree<K, V> getFather() {
		return father;
	}

	public void setFather(NodeTree<K, V> father) {
		this.father = father;
	}

	public NodeTree<K, V> getRight() {
		return right;
	}

	public void setRight(NodeTree<K, V> right) {
		this.right = right;
	}

	public NodeTree<K, V> getLeft() {
		return left;
	}

	public void setLeft(NodeTree<K, V> left) {
		this.left = left;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getRollingFactor() {
		return rollingFactor;
	}
	public void setRollingFactor(int rollingFactor) {
		this.rollingFactor = rollingFactor;
	}
	
	
	
	
}
