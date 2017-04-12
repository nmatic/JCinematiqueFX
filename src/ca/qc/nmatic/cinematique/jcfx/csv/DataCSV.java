/*
 * Copyright (C) 2017 Victor Babin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.qc.nmatic.cinematique.jcfx.csv;

import java.util.ArrayList;
import com.opencsv.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Victor Babin
 */
public class DataCSV {
    private File csvOut, csvIn;
    private final CSVWriter csvWriter = new CSVWriter(new FileWriter("/src/resources/output.csv"));
    private final CSVReader csvReader = new CSVReader(new FileReader("/src/resources/input.csv"));;
    private String pathToCSVOut;
    private String pathToCSVIn;
    
    public DataCSV() throws FileNotFoundException, IOException {
        this.csvIn = new File("/src/resources/input.csv");
        this.csvOut = new File("/src/resources/output.csv");
    }

    public void setPathToCSVOut(String pathToCSVOut) {
        this.pathToCSVOut = pathToCSVOut;
    }

    public void setPathToCSVIn(String pathToCSVIn) {
        this.pathToCSVIn = pathToCSVIn;
    }
    
    public List<String[]> readCSV() throws IOException{      
        return csvReader.readAll();
        
    }    
}
