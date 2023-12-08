package backend.service.delete_recipe;

import backend.entity.Recipe;

public interface DeleteRecipeDAI {
    void deleteRecipe(String cookbookName, Recipe[] recipes) throws Exception;

}