package users.service.delete_cookbook;

import users.entity.Recipe;

public interface DeleteRecipeDataAccessInterface {
    public void removeRecipe(Recipe recipe);
}
