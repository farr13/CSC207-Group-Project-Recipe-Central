package backend.adapters;

import view.recipe_objects.Triplet;

import java.util.ArrayList;

/** A class for converting a list of strings representing recipes to a list of Triplet adapters. */
public class TripletsToRecipeBlocks {
    /** Converts a list of strings representing recipes to a list of Triplet adapters.
     * @param recipes String[]
     * @return Sting[] */
    public static String[] convert(Triplet[] recipes){
        ArrayList<String> recipeBlocks = new ArrayList<>();
        for (Triplet recipe: recipes) {
            StringBuilder temp;
            String[] ingredients = recipe.getList();
            temp = new StringBuilder(("<html>Recipe:<html>  " + "<html>_" + recipe.getName() + "_<html>" + "<br>Instructions: _"
                    + recipe.getLink() + "_<br> Ingredients:_"));
            for (String ingredient: ingredients){
                temp.append(" ").append(ingredient).append(",");
            }
            temp.append("_<br> <br>");
            recipeBlocks.add(temp.toString());
        }
        return recipeBlocks.toArray(new String[0]);
    }
}
