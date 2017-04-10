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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Victor Babin
 */
public class DataCSV {
    private ArrayList<String> positionList;
    private ArrayList<String> velocityList;
    private ArrayList<String> accelerationList;
    private File csvFile;
    private CSVWriter csvWriter;
    private CSVReader csvReader;
    
    public DataCSV(String pathToCSV) throws FileNotFoundException {
//        this.csvFile = new File("/src/resources/local.csv");
        this.csvFile = new File(pathToCSV);
        this.csvWriter = new CSVWriter(new PrintWriter(csvFile));
        this.positionList = new ArrayList<>();
        this.velocityList = new ArrayList<>();
        this.accelerationList = new ArrayList<>();
    }
    public ArrayList<Double> parseCSV(){
        //TODO
        
        return null;
        
    }
    public ArrayList<Double> parseCSV(String pathToCSV){
        //TODO
        return null;
        
    }
    
}
