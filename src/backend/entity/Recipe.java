package backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private String instructionsURL; // Instructions as url link

    public Recipe(String name, String instructionsURL) {
        this.name = name;
        ingredients = new ArrayList<>();
        this.instructionsURL = instructionsURL;
        this.ingredients = new ArrayList<>();
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Recipe){
            return (Objects.equals(((Recipe) o).getName(), name) &&
                    Objects.equals(((Recipe) o).getInstructions(), instructionsURL) &&
                    Objects.equals(((Recipe) o).ingredients, ingredients));
        }
        return false;
    }
    // Get the recipe name
    public String getName() { return name; }

    // Get a copy of the ingredient list to prevent modification
    public List<Ingredient> getIngredients() { return ingredients; }

    public String getInstructions() { return instructionsURL; }

}
