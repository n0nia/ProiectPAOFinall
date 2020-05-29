package readwrite.read;

import models.Performance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PerformanceReader extends Reader<Performance> {

    private static List<Performance> performanceList = new ArrayList<>();

    public static void readData() {

        PerformanceReader performanceReader = new PerformanceReader();

        performanceList = performanceReader.readAndCreateObjects(
                "F:\\FMI\\Anul_II\\Sem_2\\PAO\\Proiect-PAO-master\\src\\readwrite\\resources\\Performances.csv");

        for (Performance performance : performanceList) {
            System.out.println(performance);
        }
    }

    public static List<Performance> getPerformanceList() {
        return Collections.unmodifiableList(performanceList);
    }

    @Override
    Performance createObject(String[] objectDetails) {
        return new Performance(objectDetails[0], objectDetails[1], objectDetails[2], Integer.parseInt(objectDetails[3]));
    }
}