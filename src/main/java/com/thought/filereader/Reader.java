package com.thought.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<String> reader() {
        File file = new File("src/main/resources/csv/details.csv");
        String line;
        String commaSplit = ".";
        List<String> recordsOne = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {

            //Reading the file line by line

            while((line = br.readLine()) != null){
                String[] event = line.split(commaSplit);    //Splitting contents of a line based on regex provided
                recordsOne.add(event[0]+","+event[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordsOne;
    }
}
