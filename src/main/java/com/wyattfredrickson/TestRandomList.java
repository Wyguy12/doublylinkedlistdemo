package com.wyattfredrickson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * The test class for the RandomList class
 */
public class TestRandomList {
    public static void main(String[] args) {
        System.out.println("***New RandomList from ProcessFile1.txt***");


        /**
        * 
        * The randomList DoublyLinkedList will store the ProcessList1.txt file in format: processName | value1 | value2 | value3
        * 
        * Example - javac|20|3|70
                    javac|45|9|50
                    gcc|4|0|25
                    llvm|44|2|22
                    clang|8|2|100
                    cc|20|4|55
                    ada|33|6|44
                    python|16|5|77
                    perl|77|8|33
        * So, create a new RandomList object that stores ProcessData objects
        */
        RandomList<ProcessData> randomList = new RandomList<>();
        

        try (BufferedReader br = new BufferedReader(new FileReader("ProcessList1.txt"))) { // Try to read the file using a BufferedReader object
            String line; // Create a string variable to store the line read from the file
            while ((line = br.readLine()) != null) { // While line is not null read the file
                String[] parts = line.split("\\|"); // Split the line by the pipe character

                // Create a new ProcessData object using the parts
                String processName = parts[0]; // Store the first part of the line in the processName variable
                int value1 = Integer.parseInt(parts[1]); // Store the second part of the line in the value1 variable
                int value2 = Integer.parseInt(parts[2]); // Store the third part of the line in the value2 variable
                int value3 = Integer.parseInt(parts[3]); // Store the fourth part of the line in the value3 variable

                // Create a new ProcessData object using the parts and pass arguments, processName, value1, value2, and value3 to the constructor
                // To create a concrete object of the ProcessData class
                ProcessData processData = new ProcessData(processName, value1, value2, value3); 
                randomList.randomAdd(processData); // Assign the ProcessData object to the randomList object using the randomAdd method
            }
        } catch (IOException e) { // Catch any IOExceptions that occur reading the file
            System.err.println("Error reading the file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Displaying list in random order");
        randomList.printList(); // Invokes the printList method to print the list using the element's default toString() method
        System.out.println();

        System.out.println();
        System.out.println("Displaying Reverse list in random order");
        randomList.printReversedList(); // Invokes the printReversedList method to print the list in reverse order using the element's default toString() method
        System.out.println();

        System.out.println();
        System.out.println("Displaying retrieving a random element from the list.");
        System.out.println("Random element: " + randomList.randomElement()); // Print a random element from the list
        System.out.println();

        System.out.println();
        System.out.println("Displaying retrieving another random element from the list.");
        System.out.println("Random element: " + randomList.randomElement()); // Print a random element from the list
        System.out.println();

        System.out.println();
        System.out.println("Displaying removing a random element from the list.");
        System.out.println("Removed element: " + randomList.randomRemove()); // Print the removed element from the list
        System.out.println();

        System.out.println();
        System.out.println("Re-displaying list in random order after removing a random element.");
        randomList.printList(); // Invokes the printList method to print the list using the element's default toString() method
        System.out.println();

        System.out.println();
        System.out.println("Display adding a random element to the list: " +  "python|16|5|77" );
        randomList.randomAdd(new ProcessData("python", 16, 5, 77)); // Add a random element to the list
        System.out.println("Re-displaying list in random order after adding a random element.");
        randomList.printList(); // Invokes the printList method to print the list using the element's default toString() method
        System.out.println();
        
        System.out.println();
        System.out.println("Displaying getting a element at index 2.");
        try {
            System.out.println("Index 2: " + randomList.get(2)); // Print the element at index 2
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The index is out of bounds." + e.getMessage());
        }
        System.out.println();


    }
}