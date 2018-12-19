package util;

import java.util.*;

public class UnionFindSet<E> {
    /*
     * Field:
     * ancestor: a map to associate each element with its root
     * connectedComponents: a map to associate all its connected neighbors
     * components: an integer to record all isolated components in the graph
     */
    private Map<E, E> ancestor;
    private Map<E, Set<E>> connectedComponents;
    private int components;



    /*
     * Constructor
     */
    public UnionFindSet() {
        this.ancestor = new HashMap<E, E>();
        this.connectedComponents = new HashMap<E, Set<E>>();
        this.components = 0;
    }



    /*
     * Behaviors
     */
    /**
     * @param e: element to be added into data structure
     * @return whether operation is being successfully processed(false if this element is already existed)
     */
    public boolean add(E e) {
        if (this.ancestor.containsKey(e)) {
            return false;
        } else {
            this.ancestor.put(e, e);
            this.connectedComponents.put(e, new HashSet<E>(Arrays.asList(e)));
            this.components++;
            return true;
        }
    }



    /**
     * @param c: a collection with all its elements to be added into data structure
     * @return whether each elements has been successfully added into the data structure(not existed yet)
     */
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            if (!add(e)) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param e1, e2: elements to be compared
     * @return whether operation is being successfully processed(false if any of these elements are not existed, or elements are already connected)
     */
    public boolean connect(E e1, E e2) {
        if (!this.contains(e1) || !this.contains(e2)) {
            return false;
        }

        E root_e1 = getAncestor(e1);
        E root_e2 = getAncestor(e2);

        if (root_e1.equals(root_e2)) {
            return false;
        }

        this.ancestor.put(root_e1, root_e2);
        this.connectedComponents.get(root_e2).addAll(this.connectedComponents.get(root_e1));
        this.connectedComponents.remove(root_e1);
        this.components--;
        return true;
    }



    /**
     * @param e: element given
     * @return root of this given element
     */
    private E getAncestor(E e) {
        /// Base case
        if (this.ancestor.get(e).equals(e)) {
            return e;
        }

        /// Divide
        E root = this.getAncestor(this.ancestor.get(e));

        /// Conquer
        this.ancestor.put(e, root);
        return root;
    }



    /**
     * @param e1, e2: elements to be compared
     * @return whether two given elements are connected
     */
    public boolean isConnected(E e1, E e2) {
        E root_e1 = getAncestor(e1);
        E root_e2 = getAncestor(e2);

        return (root_e1.equals(root_e2));
    }



    /**
     * @param e: element given
     * @return all connected components of this element
     */
    public Set<E> getConnectedComponents(E e) {
        E root = this.getAncestor(e);
        return this.connectedComponents.get(root);
    }



    /**
     * @param e: element given
     * @return count of all connected components of this element
     */
    public int getConnectedComponentsSize(E e) {
        E root = this.getAncestor(e);
        return this.connectedComponents.get(root).size();
    }



    /**
     * @return all isolated connected components as organized in sets
     */
    public Set<Set<E>> connectedComponents() {
        Set<Set<E>> connectedComponnets = new HashSet<Set<E>>();
        for (E root : this.connectedComponents.keySet()) {
            connectedComponnets.add(this.connectedComponents.get(root));
        }
        return connectedComponnets;
    }



    /**
     * Clear current data structure
     */
    public void clear() {
        this.ancestor = new HashMap<E, E>();
        this.connectedComponents = new HashMap<E, Set<E>>();
        this.components = 0;
    }

    /**
     * @param o: element given
     * @return whether this object is in the data structure
     */
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        return this.ancestor.containsKey((E) o);
    }



    /**
     * @param c: a collection with all its elements to be checked
     * @return whether all its elements are in the data structure
     */
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }


    /**
     * @return whether this data structure is empty
     */
    public boolean isEmpty() {
        return this.ancestor.keySet().isEmpty();
    }



    /**
     * @return count of all element in this data structure
     */
    public int size() {
        return this.ancestor.keySet().size();
    }



    /**
     * @return count of connected components in the data structure
     */
    public int components() {
        return this.components;
    }



    /**
     * @return transferred array of all elements in the data structure
     */
    public Object[] toArray() {
        return this.ancestor.keySet().toArray();
    }

}
