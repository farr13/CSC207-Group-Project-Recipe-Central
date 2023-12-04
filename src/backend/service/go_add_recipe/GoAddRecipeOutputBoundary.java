package backend.service.go_add_recipe;

import view.recipe_objects.Triplet;

public interface GoAddRecipeOutputBoundary {
    public void prepareSuccessView(GoAddRecipeOutputData goAddRecipeOutputData);
    public void prepareFailView(String error);
}
