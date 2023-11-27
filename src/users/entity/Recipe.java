package users.entity;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private Ingredient[] ingredients;
    private String instructionsURL; // Instructions as url link

    public Recipe(String name, String instructionsURL, Ingredient[] ingredients) {
        this.name = name;
        this.instructionsURL = instructionsURL;
        this.ingredients = ingredients;
    }

    // Get the recipe name
    public String getName() { return name; }

    // Get a copy of the ingredient list to prevent modification
    public Ingredient[] getIngredients() { return ingredients; }

    public String getInstructions() { return instructionsURL; }

}
