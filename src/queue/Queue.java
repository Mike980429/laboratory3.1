package queue;

import java.util.ArrayList;

/**
 * @param <T>Tipo
 *            de parametro generico de la cola.
 */
public class Queue<T> implements IQueue<T> {

	/**
	 * Atributo de tipo ArrayList generico T en el cual se almacenan los elementos
	 * de la cola.
	 */
	private ArrayList<T> objetos;

	/**
	 * Construye una instancia de esta clase vacia.Capacidad ilimitada.
	 */
	public Queue() {
		objetos = new ArrayList<T>();
	}

	@Override
	public T deQueue() {
		// TODO Auto-generated method stub
		try {
			T aux = objetos.get(0);
			objetos.remove(0);
			return aux;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void enQueue(T obj) {
		// TODO Auto-generated method stub
		objetos.add(obj);

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return objetos.size() == 0;
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		try {
			return objetos.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return objetos.size();
	}

}
