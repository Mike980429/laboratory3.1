package hashTable;

/**
 * @param <K>
 *            Tipo generico de la clave del par.
 * @param <V>
 *            Tipo generico del valor del par.
 */
public class Pair<K, V> {

	/**
	 * Atributo generico de la clave.
	 */
	private K key;
	/**
	 * Atributo generico del valor
	 */
	private V value;
	/**
	 * Asociacion al par siguiente en la lista de encadenamiento.Puede ser null
	 */
	private Pair<K, V> next;

	/**
	 * Contruye un objeto Pair
	 * 
	 * @param k
	 *            Parametro de la clave a almacenar
	 * @param v
	 *            Parametro del valor a almacenar
	 */
	public Pair(K k, V v) {
		key = k;
		value = v;
	}

	/**
	 * Metodo get para el siguiente par.
	 * 
	 * @return Devuelve el apuntador del siguiente par.
	 */
	public Pair<K, V> getNext() {
		return next;
	}

	/**
	 * Metodo set para el siguiente par
	 * 
	 * @param next
	 *            Apuntador al objeto que sera guardado en next
	 */
	public void setNext(Pair<K, V> next) {
		this.next = next;
	}

	/**
	 * Metodo get para el atributo key
	 * 
	 * @return Retorna la referencia del atributo key.
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Metodo set para el atributo key
	 * 
	 * @param key
	 *            Referencia a una clave que sera guardada en key.
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * Metodo get para el atributo value
	 * 
	 * @return Retorna la referencia del atributo value;
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Metodo set para el atributo value
	 * 
	 * @param value
	 *            Referencia que sera almacenada en value.
	 */
	public void setValue(V value) {
		this.value = value;
	}

}
