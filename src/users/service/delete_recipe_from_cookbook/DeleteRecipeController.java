package users.service.delete_recipe_from_cookbook.;

import users.service.delete_recipe_from_cookbook.*;

public class DeleteRecipeController {
    private final DeleteRecipeInputBoundary interactor;
    private final DeleteRecipeOutputBoundary presenter;

    public DeleteRecipeController(DeleteRecipeInputBoundary interactor,
                                  DeleteRecipeOutputBoundary presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    public void deleteRecipe(String cookbookName, String recipeName) {
        DeleteRecipeInputData inputData = new DeleteRecipeInputData(cookbookName, recipeName);
        try {
            interactor.execute(inputData);
            presenter.present(new DeleteRecipeOutputData(true, "Recipe deleted successfully."));
        } catch (Exception e) {
            presenter.present(new DeleteRecipeOutputData(false, e.getMessage()));
        }
    }
}
