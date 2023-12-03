package backend.service.delete_recipe;

import backend.entity.Recipe;
import view.recipe_objects.Triplet;

public class DeleteRecipeInputData {
    private final String cookbookName;
    private final Recipe[] recipes;

    public DeleteRecipeInputData(String cookbookName, Recipe[] recipes){
        this.cookbookName = cookbookName;
        this.recipes = recipes;
    }
  
    public String getCookbookName() {return cookbookName;}

    public Recipe[] getRecipes() {
        return recipes;
    }
}
