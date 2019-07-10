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
        List<String> records = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {

            while((line = br.readLine()) != null){
                String event = line;
                records.add(event);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
