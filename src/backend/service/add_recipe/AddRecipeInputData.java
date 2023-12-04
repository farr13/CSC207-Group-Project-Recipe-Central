package backend.service.add_recipe;

import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class AddRecipeInputData {
    private final String[] cookbookName;
    private final Triplet[] recipe;

    public AddRecipeInputData(String[] cookbookName, Triplet[] recipe) {
        this.cookbookName = cookbookName;
        this.recipe = recipe;
    }
    public String[] getCookbookName() { return cookbookName; }

    public Triplet[] getRecipe() {
        return recipe;
    }
}
