// A class for structuring associations that may be compared.
// (c) 1998, 2001 duane a. bailey

/**
 * </pre>  
 * @version $Id: ComparableAssociation.java 34 2007-08-09 14:43:44Z bailey $
 * @author, 2001 duane a. bailey
 */
public class Association<K extends Comparable<K>,V> implements Comparable<Association<K,V>> 
{
    /**
     * Key and value
     */
    K key;
    V value;

    /**
     * Construct an association that can be ordered, from only a key.
     * The value is set to null.
     *
     * @pre key is non-null
     * @post constructs comparable association with null value
     * 
     * @param key The (comparable) key.
     */
    public Association(K key)
    {
        this.key = key;
        this.value = null;
    }

    /**
     * Construct a key-value association that can be ordered.
     *
     * @pre key is non-null
     * @post constructs association between a comparable key and a value
     * 
     * @param key The (comparable) key.
     * @param value The (possibly comparable) associated value.
     */
    public Association(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    /**
     * Determine the order of two comparable associations, based on key.
     *
     * @pre other is non-null ComparableAssociation
     * @post returns integer representing relation between values
     * 
     * @param other The other comparable association.
     * @return Value less-than equal to or greater than zero based on comparison
     */
    public int compareTo(Association<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    /**
     * Construct a string representation of the ComparableAssociation.
     *
     * @post returns string representation
     * 
     * @return The string representing the ComparableAssociation.
     */
    public String toString()
    {
        
        return key.toString();
    }

    /**
     * Returns the key
     * @return key
     */
    public K getKey(){
        return key;
    }

    /**
     * Returns the value
     * @return value
     */
    public V getValue(){
        return value;
    }

    
}
