package backend.service.delete_recipe;

public interface DeleteRecipeDAI {
    public void deleteRecipe(String cookbookName, String recipeName) throws Exception;

}