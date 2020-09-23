package Uppgift2;

public class BST <Key extends Comparable<Key>, Value>{
    private Node root;             // root of BST

    private class Node {
        private final Key key;           // sorted by key
        private Value value;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    /**
     * Returns true if the tablee is empty
     * @return true if the table is empty otherwise false.
     */
    public boolean isEmpty(){
        return size(root) == 0;
    }

    /**
     * Returns the number of elements in the table.
     * @return the size.
     */
    public int size() {
        return size(root);
    }
    private int size(Node node){
        if(node == null)
        return 0;
        else
            return node.size;
    }

    /**
     * Returns the value of a certain key.
     * @param key the key
     * @return the value of the key.
     */
    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node node, Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            return get(node.left, key);
        else if(cmp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    /**
     * Inserts a specific key-value pair into the table.
     * Overwrites the value if the key is already existing.
     * @param key the key
     * @param value the value that we want to add.
     */
    public void put(Key key, Value value){
        root = put(root,key,value);

    }
    private Node put(Node node,Key key, Value value){
        if(node == null)
            return new Node(key,value,1);
        int cmp = key.compareTo(node.key);

        if(cmp < 0)
            node.left = put(node.left, key, value);
        else if(cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.size = size(node.left) + size(node.right) +1;
        return node;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node node){
        if(node.left == null)
                return node;
        else
            return min(node.left);
    }
    public Key max(){
        return max(root).key;
    }
    private Node max(Node node){
        if(node.right == null)
            return node;
        else
            return max(node.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);

        if (cmplo < 0)
            keys(x.left, queue, lo, hi);

        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue(x.key);

        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }
}
