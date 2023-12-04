package backend.service.add_recipe;

import backend.entity.Cookbook;
import backend.entity.Recipe;

public interface AddRecipeDAI {
    void addRecipe(String[] cookbookNames, Recipe[] recipes) throws Exception;
}
