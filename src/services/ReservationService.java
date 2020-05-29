package services;

import models.Reservation;
import models.Performance;
import readwrite.write.Writer;

public class ReservationService {
    private Reservation reservation;
    private final Writer audit = new Writer();

    public boolean confirmReservation(Reservation reservation, String answer) {
        audit.writeData("ReservationService", "confirmReservation");
        return answer.equals("YES");
    }

    public boolean enoughSeatsAvailable(int number, Performance performance) {
        audit.writeData("ReservationService","enoughSeatsAvailable");
        int numberOfSeats = performance.getAvailableSeats().size();
        return numberOfSeats >= number;
    }

  /*  public void chooseSeat(int number, String typeOfSeat, Performance performance){
        audit.writeData("ReservationService", "chooseSeat");
        PerformanceService performanceService = new PerformanceService();
        for (int i = 0; i < number; i++) {
            int index = performanceService.getFirstOfTypeIndex(typeOfSeat, performance);
            if (index != -1) {
                Seat newSeat = performance.getAvailableSeats().get(index);
                reservation.getSeats().add(newSeat);
                performanceService.deleteSeat(index, spectacle);
            }
        }
    }
*/

}
