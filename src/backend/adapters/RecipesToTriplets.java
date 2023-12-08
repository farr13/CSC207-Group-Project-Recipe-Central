package backend.adapters;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

/** A class for converting a list of Recipe Objects to a list of Triplet adapters. */
public class RecipesToTriplets {
    /** Converts a list of Recipe Objects to a list of Triplet adapters.
     * @param recipes type Recipe[]
     * @return Triplet[] */
    public static Triplet[] convert(Recipe[] recipes){
        ArrayList<Triplet> triplets = new ArrayList<>();
        for (Recipe recipe: recipes) {
            String name = recipe.getName();
            String link = recipe.getInstructions();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (Ingredient ingredient: recipe.getIngredients())
                arrayList.add(ingredient.getTextDescription());
            triplets.add(new Triplet(name, link, arrayList.toArray(new String[0])));
        }
        return triplets.toArray(new Triplet[0]);
    }
}
