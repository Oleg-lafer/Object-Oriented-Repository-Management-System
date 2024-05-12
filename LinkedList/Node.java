package node;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446
public class Node<T> {
    protected T data;
    protected Node<T> previous;
    protected Node<T> next;
    /**
     * A generic class representing a node in a doubly linked list.
     * @param </T> the type of data stored in the node
     */

    public Node(T data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
    /**
     * Constructs a new Node with the specified data.
     * @param data the data to be stored in the node
     */


    public Node(T data,Node previous,Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }



    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    }
