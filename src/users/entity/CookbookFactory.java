package users.entity;

import java.util.ArrayList;

public class CookbookFactory {

    public static Cookbook createCookbook(String name, ArrayList<Recipe> recipes) {
        return new Cookbook(name, recipes);
    }

    public static Cookbook createEmptyCookbook(String name) {
        return new Cookbook(name, new ArrayList<>());
    }

    public static Cookbook createCookbookWithDefaultRecipes(String name) {
        // Create a cookbook with some default recipes
        ArrayList<Recipe> defaultRecipes = new ArrayList<>();
        defaultRecipes.add(new Recipe("Default Pasta", "Instructions for default pasta"));
        defaultRecipes.add(new Recipe("Default Cake", "Instructions for default pasta"));
        return new Cookbook(name, defaultRecipes);
    }

    public static Cookbook createRandomizedCookbook(String name, int numRecipes) {
        // Create a cookbook with a specified number of randomly generated recipes
        ArrayList<Recipe> randomRecipes = generateRandomRecipes(numRecipes);
        return new Cookbook(name, randomRecipes);
    }

    private static ArrayList<Recipe> generateRandomRecipes(int numRecipes) {
        // Logic to generate random recipes (replace with your implementation)
        ArrayList<Recipe> randomRecipes = new ArrayList<>();
        for (int i = 1; i <= numRecipes; i++) {
            String recipeName = "Random Recipe " + i;
            String instructions = "Instructions for " + recipeName;
            randomRecipes.add(new Recipe(recipeName, instructions));
        }
        return randomRecipes;
    }

}
