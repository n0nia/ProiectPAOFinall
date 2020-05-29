package models;

import readwrite.write.Writer;

public class Loge extends Seat {
    private final Writer audit = new Writer();

    public Loge(int number, int row) {
        super(number, row);
        visibility = 3;
        price = 150;
        type = "Loge";
    }

    public Loge(int number, int row, String type){
        super(number, row);
        visibility = 3;
        this.type = type;
        audit.writeData("Loge", "constructor");
    }

    public Loge() {
        visibility = 3;
        price = 150;
    }

    @Override
    void setType(){
        type = "Loge";
    }

    @Override
    public double getPrice() {
        return 150;
    }


    @Override
    public String toString() {
        return (super.toString() + " Loge seat");
    }
}
