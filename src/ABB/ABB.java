package ABB;

public class ABB<K extends Comparable<K>, V> implements InterfaceABB<K, V> {


	protected NodeTree<K, V> root;  
	protected NodeTree<K, V> nill;
	
	//Constructor
	public ABB() {
		// TODO Auto-generated constructor stub
		root = null;
		nill = null;
	}
	
	public NodeTree<K, V> getRoot() {
		return root;
	}

	public NodeTree<K, V> getNill() {
		return nill;
	}

	public void setNill(NodeTree<K, V> nill) {
		this.nill = nill;
	}

	public void setRoot(NodeTree<K, V> root) {
		this.root = root;
	}
	
	//La busqueda va a retornar un Arraylist de tipo V o tal vez el mismo nodo.
	@Override
	public NodeTree<K, V> busquedaIterativa(K k){
		
		NodeTree<K, V> node = root;
		
		while(node != nill && node.getK().compareTo(k) != 0){
			if(node.getK().compareTo(k) > 0){
				node = node.getLeft();
			}else{
				node = node.getRight();
			}
		}
		
		return node;
	}
	
	@Override
	public NodeTree<K, V> insertar(K k, V v){
		boolean nodoExistente = false;
		NodeTree<K, V> nodeNill = nill;
		NodeTree<K, V> nodeRoot = root;
		NodeTree<K, V> newNodo = new NodeTree<K, V>(k, v);
		
		while(nodeRoot != nill){
			nodeNill = nodeRoot;
			if(nodeRoot.getK().compareTo(k) > 0){
				nodeRoot= nodeRoot.getLeft();
			}else if(nodeRoot.getK().compareTo(k) < 0){
				nodeRoot= nodeRoot.getRight();
			}else{
				nodoExistente = true;
				nodeRoot.setV(v);
				newNodo = nodeRoot;
			}
		}
		if(!nodoExistente){
			newNodo.setFather(nodeNill);
			if(nodeNill == nill){
				root = newNodo;
			}else if(nodeNill.getK().compareTo(newNodo.getK()) > 0){
				nodeNill.setLeft(newNodo);
			}else{
				nodeNill.setRight(newNodo);
			}
		}
		return newNodo;
	}
	
	@Override
	public void eliminar(NodeTree<K, V> nodeDelete){
		
		if(nodeDelete.getLeft() == nill){
			transplant(nodeDelete, nodeDelete.getLeft());
		}else if(nodeDelete.getRight() == nill){
			transplant(nodeDelete, nodeDelete.getLeft());
		}else{
			NodeTree<K, V> nodeActual = minimum(nodeDelete.getLeft());
			if(nodeActual.getFather() != nodeDelete){
				transplant(nodeActual, nodeActual.getLeft());
				nodeActual.setRight(nodeDelete.getLeft());
				nodeActual.getLeft().setFather(nodeActual);
			}
			transplant(nodeDelete, nodeActual);
			nodeActual.setLeft(nodeDelete.getLeft());
			nodeActual.getLeft().setFather(nodeActual);
		}
		
	}
	
	@Override
	public NodeTree<K, V> rotarIzquierda(NodeTree<K, V> nodeActual) {
		
		NodeTree<K, V> nodeRight = nodeActual.getRight();
		nodeActual.setRight(nodeRight.getLeft());
		
		if(nodeRight.getRight() != nill){
			nodeRight.getRight().setFather(nodeActual);
		}
		nodeRight.setFather(nodeActual.getFather());
		
		if(nodeActual.getFather() == nill){
			root = nodeRight;
		}else if(nodeActual == nodeActual.getFather().getLeft()){
			nodeActual.getFather().setLeft(nodeRight);
		}else{
			nodeActual.getFather().setRight(nodeRight);
		}
		nodeRight.setLeft(nodeActual);
		nodeActual.setFather(nodeRight);
		
		return nodeRight;
	}
	
	@Override
	public NodeTree<K, V> rotarDerecha(NodeTree<K, V> nodeActual) {
		
		NodeTree<K, V> nodeLeft = nodeActual.getLeft();
		nodeActual.setLeft(nodeLeft.getRight());
		
		if(nodeLeft.getRight() != nill){
			nodeLeft.getRight().setFather(nodeActual);
		}
		nodeLeft.setFather(nodeActual.getFather());
		
		if(nodeActual.getFather() == nill){
			root = nodeLeft;
		}else if(nodeActual == nodeActual.getFather().getLeft()){
			nodeActual.getFather().setLeft(nodeLeft);
		}else{
			nodeActual.getFather().setRight(nodeLeft);
		}
		nodeLeft.setRight(nodeActual);
		nodeActual.setFather(nodeLeft);
		
		return nodeLeft;
		
	}
	
	public NodeTree<K, V> minimum(NodeTree<K, V> node){
		
		while(node.getLeft() != nill){
			node = node.getLeft();
		}
		
		return node;
	}
	
	public NodeTree<K, V> maximun(NodeTree<K, V> node){
		
		while(node.getRight() != nill){
			node = node.getRight();
		}
		
		return node;
	}
	
	public NodeTree<K, V> successor(NodeTree<K, V> node){
		
		if(node.getRight() != nill){
			return minimum(node.getRight());
		}
		
		NodeTree<K, V> nodeSuccesor = node.getFather();
		while(nodeSuccesor != nill && node == nodeSuccesor.getRight()){
			node = nodeSuccesor;
			nodeSuccesor = nodeSuccesor.getFather();
		}
		return nodeSuccesor;
	}
	
	@Override
	public void transplant(NodeTree<K, V> nodeOne, NodeTree<K, V> nodeTwo){
		
		if(nodeOne.getFather() == nill){
			root = nodeTwo;
		}else if(nodeOne == nodeOne.getFather().getLeft()){
			nodeOne.getFather().setLeft(nodeTwo);
		}else{
			nodeOne.getFather().setRight(nodeTwo);
		}
		if(nodeTwo!= nill){
			nodeTwo.setFather(nodeOne.getFather());
		}
	}
	
}
