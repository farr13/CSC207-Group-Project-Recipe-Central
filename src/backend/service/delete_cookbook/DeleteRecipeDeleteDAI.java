package backend.service.delete_cookbook;

import backend.entity.Cookbook;
import backend.entity.Recipe;

public interface DeleteRecipeDeleteDAI {
    public void deleteRecipe(String cookbookName, String recipeName) throws Exception;
}
