package backend.service.delete_recipe;

import backend.entity.Recipe;

public interface ViewRecipeDAI {
    public Recipe[] viewRecipes(String cookbookName);
}
