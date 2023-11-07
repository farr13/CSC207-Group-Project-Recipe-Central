import users.entity.Ingredient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recipe implements Iterable<Ingredient> {
    private String name;
    private List<Ingredient> ingredients;
    private String instructions; // Instructions as a single String

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.instructions = "";
    }

    // Get the recipe name
    public String getName() {
        return name;
    }

    // Set the recipe name
    public void setName(String name) {
        this.name = name;
    }

    // Get a copy of the ingredient list to prevent modification
    public List<Ingredient> getIngredientList() {
        return new ArrayList<>(ingredients);
    }

    // Add an ingredient to the recipe
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    // Get the instructions for the recipe
    public String getInstructions() {
        return instructions;
    }

    // Set the instructions for the recipe
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // Implement the Iterable interface for ingredients
    @Override
    public Iterator<Ingredient> iterator() {
        return ingredients.iterator();
    }
}
