package users.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recipe {
    private List<Ingredient> ingredients;
    private String name;
    private String instructionsURL;

    public Recipe(String name, String instructionsURL) {
        this.name = name;
        ingredients = new ArrayList<>();
        this.instructionsURL = instructionsURL;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public String getInstructions() { return instructionsURL; }

    public List<Ingredient> getIngredientList() {
        return ingredients;
    }
}
