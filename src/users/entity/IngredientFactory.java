package users.entity;

import users.entity.Ingredient;

public class IngredientFactory {

    public static Ingredient createIngredient(String name, String measureType, double quantity) {
        validateIngredientParameters(name, measureType, quantity);
        return new Ingredient(name, measureType, quantity);
    }

    public static Ingredient createUnitIngredient(String name, double quantity) {
        validateIngredientParameters(name, "<unit>", quantity);
        return new Ingredient(name, "<unit>", quantity);
    }

    public static Ingredient createIngredientWithDefaultQuantity(String name) {
        return new Ingredient(name, "<unit>", 1.0);
    }

    private static void validateIngredientParameters(String name, String measureType, double quantity) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingredient name cannot be null or empty");
        }
    }
}
