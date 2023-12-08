package backend.adapters;

import view.recipe_objects.Triplet;

import java.util.ArrayList;

/** A class for converting a list of strings representing a recipe to a list of Triplet adapters. */
public class RecipeBlocksToTriplets {
    /** Converts a list of strings representing a recipe to a list of Triplet adapters.
     * @param recipeBlocks String[]
     * @return Triplet[] */
    public static Triplet[] convert(String[] recipeBlocks) {
        ArrayList<Triplet> triplets = new ArrayList<>();
        for (String recipeBlock: recipeBlocks) {
            String[] sectioned = recipeBlock.split("_");
            String name = sectioned[1];
            String link = sectioned[3];
            String[] listTemp = sectioned[5].split(",");
            ArrayList<String> listFinal = new ArrayList<>();
            for(String ingredient: listTemp)
                listFinal.add(ingredient.trim());
            triplets.add(new Triplet(name, link, listFinal.toArray(new String[0])));
        }

        return triplets.toArray(new Triplet[0]);
    }
}
