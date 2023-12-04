package backend.service.go_add_recipe;

import backend.adapters.RecipeBlocksToTriplets;
import backend.adapters.RecipesToTriplets;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class GoAddRecipeController {
    final GoAddRecipeInputBoundary goAddCookbookInteractor;

    public GoAddRecipeController(GoAddRecipeInputBoundary goAddCookbookInteractor){
        this.goAddCookbookInteractor = goAddCookbookInteractor;
    }
    public void execute(String[] recipeBlocks) {
        goAddCookbookInteractor.execute(new GoAddRecipeInputData(RecipeBlocksToTriplets.convert(recipeBlocks)));
    }
}
