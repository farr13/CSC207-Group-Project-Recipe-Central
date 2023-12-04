package backend.adapters;

import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class TripletsToRecipeBlocks {
    private TripletsToRecipeBlocks(){}
    public static String[] convert(Triplet[] recipes){
        ArrayList<String> recipeBlocks = new ArrayList<String>();
        for (Triplet recipe: recipes){
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
