package com.serov.Classes;

import com.serov.Enums.Gender;

/**
 * Person class containing ID, name, gender, Division, salary and date of birth
 * @author n.a.serov
 */
public class Person {
    /**
     * Person's id
     */
    public int id;
    /**
     * Person's name
     */
    public String name;
    /**
     * Person's gender
     */
    public Gender gender;
    /**
     * Person's division
     */
    public Division division;
    /**
     * Person's salary
     */
    public Double salary;
    /**
     * Person's date of birth
     */
    public String dateOfBirth;
    /**
     * Default constructor that creates a Division instance with unique id, name, gender, Division, salary and date of birth
     * @param id Person's id
     * @param name Person's name
     * @param gender Person's gender
     * @param division Person's division
     * @param salary Person's salary
     * @param dateOfBirth Person's date of birth
     */
    public Person(int id, String name, Gender gender, Division division, Double salary, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.division = division;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }
    /**
     * Overridden toString function to return the person as a string
     * @return returns the person as a string
     */
    @Override
    public String toString() {
        return "PersonID: " + this.id + "\nName: " + this.name + "\nGender: " + this.gender + "\nDivision: \n" + this.division + "\nSalary: " + this.salary + "\nDate of birth: " + this.dateOfBirth;
    }
}