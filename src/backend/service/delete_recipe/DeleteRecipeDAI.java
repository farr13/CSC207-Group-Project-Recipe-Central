package backend.service.delete_recipe;

import backend.entity.Cookbook;
import backend.entity.Recipe;

public interface DeleteRecipeDAI {
    public void removeRecipe(String cookbookName, String recipeName) throws Exception;

}