package backend.service.add_recipe;
import backend.entity.Recipe;
import backend.entity.Ingredient;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class AddRecipeController {
    private final AddRecipeInputBoundary addRecipeUseCaseInteractor;
    public AddRecipeController(AddRecipeInputBoundary addRecipeUseCaseInteractor) {
        this.addRecipeUseCaseInteractor = addRecipeUseCaseInteractor;
    }

    public void execute(String cookbookName, Triplet recipe) throws Exception {
        AddRecipeInputData addRecipeInputData = new AddRecipeInputData(cookbookName, recipe);
        addRecipeUseCaseInteractor.execute(addRecipeInputData);
    }
}
