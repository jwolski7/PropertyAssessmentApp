package com.example.propertyassessment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenFile {
    ArrayList<String[]> list = new ArrayList<>();

    public void openFile() {
        String data = "";
        String file = "1.csv";
        int count = 0;


        try {
            File myFile = new File(file);
            Scanner inFile = new Scanner(myFile);

            while (inFile.hasNextLine()) {
                count++;
                data = inFile.nextLine();

                if (count > 1) {
                    String[] tok = data.split(",");
                    list.add(tok);
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println ("Couldn't find"+ file+ ".");
        }
    }

    public  ArrayList<String[]> getFile() {
        return list;
    }
}

