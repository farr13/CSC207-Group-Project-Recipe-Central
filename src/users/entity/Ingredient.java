package users.entity;

public class Ingredient{
    private String name;
    private String measureType; //Quantity could be count, cups, tsp, lbs, ... etc.
    private double quantity;

    public Ingredient(String name, String measureType, double quantity){
        this.name = name;
        this.measureType = measureType;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public String getMeasureType(){
        return measureType;
    }

    public double getQuantity(){
        return quantity;
    }

    public String giveAmount(){
        if (measureType.equals("<unit>"))
            return Double.toString(quantity); // removes count from output
        return Double.toString(quantity) + " " + measureType;
    }

    public String giveNameAmount(){
        if (measureType.equals("<unit>"))
            return name + " " + Double.toString(quantity); // removes count from output
        return name + " " + Double.toString(quantity) + " " + measureType;
    }
}