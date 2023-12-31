package backend.service.delete_recipe;

import view.recipe_objects.Triplet;

@SuppressWarnings("ConvertClassToRecord")
public class DeleteRecipeOutputData {
    private final Triplet[] recipes;
    public DeleteRecipeOutputData(Triplet[] recipes) {
        this.recipes = recipes;
    }
    public Triplet[] getRecipes() {
        return recipes;
    }
}
