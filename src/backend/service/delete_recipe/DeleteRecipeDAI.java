package backend.service.delete_recipe;

import backend.entity.Recipe;

public interface DeleteRecipeDAI {
    public void deleteRecipe(String cookbookName, Recipe[] recipes) throws Exception;

}

//public interface DeleteRecipeDeleteDAI {
//    public void deleteRecipe(String cookbookName, String recipeName) throws Exception;
//}
