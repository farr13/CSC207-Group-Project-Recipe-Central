package users.service.delete_recipe_from_cookbook.;

import users.entity.Cookbook;
import users.entity.Recipe;

public interface DeleteRecipeDAI {
    /**
     * Deletes a specific recipe from a given cookbook.
     *
     * @param cookbook The cookbook from which the recipe is to be deleted.
     * @param recipeName The name of the recipe to be deleted.
     * @throws Exception if the recipe cannot be deleted.
     */
    void deleteRecipe(Cookbook cookbook, String recipeName) throws Exception;
}
