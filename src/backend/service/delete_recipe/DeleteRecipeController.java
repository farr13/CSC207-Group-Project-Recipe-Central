package backend.service.delete_recipe;

import backend.adapters.RecipeBlocksToTriplets;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import view.recipe_objects.*;

import java.util.ArrayList;

public class DeleteRecipeController {

    final DeleteRecipeInputBoundary deleteRecipeInteractor;

    public DeleteRecipeController(DeleteRecipeInputBoundary deleteRecipeInteractor){
        this.deleteRecipeInteractor = deleteRecipeInteractor;
    }
    public void execute(String cookbookName, String[] recipeBlocks) {
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(cookbookName, RecipeBlocksToTriplets.convert(recipeBlocks));

        deleteRecipeInteractor.execute(deleteRecipeInputData);
    }
}
