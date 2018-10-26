package pruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import ABB.ABB;
import ABB.NodeTree;
import ARB.ARB;
import AVL.AVL;
import model.Player;
import queue.Queue;

class FibaTest {

	@Test
	void test() {
		testRotarIzquierdaABB();
		testRotarDerechaABB();
		testBuscarABB();
		
	//	testBuscarAVL();
		testRotarIzquierdaAVL();
		testRotarDerechaAVL();
	}

	private ABB<Double,Player> root ;
	private AVL<Double,Player> rootReboundGame ;
	private ARB<Double,Player> rootAssistsGame ;
	private HashMap<Double,Player> rootBlocksGame ;
	private Queue<Player> rootTheftGame ;
	
	private void setupEscenario1(){
		root = new ABB<Double, Player>();
		rootReboundGame=new AVL<Double,Player>();
		
		Player playerTest=new Player("emma",23,"Icesi",54.2,44.7,5,55,27.5);
		root.insertar(playerTest.getPointGame(),playerTest);
		
		Player playerTest1=new Player("julian",23,"Puj",76.2,25.7,45,45,32.5);
		root.insertar(playerTest1.getPointGame(),playerTest1);
		
		Player playerTest2=new Player("anna",23,"Uao",3.32,43.7,55,67,99.5);
		root.insertar(playerTest2.getPointGame(),playerTest2);
		
		Player playerTest3=new Player("cristian",23,"SanBue",34.2,23.7,5,55,27.5);
		root.insertar(playerTest3.getPointGame(),playerTest3);
		
		Player playerTest4=new Player("juan",23,"Icesi",121.2,43.7,6,65,67.7);
		root.insertar(playerTest4.getPointGame(),playerTest4);
		
		
		
		
		
	}
	
	private void setupEscenario2(){
//		arbolARB = new ARB<String, String>();

		Player playerTest=new Player("emma",23,"Icesi",54.2,44.7,5,55,27.5);
		rootReboundGame.insertar(playerTest.getPointGame(),playerTest);
		
		Player playerTest1=new Player("julian",23,"Puj",76.2,25.7,45,45,32.5);
		rootReboundGame.insertar(playerTest1.getPointGame(),playerTest1);
		
		Player playerTest2=new Player("anna",23,"Uao",3.32,43.7,55,67,99.5);
		rootReboundGame.insertar(playerTest2.getPointGame(),playerTest2);
		
		Player playerTest3=new Player("cristian",23,"SanBue",34.2,23.7,5,55,27.5);
		rootReboundGame.insertar(playerTest3.getPointGame(),playerTest3);
		
		Player playerTest4=new Player("juan",23,"Icesi",121.2,43.7,6,65,67.7);
		rootReboundGame.insertar(playerTest4.getPointGame(),playerTest4);
		
	}
	
	private void setupEscenario3(){
		
		Player playerTest=new Player("emma",23,"Icesi",54.2,44.7,5,55,27.5);
		rootAssistsGame.insertar(playerTest.getPointGame(),playerTest);
		
		Player playerTest1=new Player("julian",23,"Puj",76.2,25.7,45,45,32.5);
		rootAssistsGame.insertar(playerTest1.getPointGame(),playerTest1);
		
		Player playerTest2=new Player("anna",23,"Uao",3.32,43.7,55,67,99.5);
		rootAssistsGame.insertar(playerTest2.getPointGame(),playerTest2);
		
		Player playerTest3=new Player("cristian",23,"SanBue",34.2,23.7,5,55,27.5);
		rootAssistsGame.insertar(playerTest3.getPointGame(),playerTest3);
		
		Player playerTest4=new Player("juan",23,"Icesi",121.2,43.7,6,65,67.7);
		rootAssistsGame.insertar(playerTest4.getPointGame(),playerTest4);
	}
	
	public void testRotarIzquierdaABB(){
		setupEscenario1();
		Player s=root.getRoot().getV();
		root.rotarIzquierda(root.busquedaIterativa(54.2));
		assertTrue(root.getRoot().getLeft().getV()==s);
		
	}
	
	public void testRotarDerechaABB(){
		
		setupEscenario1();
		
		Player s=root.getRoot().getV();
		root.rotarDerecha(root.busquedaIterativa(54.2));
		assertTrue(root.getRoot().getRight().getV()==s);
	}
	
	public void testAgregarABB(){
		
		setupEscenario1();
		
		Player test=new Player("emma",23,"Icesi",54.2,44.7,5,55,27.5);
		root.insertar(test.getPointGame(), test);
		
		assertTrue((root.busquedaIterativa(54.2).getV()==test)||root.getRoot().getV()==test);
	}

	public void testBuscarABB(){
		
		setupEscenario1();
		
		Player test=root.busquedaIterativa(54.2).getV();
		assertTrue(test!=null);
	}
	
	
	public void testRotarIzquierdaAVL(){
		setupEscenario2();
		Player s=rootReboundGame.getRoot().getV();
		rootReboundGame.rotarIzquierda(rootReboundGame.busquedaIterativa(54.2));
		assertFalse(rootReboundGame.getRoot().getLeft().getV()==s);
		
	}
	
	public void testRotarDerechaAVL(){
		
		setupEscenario2();
		
		Player s=rootReboundGame.getRoot().getV();
		rootReboundGame.rotarDerecha(rootReboundGame.busquedaIterativa(54.2));
		assertFalse(rootReboundGame.getRoot().getRight().getV()==s);
	}
	
	public void testAgregarAVL(){
		
		setupEscenario2();
		
		Player test=new Player("emma",23,"Icesi",54.2,44.7,5,55,27.5);
		rootReboundGame.insertar(test.getPointGame(), test);
		
		assertFalse(rootReboundGame.busquedaIterativa(54.2).getV()==test);
	}

	public void testBuscarAVL(){
		
		setupEscenario2();
		
		Player test=rootReboundGame.busquedaIterativa(54.2).getV();
		assertFalse(test!=null);
	}
	
	public void testRotarIzquierdaARB(){
		setupEscenario2();
		Player s=rootReboundGame.getRoot().getV();
		rootReboundGame.rotarIzquierda(rootReboundGame.busquedaIterativa(54.2));
		assertTrue(rootReboundGame.getRoot().getLeft().getV()==s);
		
	}
	
	public void testRotarDerechaARB(){
		
		setupEscenario2();
		
		Player s=rootReboundGame.getRoot().getV();
		rootReboundGame.rotarDerecha(rootReboundGame.busquedaIterativa(54.2));
		assertTrue(rootReboundGame.getRoot().getRight().getV()==s);
	}
	
	public void testAgregarARB(){
		
		setupEscenario2();
		
		Player test=new Player("emma",23,"Icesi",54.2,44.7,5,55,27.5);
		rootReboundGame.insertar(test.getPointGame(), test);
		
		assertTrue(rootReboundGame.busquedaIterativa(54.2).getV()==test);
	}

	public void testBuscarARV(){
		
		setupEscenario2();
		
		Player test=rootReboundGame.busquedaIterativa(54.2).getV();
		assertTrue(test!=null);
	}
	
	

	
}
