package models;

public class Balcony extends Seat {
    public Balcony(int number, int row) {
        super(number, row);
        visibility = 2;
        price = 100;
        type = "Balcony";
    }
    public Balcony(int number, int row, String type){
        super(number, row);
        visibility = 2;
        this.type = type;
    }

    public Balcony() {
        visibility = 2;
        price = 100;
    }

    @Override
    void setType(){
        type = "Balcony";
    }

    @Override
    public double getPrice() {
        return 100;
    }


    @Override
    public String toString() {
        return (super.toString() + " Balcony seat");
    }
}
