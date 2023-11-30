package backend.service.delete_cookbook;

import backend.entity.Recipe;

public interface DeleteRecipeDAI {
    public void removeRecipe(String recipeName) throws Exception;
}
