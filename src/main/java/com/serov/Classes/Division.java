package com.serov.Classes;

/**
 * Division class containing division ID and name
 * @author n.a.serov
 */
public class Division {
    /**
     * Private static ID field for giving a different value for each class instance
     */
    private static int ID = 0;
    /**
     * id different for each Division instance
     */
    public int id;
    /**
     * Name of division
     */
    public String name;
    /**
     * Default constructor that creates a Division instance with unique id and name
     * @param name Division's given name
     */
    public Division(String name) {
        this.id = Division.ID++;
        this.name = name;
    }
    /**
     * Overridden toString function to print the division as a string
     * @return returns the division as a string 
     */
    @Override
    public String toString() {
        return "DivisionID: " + this.id + "\nDivision name: " + this.name;
    }
}