package backend.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private Ingredient[] ingredients;
    private String instructionsURL; // Instructions as url link

    public Recipe(String name, String instructionsURL, Ingredient[] ingredients) {
        this.name = name;
        this.instructionsURL = instructionsURL;
        this.ingredients = ingredients;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Recipe){
            ArrayList<Ingredient> ingredientArrayList = new ArrayList<Ingredient>(Arrays.asList(ingredients)),
                    oArrayList = new ArrayList<Ingredient>(Arrays.asList(((Recipe) o).getIngredients()));
            return (Objects.equals(((Recipe) o).getName(), name) &&
                    Objects.equals(((Recipe) o).getInstructions(), instructionsURL) &&
                    oArrayList.containsAll(ingredientArrayList) && ingredientArrayList.containsAll(oArrayList));
        }
        return false;
    }
    // Get the recipe name
    public String getName() { return name; }

    // Get a copy of the ingredient list to prevent modification
    public Ingredient[] getIngredients() { return ingredients; }

    public String getInstructions() { return instructionsURL; }

}
