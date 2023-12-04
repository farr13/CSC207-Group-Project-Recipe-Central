package backend.service.search_recipes.application_business_rules.DataTypes;

import backend.entity.Recipe;
import view.recipe_objects.Triplet;

public class SearchOutputData {
    private Triplet[] recipes;

    public SearchOutputData(Triplet[] recipes){
        this.recipes = recipes;
    }

    public Triplet[] getRecipes() {
        return recipes;
    }
}
