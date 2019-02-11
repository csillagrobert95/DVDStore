package com.admin.dvdstore.writetofile;

import com.admin.dvdstore.dvd.DVDEntry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Created by Robi on 11/22/2018.
 */
public class WriteDVD {
    public void writeDVDToFile(DVDEntry dvdEntry){

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String fileName = "dvd_entries/DVD" + timeStamp + ".txt";
        File file = new File(fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append("New DVD entry:");
            writer.newLine();
            writer.append("Title: " + dvdEntry.getTitle());
            writer.newLine();
            writer.append("Year: " + dvdEntry.getYear());
            writer.newLine();
            writer.append("Price: " + dvdEntry.getPrice());
            writer.close();
        } catch(IOException e){
            System.out.println("Something went wrong when writing to file!");
            e.printStackTrace();
        }

    }
}
