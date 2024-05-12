package node;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446

/**
 * Represents a doubly linked list data structure.
 *
 * @param <T> the type of elements stored in the list
 */
public class DoublyLinkedList<T> implements List {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructs an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size==0)
            return true;

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(Object data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()){
            head=newNode;
            tail=newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head=newNode;
        }
        size++;



    }

    @Override
    public void addLast(Object data) {
        Node<T> newNode = new Node(data);
        if (isEmpty()){
            head = newNode;
        }else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object remove(Object data) {
        if (head == null)
            return null;

        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current == head) {
                    head = current.next;
                    if (head != null)
                        head.previous = null;
                } else {
                    current.previous.next = current.next;
                    if (current.next != null)
                        current.next.previous = current.previous;
                }
                return current.data;
            }
            current = current.next;
        }

        size--;
        System.out.println("Item was not found");
        return null;
    }


    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null){
            current.data=null;
            current=current.next;
            size--;
        }
    }

    @Override
    public boolean contains(Object data) {
        Node<T> current = head;

        if (isEmpty())
            return false;

        while (current != null) {
            if (current.data.equals(data))
                return true;
            else current=current.next;
        }
        return false;
    }

    @Override
    public void printForward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    @Override
    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.previous;
        }
    }



}

