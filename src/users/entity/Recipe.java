package users.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private String instructionsURL; // Instructions as a URL link

    public Recipe(String name, String instructionsURL) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (instructionsURL == null || instructionsURL.trim().isEmpty()) {
            throw new IllegalArgumentException("Instructions URL cannot be null or empty");
        }

        this.name = name;
        this.instructionsURL = instructionsURL;
        this.ingredients = new ArrayList<>();
    }

    // Get the recipe name
    public String getName() {
        return name;
    }

    // Get a copy of the ingredient list to prevent modification
    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public String getInstructionsURL() {
        return instructionsURL;
    }

    // Add a single ingredient to the recipe
    public void addIngredient(Ingredient ingredient) {
        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient cannot be null");
        }
        ingredients.add(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return name.equals(recipe.name) &&
                Objects.equals(instructionsURL, recipe.instructionsURL) &&
                Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, instructionsURL, ingredients);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", instructionsURL='" + instructionsURL + '\'' +
                '}';
    }
}