package queue;

/**
 * @param <T>
 *            Tipo generico de la cola.
 */
public interface IQueue<T> {
	/**
	 * 
	 * Metodo que se encarga de sacar el siguiente elemento a atender de la cola.
	 * 
	 * @return El elemento que se retiro de la cola.Retorna null si la cola esta
	 *         vacia.
	 */
	public T deQueue();

	/**
	 * Metodo para insetar un nuevo elemento a la cola.
	 * 
	 * @param obj
	 *            Elemento a insertar.
	 */
	public void enQueue(T obj);

	/**
	 * Metodo que permite consultar si la cola esta vacia.
	 * 
	 * @return True si la cola se encuentra vacia, falso sino.
	 */
	public boolean isEmpty();

	/**
	 * Devuelve el siguiente elemento a atender de la cola sin removerlo.
	 * 
	 * @return El siguiente elemento a atender.
	 */
	public T head();

	/**
	 * Devuelve el tamaño de la cola.
	 * 
	 * @return Tamaño de la cola.
	 */
	public int size();
}
