package backend.service.delete_recipe;

import backend.entity.Recipe;
import view.recipe_objects.Triplet;

public class DeleteRecipeInputData {
    private final String cookbookName;
    private final Triplet[] recipes;

    public DeleteRecipeInputData(String cookbookName, Triplet[] recipes){
        this.cookbookName = cookbookName;
        this.recipes = recipes;
    }
  
    public String getCookbookName() {return cookbookName;}

    public Triplet[] getRecipes() {
        return recipes;
    }
}
