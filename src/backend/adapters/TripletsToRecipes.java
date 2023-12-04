package backend.adapters;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class TripletsToRecipes {
    private TripletsToRecipes(){}
    public static Recipe[] convert(Triplet[] triplets){
        ArrayList<Recipe> storedRecipes = new ArrayList<>();
        for (Triplet triplet: triplets){
            ArrayList<Ingredient> storedIngredients= new ArrayList<Ingredient>();
            for (String description: triplet.getList())
                storedIngredients.add(new Ingredient(description));
            Recipe recipeTemp = new Recipe(triplet.getName(), triplet.getLink(), storedIngredients.toArray(new Ingredient[0]));
            storedRecipes.add(recipeTemp);
        }

        return storedRecipes.toArray(new Recipe[0]);
    }
}
