package users.service.delete_recipe_from_cookbook.;

import users.service.delete_recipe_from_cookbook.*;

public class DeleteRecipePresenter implements DeleteRecipeOutputBoundary {

    @Override
    public void present(DeleteRecipeOutputData outputData) {
        if (outputData.isSuccess()) {
            System.out.println("Recipe deleted successfully.");
        } else {
            System.out.println("Error: " + outputData.getMessage());
        }
        // In a real-world scenario, you might update a UI component or return a response in a web API.
    }
}
