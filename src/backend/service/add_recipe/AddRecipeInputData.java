package backend.service.add_recipe;

import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class AddRecipeInputData {
    private final String cookbookName;
    private final Triplet recipe;

    public AddRecipeInputData(String cookbookName, Triplet recipe) {
        this.cookbookName = cookbookName;
        this.recipe = recipe;
    }
    public String getCookbookName() { return cookbookName; }
    public String getRecipeName() { return (String) recipe.getName(); }
    public String getInstructions() { return (String) recipe.getLink(); }
    public String[] getIngredients() { return recipe.getList(); }


}
