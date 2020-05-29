package readwrite.write;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class Writer {

    private static File file = new File("D:\\Facultate\\PAO\\ProiectPAO\\src\\readwrite\\resources\\Audit.csv");

    public void writeData(String className, String methodName) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String threadName = Thread.currentThread().getName();
        try {
            FileWriter outputFile = new FileWriter(file, true);

            CSVWriter writer = new CSVWriter(outputFile);

            String message = "Method " + methodName + " from class " + className + "from thread " + threadName + " was called.";
            String[] messageToCSV = {timestamp.toString(), message};
            System.out.println(timestamp.toString());

            writer.writeNext(messageToCSV);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void writeData(String className, String methodName) {
//
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//        try {
//            FileWriter outputFile = new FileWriter(file, true);
//
//            CSVWriter writer = new CSVWriter(outputFile);
//
//            String message = "Method " + methodName + " from class " + className + " was called.";
//            String[] messageToCSV = {timestamp.toString(), message};
//            System.out.println(timestamp.toString());
//
//            writer.writeNext(messageToCSV);
//
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}