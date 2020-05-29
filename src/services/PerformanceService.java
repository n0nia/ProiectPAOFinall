package services;

import models.*;
import readwrite.write.Writer;

import java.util.Collections;

public class PerformanceService {
    private final Writer audit = new Writer();

    public void printSeatsAvailable(Performance performance) {
        audit.writeData("PerformanceService", "printSeatsAvailable");
        Balcony a = new Balcony();
        Loge b = new Loge();
        Standard c = new Standard();

        System.out.println("We have " + countAvailableStandardSeats(performance) + " standard seats available at price " + c.getPrice());
        System.out.println("We have " + countAvailableBalcony(performance) + " balcony seats available at price " + a.getPrice());
        System.out.println("We have " + countAvailableLoge(performance) + " loge seats available at price " + b.getPrice());
    }


    int getFirstOfTypeIndex(String s, Performance performance) {
        audit.writeData("PerformanceService", "getFirstOfTypeIndex");
        int i = 0;
        for (Seat x : performance.getAvailableSeats()) {
            if (s.equals("Balcony") && x instanceof Balcony) {
                return i;
            } else if (s.equals("StandardSeat") && x instanceof Standard) {
                return i;
            } else if (s.equals("Loge") && x instanceof Loge) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void displayAvailableSeats(Performance performance) {
        audit.writeData("PerformanceService", "displayAvailableSeats");
        sortAvailableSeats(performance);
        for (Seat x : performance.getAvailableSeats())
            System.out.println(x.toString());
    }

    private int countAvailableStandardSeats(Performance performance) {
        audit.writeData("PerformanceService", "countAvailableStandardSeats");
        int count = 0;
        for (Seat x : performance.getAvailableSeats())
            if (x instanceof Standard)
                count++;
        return count;
    }

    private int countAvailableBalcony(Performance performance) {
        audit.writeData("PerformanceService", "countAvailableBalcony");
        int count = 0;
        for (Seat x : performance.getAvailableSeats())
            if (x instanceof Balcony)
                count++;
        return count;
    }

    private int countAvailableLoge(Performance performance) {
        audit.writeData("PerformanceService", "countAvailableLoge");
        int count = 0;
        for (Seat x : performance.getAvailableSeats())
            if (x instanceof Loge)
                count++;
        return count;
    }

    public void deleteSeat(int i, Performance performance) {
        audit.writeData("PerformanceService", "deleteSeat");
        performance.getAvailableSeats().remove(i);
    }


    public void sortAvailableSeats(Performance performance) {
        audit.writeData("PerformanceService", "sortAvailableSeats");
        Collections.sort(performance.getAvailableSeats());
    }

}
