/**
 * Ultima modificacion: 31/03/2022
 * 
 * Clase que test del interprete, para corregir errores
 * @file ClaseTest.java
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClaseTest {
	
	/**
	 * Evalua agregar a un arbol
	 */
	@Test
	void testAgregarArbol()  {
		BinarySearchTree<String> arbol = new BinarySearchTree<String>();
		arbol.add("hola");
		arbol.add("adios");
		arbol.add("hello");
		arbol.add("mira");
		arbol.add("casa");
		assertEquals(true,arbol.contains("hola"));
		assertEquals(("adios"),arbol.get("adios"));
		assertEquals(("hola"),arbol.get("hola"));
		assertEquals(("mira"),arbol.get("mira"));
		assertEquals(null,arbol.get("jiji"));
	}
	
	/**
	 * Evalua recorrer in order
	 */
	@Test
	void testInOrder()  {
		BinarySearchTree<String> arbol = new BinarySearchTree<String>();
		arbol.add("hola");
		arbol.add("adios");
		arbol.add("hello");
		arbol.add("mira");
		arbol.add("casa");
		assertEquals("<adios, casa, hello, hola, mira>",arbol.toStringOrder());
	}
	
	/**
	 * Evalua associations
	 */
	@Test
	void testAssociations()  {
		BinarySearchTree<Association<String, String>> arbol = new BinarySearchTree<Association<String, String>>();
		arbol.add(new Association<String, String>("hello","hola"));
		arbol.add(new Association<String, String>("bye","adios"));
		arbol.add(new Association<String, String>("home","casa"));
		arbol.add(new Association<String, String>("apple","manzana"));
		assertEquals("<apple, bye, hello, home>",arbol.toStringOrder());
		assertEquals("hello",arbol.get(new Association<String, String>("hello",null)).key);
		assertEquals("hola",arbol.get(new Association<String, String>("hello","")).value);
		assertEquals(null,arbol.get(new Association<String, String>("happy","")));
	}
	
}