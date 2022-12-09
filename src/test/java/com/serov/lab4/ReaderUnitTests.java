package com.serov.lab4;

import org.junit.jupiter.api.TestInstance;

import com.opencsv.exceptions.CsvValidationException;
import com.serov.Classes.Person;
import com.serov.Classes.Reader;
import com.serov.Classes.Division;
import com.serov.Enums.Gender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Testing the Reader implementation
 * @author n.a.serov
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ReaderUnitTests {
    /**
     * Default test class constructor without parameters
     */
    public ReaderUnitTests() {}
    /**
     * Instance of a reader
     */
    private static Reader reader;
    /**
     * Path to test file
     */
    private static String path = "src/test/resources/foreign_names.csv";
    /**
     * Line block separator
     */
    private static char separator = ';';
    /**
     * Separated blocks count
     */
    private static int blockCount = 4;
    /**
     * Creating a new comparator before executing the tests
     */
    @BeforeEach
    public void setUp() {
        reader = new Reader(path, blockCount, separator);
    }
    /**
     * Checking if LinkedList is quicker at inserting elements to the beginning
     * @throws IOException on unit test error (should not happen)
     * @throws CsvValidationException on unit test error (should not happen)
     */
    @Test
    public void testReaderParsesCorrectly() throws IOException, CsvValidationException {
        reader.parseCSV();
        LinkedList < Person > parsed = reader.getPersonList();
        LinkedList < Person > awaited = new LinkedList < Person > ();
        Division division = new Division("I");
        division.id = 0;
        Person person = new Person(28281, "Aahan", Gender.valueOf("Male"), division, 4800.0, "15.05.1970");
        awaited.add(person);
        division = new Division("J");
        division.id = 1;
        person = new Person(28282, "Aala", Gender.valueOf("Female"), division, 2600.0, "07.02.1983");
        awaited.add(person);
        division = new Division("F");
        division.id = 2;
        person = new Person(28283, "Aaleahya", Gender.valueOf("Female"), division, 1000.0, "06.11.1949");
        awaited.add(person);
        division = new Division("I");
        division.id = 0;
        person = new Person(28284, "Aaleyah", Gender.valueOf("Female"), division, 1000.0, "04.02.1944");
        awaited.add(person);
        for (int i = 0; i < 4; i++) {
            assertTrue(parsed.get(i).id == awaited.get(i).id);
            assertTrue(parsed.get(i).name.equals(awaited.get(i).name));
            assertTrue(parsed.get(i).gender == awaited.get(i).gender);
            assertTrue(parsed.get(i).division.id == awaited.get(i).division.id);
            assertTrue((parsed.get(i).division.name).equals(awaited.get(i).division.name));
            System.out.println(parsed.get(i).salary + '\n' + awaited.get(i).salary);
            assertTrue(parsed.get(i).salary.toString().equals(awaited.get(i).salary.toString()));
            assertTrue(parsed.get(i).dateOfBirth.equals(awaited.get(i).dateOfBirth));
        }
    }
}