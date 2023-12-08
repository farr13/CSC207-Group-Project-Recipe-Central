package backend.entity;

import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public class Ingredient{
    private final String textDescription;
    /** Initializes a new Ingredient Object.
     * @param textDescription a text description of this ingredient */
    public Ingredient(String textDescription) {
        this.textDescription = textDescription;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Ingredient) {
            return Objects.equals(textDescription, ((Ingredient) o).textDescription);
        } return false;
    }
    public String getTextDescription() {
        return textDescription;
    }
}

// Unused code fragments
//    public Ingredient(String name, String measureType, double quantity){
//        this.name = name;
//        this.measureType = measureType;
//        this.quantity = quantity;
//    }
//    public String getName(){
//        return name;
//    }
//    public String getMeasureType(){
//        return measureType;
//    }
//    public double getQuantity(){
//        return quantity;
//    }
//    public String giveAmount(){
//        if (measureType.equals("<unit>"))
//            return Double.toString(quantity); // removes count from output
//        return Double.toString(quantity) + " " + measureType;
//    }
//
//    public String giveNameAmount(){
//        if (measureType.equals("<unit>"))
//            return name + " " + Double.toString(quantity); // removes count from output
//        return name + " " + Double.toString(quantity) + " " + measureType;
//    }
