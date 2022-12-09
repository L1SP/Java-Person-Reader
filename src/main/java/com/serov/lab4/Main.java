package com.serov.lab4;

import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;
import com.serov.Classes.Reader;

/**
 * The main application class
 * @author n.a.serov
 */
public class Main {

    /**
     * Default constructor without parameters
     */
    public Main() {}

    /**
     * The main function of the CSV parser program
     * @param args an array of command-line arguments for the application
     * @throws CsvValidationException if got an error while parsing the line
     * @throws IOException if got an error while parsing the file
     */
    public static void main(String[] args) throws CsvValidationException, IOException {
        /**
         * Path to CSV file
         */
        String path = "src/main/resources/foreign_names.csv";
        /**
         * CSV separator
         */
        char separator = ';';
        /**
         * Parsed string blocks count
         */
        int blocksCount = 4;
        /**
         * CSV file reader instance
         */
        Reader reader = new Reader(path, blocksCount, separator);
        reader.parseCSV();
        reader.printParsedCSV();
    }
}