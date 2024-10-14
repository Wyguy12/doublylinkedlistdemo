package com.wyattfredrickson;


/**
 * ProcessData is a class that stores the name of a process and three integer values associated with the process.
 * It is an easy way to store and access process data in a structured format such as in a .txt file with " | " pipe delimiters."
 */
public class ProcessData {
    String processName; // The name of the process
    int value1; // The first value of the process
    int value2; // The second value of the process
    int value3; // The third value of the process


    /**
     * Constructor for creating a new ProcessData object
     * 
     */
    public ProcessData(String processName, int value1, int value2, int value3) {
        this.processName = processName;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }


    /**
     * Getter method for the process name
     * @return the name of the process
     */
    public String getProcessName() {
        return processName;
    }


    /**
     * Getter methods for the first integer value
     * @return the first integer value
     */
    public int getValue1() {
        return value1;
    }

    
    /**
     * Getter method for the second integer value
     * @return the second integer value
     */
    public int getValue2() {
        return value2;
    }


    /**
     * Getter method for the third integer value
     * @return the third integer value
     */
    public int getValue3() {
        return value3;
    }


    /**
     * 
     * It returns the file in the format: processName | value1 | value2 | value3
     * ProcessList1.txt file would be in the format:
     * Example -    javac|20|3|70
                    javac|45|9|50
                    gcc|4|0|25
                    llvm|44|2|22
                    clang|8|2|100
                    cc|20|4|55
                    ada|33|6|44
                    python|16|5|77
                    perl|77|8|33
     */
    @Override
    public String toString() {
        return processName + "|" + value1 + "|" + value2 + "|" + value3; 
    }

}