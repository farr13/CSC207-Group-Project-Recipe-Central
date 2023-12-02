package users.entity;

import java.util.ArrayList;
import java.util.List;

public class CookbookFactory {

    public static Cookbook createCookbook(String name, List<Recipe> recipes) {
        validateInput(name, recipes);
        return new Cookbook(name, new ArrayList<>(recipes));
    }

    public static Cookbook createEmptyCookbook(String name) {
        validateInput(name, null);
        return new Cookbook(name, new ArrayList<>());
    }

    public static Cookbook createCookbookWithDefaultRecipes(String name, List<Recipe> defaultRecipes) {
        validateInput(name, defaultRecipes);
        return new Cookbook(name, new ArrayList<>(defaultRecipes));
    }

    public static Cookbook createRandomizedCookbook(String name, int numRecipes) {
        validateInput(name, null);
        ArrayList<Recipe> randomRecipes = generateRandomRecipes(numRecipes);
        return new Cookbook(name, randomRecipes);
    }

    private static ArrayList<Recipe> generateRandomRecipes(int numRecipes) {
        ArrayList<Recipe> randomRecipes = new ArrayList<>();
        for (int i = 1; i <= numRecipes; i++) {
            randomRecipes.add(createRandomRecipe("Random Recipe " + i));
        }
        return randomRecipes;
    }

    private static Recipe createRandomRecipe(String name) {
        return new Recipe(name, "Instructions for " + name);
    }

    private static void validateInput(String name, List<Recipe> recipes) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (recipes != null && recipes.contains(null)) {
            throw new IllegalArgumentException("Recipe list cannot contain null elements");
        }
    }
}
