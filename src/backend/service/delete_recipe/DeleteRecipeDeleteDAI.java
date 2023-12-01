package backend.service.delete_recipe;

import backend.entity.Cookbook;
import backend.entity.Recipe;

public interface DeleteRecipeDeleteDAI {
    public void deleteRecipe(Cookbook cookbook, Recipe recipe) throws Exception;
}
