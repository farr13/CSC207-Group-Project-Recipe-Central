package backend.service.delete_recipe;

import backend.adapters.RecipeBlocksToTriplets;

public class DeleteRecipeController {
    private final DeleteRecipeInputBoundary deleteRecipeInteractor;
    public DeleteRecipeController(DeleteRecipeInputBoundary deleteRecipeInteractor) {
        this.deleteRecipeInteractor = deleteRecipeInteractor;
    }
    public void execute(String cookbookName, String[] recipeBlocks) {
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(cookbookName, RecipeBlocksToTriplets.convert(recipeBlocks));
        deleteRecipeInteractor.execute(deleteRecipeInputData);
    }
}
