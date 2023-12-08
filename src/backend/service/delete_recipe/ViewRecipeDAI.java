package backend.service.delete_recipe;

import backend.entity.Recipe;

public interface ViewRecipeDAI {
    Recipe[] viewRecipes(String cookbookName);
}
