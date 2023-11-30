package backend.service.search_recipes.interface_adapters;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchOutputBoundary;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
public class SearchPresenter implements SearchOutputBoundary {

    @Override
    public void prepareSuccessView(SearchOutputData recipeResults) {

    }
}
