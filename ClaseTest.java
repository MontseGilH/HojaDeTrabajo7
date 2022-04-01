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
	
}