package node;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446

/**
 * A generic interface representing a list.
 *
 * @param <T> the type of elements in the list
 */
public interface List<T> {
        /**
         * Checks if the list is empty.
         *
         * @return true if the list is empty, false otherwise
         */
        boolean isEmpty();
        int size();
        void addFirst(T data);
        void addLast(T data);
        T remove(T data);
        void clear();
        boolean contains(T data);
        void printForward();
        void printBackward();




    }


