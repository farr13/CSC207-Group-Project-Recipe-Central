package backend.service.add_recipe;

import backend.entity.Cookbook;
import backend.entity.Recipe;

public interface AddRecipeDAI {
    void addRecipe(Cookbook cookbook, Recipe recipe) throws Exception;

    Cookbook getCookbook(String cookbookName) throws Exception;
}
