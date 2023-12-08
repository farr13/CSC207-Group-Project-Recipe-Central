package backend.service.view_cookbook;

import view.recipe_objects.Triplet;

public class ViewCookbookOutputData {
    private final String cookbookName;
    private final Triplet[] recipes;
    public ViewCookbookOutputData(String cookbookName, Triplet[] recipes) {
        this.cookbookName = cookbookName;
        this.recipes = recipes;
    }
    public String getCookbookName() {
        return cookbookName;
    }

    public Triplet[] getRecipes() {
        return recipes;
    }
}
