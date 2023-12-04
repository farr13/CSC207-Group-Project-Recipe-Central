package backend.adapters;

import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class RecipeBlocksToTriplets {
    private RecipeBlocksToTriplets(){}
    public static Triplet[] convert(String[] recipeBlocks){
        ArrayList<Triplet> triplets = new ArrayList<Triplet>();
        for (String recipeBlock: recipeBlocks){
            String[] sectioned = recipeBlock.split("_");
            String name = sectioned[1];
            String link = sectioned[3];
            String[] listTemp = sectioned[5].split(",");
            ArrayList<String> listFinal = new ArrayList<String>();
            for(String ingredient: listTemp)
                listFinal.add(ingredient.trim());
            triplets.add(new Triplet(name, link, listFinal.toArray(new String[0])));
        }

        return triplets.toArray(new Triplet[0]);
    }
}
