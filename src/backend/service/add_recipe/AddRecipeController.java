package backend.service.add_recipe;
import backend.adapters.RecipeBlocksToTriplets;

public class AddRecipeController {
    private final AddRecipeInputBoundary addRecipeUseCaseInteractor;
    public AddRecipeController(AddRecipeInputBoundary addRecipeUseCaseInteractor) {
        this.addRecipeUseCaseInteractor = addRecipeUseCaseInteractor;
    }
    public void execute(String[] cookbookName, String[] recipes) {
        AddRecipeInputData addRecipeInputData = new AddRecipeInputData(cookbookName, RecipeBlocksToTriplets.convert(recipes));
        addRecipeUseCaseInteractor.execute(addRecipeInputData);
    }
}
