package com.wyattfredrickson;


/**
 * Node<E> is a generic class that stores an element of type E and a reference to the "next" and "previous" nodes in a doubly linked list.
 */
public class Node<E> {

    E element; // Element to be stored in the node
    Node<E> next; // Reference to the next node in the list
    Node<E> previous; // Reference to the previous node in the list

    /**
     * Constructor for a node
     * @param element the element to be stored in the node
     */
    public Node(E element) {
        this.next = null; // Initialize the next node to null
        this.previous = null; // Initialize the previous node to null
        this.element = element; // Set the element of the node to the input element 
    }
}