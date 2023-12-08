package backend.service.go_add_recipe;

import view.recipe_objects.Triplet;

public class GoAddRecipeOutputData {
    private final Triplet[] recipes;
    private final String[] cookbookNames;
    public GoAddRecipeOutputData(Triplet[] recipes, String[] cookbookNames) {
        this.recipes = recipes;
        this.cookbookNames = cookbookNames;
    }
    public Triplet[] getRecipes() {
        return recipes;
    }
    public String[] getCookbookNames() {
        return cookbookNames;
    }
}
