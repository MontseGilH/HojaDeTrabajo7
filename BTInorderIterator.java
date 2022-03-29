import java.util.Stack;

public class BTInorderIterator<E>{

    protected BinaryTree<E> root; // root of tree to be traversed
    protected Stack<BinaryTree<E>> todo; // stack of unvisited nodes whose
    public BTInorderIterator(BinaryTree<E> root)

    // post: constructs an iterator to traverse in inorder
    {
        todo = new Stack<BinaryTree<E>>();
        this.root = root;
        reset();
    }
    public void reset()
    // post: resets the iterator to retraverse
    {
        todo.clear();
        // stack is empty.  Push on nodes from root to
        // leftmost descendant
        BinaryTree<E> current = root;
        while (!current.isEmpty()) {
            todo.push(current);
            current = current.left();
        } 
    }

    public boolean hasNext()
    // post: returns true iff iterator is not finished
    {
        return !todo.isEmpty();
    }
    public E get()
    // pre: hasNext()
    // post: returns reference to current value
    {
        return todo.get().value();
    }

    public E next()
    // pre: hasNext();
    // post: returns current value, increments iterator
    {
        BinaryTree<E> old = todo.pop();
        E result = old.value();
        // we know this node has no unconsidered left children;
        // if this node has a right child,
        //   we push the right child and its leftmost descendants:
        // else
        //   top element of stack is next node to be visited
        if (!old.right().isEmpty()) {
            BinaryTree<E> current = old.right();
            do {
                todo.push(current);
                current = current.left();
            } while (!current.isEmpty());
        }
    return result;
    }
}