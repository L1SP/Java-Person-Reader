package com.serov.Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
// import java.util.TreeSet;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.serov.Enums.Gender;

/**
 * The Reader class implementation
 * @author n.a.serov
 */
public class Reader {
    /**
     * True if the file was parsed, otherwise false
     */
    Boolean fileWasParsed;
    /**
     * Path to CSV file
     */
    private String path = "src/main/resources/foreign_names.csv";
    /**
     * Array for parsing lines
     */
    private String[] line;
    /**
     * CSV separator
     */
    private char separator = ';';
    /**
     * List of persons
     */
    private LinkedList < Person > personList = new LinkedList < Person > ();
    // TODO: Division class must implement Comparable for using TreeSet
    // TreeSet<Division> divisionSet = new TreeSet<Division>();
    /**
     * Set of divisions to make divisions with the same name have the same id
     */
    private HashSet < Division > divisionSet = new HashSet < Division > ();
    /**
     * CSVParser from openCSV, built with the given separator
     */
    private CSVParser csvParser = new CSVParserBuilder().withSeparator(separator).build();

    /**
     * Function for parsing CSV file
     * @throws CsvValidationException if got an error while parsing the line
     * @throws IOException if got an error while parsing the file
     */
    public void parseCSV() throws IOException, CsvValidationException {
        if (!fileWasParsed) {
            try (CSVReader reader = new CSVReaderBuilder(new FileReader(path))
                .withCSVParser(csvParser) // custom CSV parser
                .withSkipLines(1) // skip the first line, header info
                .build();
            ) {
                if (reader == null) {
                    throw new FileNotFoundException(path);
                }
                while ((line = reader.readNext()) != null) {
                    Division division = null;
                    Iterator < Division > iterator = divisionSet.iterator();
                    while (iterator.hasNext()) {
                        Division currDivision = (Division) iterator.next();
                        if (currDivision.name.equals(line[4])) {
                            division = currDivision;
                        }
                    }

                    if (division == null) {
                        division = new Division(line[4]);
                        divisionSet.add(division);
                    }
                    Person person = new Person(Integer.parseInt(line[0]), line[1], Gender.valueOf(line[2]), division, Double.parseDouble(line[5]), line[3]);
                    personList.add(person);
                }
            }
            fileWasParsed = true;
        } else
            System.out.println("The file was already parsed");
    }
    /**
     * Prints the List parsed from the CSV file
     */
    public void printParsedCSV() {
        if (fileWasParsed) {
            Iterator < Person > iterator = personList.iterator();
            while (iterator.hasNext()) {
                Person Person = (Person) iterator.next();
                System.out.println(Person.toString());
            }
        } else
            System.out.println("The file was not parsed yet");
    }
    /**
     * Reader constructor with given file path, line size and separator
     * @param path path to file
     * @param lineSize blocks count in a single string
     * @param separator separator inside the string
     */
    public Reader(String path, int lineSize, char separator) {
        this.path = path;
        this.line = new String[lineSize];
        this.separator = separator;
        this.fileWasParsed = false;
    }
    /**
     * Function for getting the parsed List of Persons
     * @return Returns the parsed list of Persons if the file was parsed, otherwise returns an empty list
     */
    public LinkedList < Person > getPersonList() {
        return this.personList;
    }
}