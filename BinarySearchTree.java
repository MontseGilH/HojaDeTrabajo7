// This is an implementation of binary search trees.
// (c) 1998, 2001 duane a. bailey

import java.util.Comparator;


/**
 *
 * @version $Id: BinarySearchTree.java 22 2006-08-21 19:27:26Z bailey $
 * @author, 2001 duane a. bailey
 * @see SplayTree
 * @see BinaryTree
 */
public class BinarySearchTree<E extends Comparable<E>>
    // extends AbstractStructure<E> implements OrderedStructure<E>
	// no las usuaremos por el momento
{
    /**
     * A reference to the root of the tree
     */
    protected BinaryTree<E> root;

    /**
     * The ordering used on this search tree.
     */
    protected Comparator<E> ordering;


    /**
     * Constructs a binary search tree with no data
     *
     * @post Constructs an empty binary search tree
     */
    public BinarySearchTree()
    {
        this.root=null;
    }


    /**
     * Checks for an empty binary search tree
     *
     * @post Returns true iff the binary search tree is empty
     * 
     * @return True iff the tree contains no data
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Removes all data from the binary search tree
     *
     * @post Removes all elements from binary search tree
     */
    public void clear()
    {
        root = new BinaryTree<E>(null);
    }

    
    /**
     * @pre root and value are non-null
     * @post returned: 1 - existing tree node with the desired value, or
     *                 2 - the node to which value should be added
     */
    protected BinaryTree<E> locate(BinaryTree<E> roo, E value)
    {
        if (roo==null||roo.value().compareTo(value)==0)
        {
            return roo;
        }
        if (value.compareTo(roo.value())<0) {
        	return locate(roo.left,value);
        }
        return locate(roo.right,value);
    }

    protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }
    
    protected BinaryTree<E> successor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.right();
        while (!result.left().isEmpty()) {
            result = result.left();
        }
        return result;
    }

    /**
     * Add a (possibly duplicate) value to binary search tree
     *
     * @post Adds a value to binary search tree
     * 
     * @param val A reference to non-null object
     */
    public void add(E value)
    {
        root = add(root,value);
    }

    /**
     * Add a (possibly duplicate) value to binary search tree
     *
     * @post Adds a value to binary search tree
     * 
     * @param val A reference to non-null object
     */
    public BinaryTree<E> add(BinaryTree<E> arbol, E value)
    {
        if (arbol == null){
            arbol = new BinaryTree<E>(value);
            return arbol;
        }
        if (value.compareTo(arbol.value())<0){
            arbol.left = add(arbol.left, value);
        } else if (value.compareTo(arbol.value())>0){
            arbol.right = add(arbol.right, value);
        }
        return arbol;
    }

    /**
     * Determines if the binary search tree contains a value
     *
     * @post Returns true iff val is a value found within the tree
     * 
     * @param val The value sought.  Should be non-null
     * @return True iff the tree contains a value "equals to" sought value
     */
    public boolean contains(E value)
    {
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.value());
    }

    /**
     * Returns reference to value found within three.  This method can
     * be potentially dangerous if returned value is modified: if 
     * modification would change the relation of value to others within
     * the tree, the consistency of the structure is lost
     * <b>Don't modify returned value</b>
     *
     * @post Returns object found in tree, or null
     * 
     * @param val Value sought from within tree
     * @return A value "equals to" value sought; otherwise null
     */
    public E get(E value)
    {
        BinaryTree<E> possibleLocation = locate(root,value);
        if (possibleLocation==null)
          return null;
        else
          return possibleLocation.value();
    }


    /**
     * Returns the hashCode of the value stored by this object.
     *
     * @return The hashCode of the value stored by this object.
     */
    public int hashCode(){
        return root.hashCode();
    } 

    /**
     * Returns a string representing tree
     *
     * @post Generates a string representation of the BST
     * 
     * @return String representation of tree
     */
    public String toStringOrder()
    {
        StringBuffer s = new StringBuffer();
        s.append("<");
        if (!root.isEmpty()) {
            String h = inOrder(root,"");
            h = h.substring(0,h.length()-2);
            s.append(h);
        }
        s.append(">");
        return s.toString();
    }

    /**
     * InOrder 
     */
    public String inOrder(BinaryTree<E> tree, String s)
    {
        if (tree != null){
            s = inOrder(tree.left(),s);
            s+= tree.value().toString()+", ";
            s = inOrder(tree.right,s);
        }
        return s;
    }
}
