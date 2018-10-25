package hashTable;

/**
 * @param <K>Tipo
 *            generico de las claves de la tabla
 * @param <V>Tipo
 *            generico de los valores de la tabla
 */
public interface IHashTable<K, V> {
	/**
	 * Agrega un Pair clave-valor a la tabla
	 * 
	 * @param key
	 *            Clave del par a agregar
	 * @param value
	 *            Valor del par a agregar
	 */
	public void put(K key, V value);

	/**
	 * Recupera un valor de la tabla asociado a una clave en especial.
	 * 
	 * @param key
	 *            La clave asociada al valor a buscar.
	 * @return Retorna un valor asociado con la clave pasada por parametro, o null
	 *         si no existe tal objeto.
	 */
	public V get(K key);

	/**
	 * Determina el factor de carga de la tabla hash. Este factor de carga se define
	 * como n/m, donde n es el numero de elementos(Pares) guardados en la tabla y m
	 * su capacidad.
	 * 
	 * @return Retorna un double que representa el factor de carga de la tabla.
	 */
	public double loadFactor();

}
