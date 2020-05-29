package models;

import readwrite.write.Writer;

public class Standard extends Seat {
    private final Writer audit = new Writer();

    public Standard(int number, int row) {
        super(number, row);
        visibility = 1;
        price = 50;
        type = "Standard";
    }

    public Standard(int number, int row, String type){
        super(number, row);
        visibility = 1;
        this.type = type;
        audit.writeData("Standard", "constructor");
    }


    public Standard() {
        visibility = 1;
        price = 50;
    }

    @Override
    void setType() {
        type = "Standard";
    }

    @Override
    public double getPrice() {
        return 50;
    }


    @Override
    public String toString() {
        return (super.toString() + " StandardSeat seat");
    }

}
