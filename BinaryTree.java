/**
 * Ultima modificacion: 31/03/2022
 * 
 * Clase de los binaryTree
 * @file BinaryTree.java
 * @author Montserrat Gil
 * @author Gabriela Archila
 */

public class BinaryTree<E extends Comparable<E>>
{

    protected E val; // value associated with node
	protected BinaryTree<E> left, right; // children of node
	
	
	public BinaryTree(E value)
	// post: returns a tree referencing value and two empty subtrees
	{
		val = value;
		right = left = null;
	}
	
	public BinaryTree<E> left()
	// post: returns reference to (possibly empty) left subtree
	{
		return left;
	}
	

    public BinaryTree<E> right()
	// post: returns reference to right node, or null
    {
        return right;
    }
	


    public boolean isEmpty() {
        return val==null;
    }

	
	public E value()
	// post: returns value associated with this node
	{
		return val;
	}
	
	public void setValue(E value)
	// post: sets the value associated with this node
	{
		val = value;
	}
	
}