package backend.service.go_add_recipe;

import backend.adapters.RecipeBlocksToTriplets;

public class GoAddRecipeController {
    private final GoAddRecipeInputBoundary goAddCookbookInteractor;
    public GoAddRecipeController(GoAddRecipeInputBoundary goAddCookbookInteractor){
        this.goAddCookbookInteractor = goAddCookbookInteractor;
    }
    public void execute(String[] recipeBlocks) {
        goAddCookbookInteractor.execute(new GoAddRecipeInputData(RecipeBlocksToTriplets.convert(recipeBlocks)));
    }
}
