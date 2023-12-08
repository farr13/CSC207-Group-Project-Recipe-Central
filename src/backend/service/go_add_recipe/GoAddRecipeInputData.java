package backend.service.go_add_recipe;

import view.recipe_objects.Triplet;

public class GoAddRecipeInputData {
    private final Triplet[] recipes;
    public GoAddRecipeInputData(Triplet[] recipes){
        this.recipes = recipes;
    }
    public Triplet[] getRecipes() {
        return recipes;
    }
}
