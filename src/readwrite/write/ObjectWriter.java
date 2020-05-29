package readwrite.write;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class ObjectWriter <T> extends Writer {

    private static File file;

    public void writeData(T object, String type) {
        try {

            file = new File("D:\\Facultate\\PAO\\ProiectPAO\\src\\readwrite\\resources\\" + type +"Write.csv");
            FileWriter outputFile = new FileWriter(file, true);

            CSVWriter writer = new CSVWriter(outputFile);

            String[] messageToCsv = {object.toString()};

            writer.writeNext(messageToCsv);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}