package readwrite.read;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Reader<T> {
    CSVReader csvReader = null;

    List<T> readAndCreateObjects(String path) {

        String[] objectDetails = null;

        List<T> objectList = new ArrayList<T>();

        try {
            csvReader = new CSVReader(new FileReader(path), ',', '"', 1);

            while ((objectDetails = csvReader.readNext()) != null) {
                T object = createObject(objectDetails);
                objectList.add(object);
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        return objectList;
    }

    abstract T createObject(String[] objectDetails);
}