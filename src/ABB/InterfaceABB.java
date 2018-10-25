package ABB;

public interface InterfaceABB<K extends Comparable<K>, V> {

	//public void agregar(K k, V v, int inicio, NodoABB<K, V> nodoActual);
	public NodeTree<K, V> insertar(K k, V v);
	//public NodoABB<K, V> buscar(K k, int inicio, NodoABB<K, V> nodoActual);
	public NodeTree<K, V> busquedaIterativa(K k);
	//public boolean eliminar(K k, int inicio, NodoABB<K, V> nodoActual);
	public void eliminar(NodeTree<K, V> z);
	public NodeTree<K, V> rotarIzquierda(NodeTree<K, V> nodoActual);
	public NodeTree<K, V> rotarDerecha(NodeTree<K, V> nodoActual);
	public void transplant(NodeTree<K, V> u, NodeTree<K, V> v);
	
}
