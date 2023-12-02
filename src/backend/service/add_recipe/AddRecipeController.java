package backend.service.add_recipe;

public class AddRecipeController {
    final AddRecipeInputBoundary addRecipeUseCaseInteractor;
    public AddRecipeController(AddRecipeInputBoundary addRecipeUseCaseInteractor) {
        this.addRecipeUseCaseInteractor = addRecipeUseCaseInteractor;
    }

    public void execute(String recipeName, String cookbokoName, String intructions, String ingredientsDESC) throws Exception {
        AddRecipeInputData addRecipeInputData = new AddRecipeInputData(recipeName, cookbokoName,
                ingredientsDESC, intructions);
        addRecipeUseCaseInteractor.execute(addRecipeInputData);
    }
}
