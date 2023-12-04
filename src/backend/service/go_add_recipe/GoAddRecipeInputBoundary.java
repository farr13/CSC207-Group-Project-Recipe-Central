package backend.service.go_add_recipe;

import view.recipe_objects.Triplet;

public interface GoAddRecipeInputBoundary {
    void execute(GoAddRecipeInputData goAddRecipeInputData);
}
