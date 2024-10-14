package com.wyattfredrickson;
import java.util.Random;


/**
 * 
 * RandomList<E> is a generic class that stores a list of elements of type E and provides methods to add, remove, and access elements in the list.
 * This is a doubly linked list data structure that allows for random access to elements in the list.
 *
 */
public class RandomList<E> { 
    private Node<E> head; // Reference to the first node in the list
    private Node<E> tail; // Reference to the last node in the list
    private int size; // The current number of elements in the list
    private Random random; // Random number generator to be used for random operations


    /**
     * Constructor for generating a new RandomList object concrete instance
     */
    public RandomList() {
        head = null; // Initialize the head of the list to null
        tail = null;  // Initialize the tail of the list to null
        size = 0; // Initialize the size of the list to 0
        random = new Random(); // Initialize the random number generator
    }


    /**
     * Method to add an element to the list at a random index between 0 and the size of the list
     * If the random index is 0, the element is added to the front of the list
     * If the random index is the size of the list, the element is added to the end of the list
     * Otherwise, the element is added to the middle of the list
     * @param element the element to be added to the list
     */
    public void randomAdd(E element) {
        int randomIndex = random.nextInt(size + 1); // Generate a random index between 0 and the size of the list
        Node<E> newNode = new Node<>(element); // Create a new node with the input element

        // For inserting in the front of the list
        if (randomIndex == 0) { // If the random index is 0, add the new node to the front of the list
            newNode.next = head; // Set the new nodes next reference to the current head
            if (head != null) { // If the list is not empty
                head.previous = newNode; // Set the current heads previous reference to the new node
            } 
            head = newNode; // Set the head of the list to the new node
            if (size == 0) { // If the list is empty
                tail = newNode; // If the list is empty, set the tail to the new node
            }
        } else if (randomIndex == size) { // If the random index is the size of the list, add the new node to the end of the list
            newNode.previous = tail; // Set the new nodes previous reference to the current tail
            if (tail != null) {
                tail.next = newNode; // Set the current tails next reference to the new node
            }
            tail = newNode; // Set the tail of the list to the new node 
        } else {
            // For inserting the new node in the middle of the list
            Node<E> current = head; // Assign the current node to the head of the list
            for (int i = 0; i < randomIndex; i++) { // Traverse the list to the random index
                current = current.next; // Assign the current node to the next node
            }
            newNode.previous = current.previous; // Assign the new nodes previous reference to the current nodes previous reference
            newNode.next = current; // Assign the new nodes next reference to the current node
            current.previous.next = newNode; // Assign the current nodes previous nodes next reference to the new node
            current.previous = newNode; // Assign the current nodes previous reference to the new node
            }
            size++; // Increment the size of the list by 1
        } 
        

    /**
     * Method to remove a random element from the list
     * @return the element that was removed from the list
     */
    public E randomRemove() {
        int randomIndex = random.nextInt(size); // Generate a random index between 0 and the size of the list
        Node<E> current = head; // Create a reference to the head of the list
        for (int i = 0; i < randomIndex; i++) { // Traverse the list to the random index
            current = current.next; // Assign the current node to the next node
        }
        // Remove the current node at the position of the random index and adjust the next & previous reference pointers
        if (current.previous != null) {
            current.previous.next = current.next; // Assign the previous nodes next reference to the current nodes next reference
        } else {
            head = current.next; // Assign the head of the list to the current nodes next reference
        }

        if (current.next != null) { // If the current node next reference is not null (i.e. the current node is not the tail of the list) 
            current.next.previous = current.previous; // Assign the next nodes previous reference to the current nodes previous reference
        } else {
            tail = current.previous; // Assign the tail of the list to the current nodes previous reference
        }
        size--; // Decrement the size of the list by 1
        return current.element; // Return the element that was removed
    }
                

    /**
     * Method to return a random element from the list
     * @return return a random element from the list
     */
    public E randomElement() {
        // Generate a valid random index within the bounds of the list size
        int randomIndex = random.nextInt(size);
        Node<E> current = head; // Create a reference to the head of the list to start at the beginning to traverse the list

        for (int i = 0; i < randomIndex; i++) { // Traverse the list to the random index
            current = current.next; // Assigning the current node to the next node
        }
        return current.element; // Return the element at the random index
    }


    /**
     * Method to print the list of elements in the list
     */
    public void printList() {
        // Check if the list is empty
        if (size == 0) {
            System.out.println("The list is empty!!"); // Print a message that the list is empty
            return; // Exit the method
        } 
        Node<E> current = head; // Create a reference to the head of the list to start at the beginning to traverse the list
        while (current != null) {
            System.out.println(current.element); // Print the element at the current node
            current = current.next; // Assign the current node to the next node
        }
    }


    /**
     * Method to print the list of elements in the list in reverse order
     */
    public void printReversedList() {
        // Check if the list is empty
        if (size == 0) {
            System.out.println("The list is empty!!"); // Print a message that the list is empty
            return; // Exit the method
        }
        Node<E> current = tail; // Create a reference to the tail of the list to start at the end to traverse the list in reverse
        while (current != null) { // While the current node is not null
            System.out.println(current.element); // Print the element at the current node
            current = current.previous; // Assign the current node to the previous node
        }
    }


    /**
     * 
     * Method will get and return the element stored at the specified index in the list
     * If the index is out of bounds, the method will throw an IndexOutOfBoundsException else it will return the element at the specified index
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * 
     */
    public E get(int index) {
        // Check if the index is out of bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds!!"); // Throws an IndexOutOfBoundsException if the index is out of bounds
        }
        Node<E> current = head; // Create a reference to the head of the list to start at the beginning to traverse the list
        for(int i = 0; i < index; i++) {
            current = current.next; // Assign the current node to the next node
        }
        return current.element; // Return the element at the specified index
    } 

}