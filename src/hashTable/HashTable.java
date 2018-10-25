package hashTable;

/**
 * @param <K>
 *            Parametro generico del tipo de clave
 * @param <V>
 *            Parametro generico del tipo de valor
 */
public class HashTable<K, V> implements IHashTable<K, V> {

	/**
	 * Atributo de tamaño del arreglo contenedor
	 */
	private int m;

	/**
	 * Lista de objetos Pair donde se guardaran las claves y sus valores.
	 */
	private Pair<K, V>[] lista;

	/**
	 * Construye una HashTable vacia de capacidad 10,con resolucion de colisiones
	 * por encadenamiento.
	 */
	@SuppressWarnings("unchecked")
	public HashTable() {
		m = 10;
		lista = (Pair<K, V>[]) (new Pair[10]);
	}

	/**
	 * Contruye una HashTable vacia de capacidad m, con resolucion de colisiones por
	 * encadenamiento.
	 * 
	 * @param m
	 *            Capacidad de la HashTable a instanciar.
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int m) {
		this.m = m;
		lista = (Pair<K, V>[]) (new Pair[m]);
	}

	/**
	 * Funcion get para el atributo m de capacidad de HashTable
	 * 
	 * @return
	 */
	public int getM() {
		return m;
	}

	@Override
	public void put(K key, V value) {

		int hash = (key.hashCode() & 0x7fffffff) % m;

//		System.out.println("Attempting to put value " + value + " of key " + "\"" + key + "\" in list[" + hash + "]");

		boolean encontrado = false;
		Pair<K, V> actual = lista[hash];

		while (!encontrado) {
			if (actual == null) {
				lista[hash] = new Pair<K, V>(key, value);
				actual = lista[hash];
				encontrado = true;
			} else if (actual.getKey().equals(key)) {
				actual.setValue(value);
				encontrado = true;
			} else if (actual.getNext() == null) {
				actual.setNext(new Pair<K, V>(key, value));
				encontrado = true;
			}
			actual = actual.getNext();
		}

	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		int hash = (key.hashCode() & 0x7fffffff) % m;
		Pair<K, V> actual = lista[hash];
		V retorno = null;
		boolean encontrado = false;

		while (actual != null && !encontrado) {
			if (actual.getKey().equals(key)) {
				retorno = actual.getValue();
				encontrado = true;
			} else {
				actual = actual.getNext();
			}
		}
//		System.out.println("key \"" + key + "\" corresponds to value " + retorno);
		return retorno;
	}

	@Override
	public double loadFactor() {

		double n = 0;
		for (int i = 0; i < lista.length; i++) {
			Pair<K, V> actual = lista[i];
			while (actual != null) {
				n++;
				actual = actual.getNext();
			}
		}
		return (n / (double) m);
	}

}
