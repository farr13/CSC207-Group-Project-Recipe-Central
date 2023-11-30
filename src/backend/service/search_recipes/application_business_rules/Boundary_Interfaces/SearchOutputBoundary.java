package backend.service.search_recipes.application_business_rules.Boundary_Interfaces;

import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;

public interface SearchOutputBoundary {
    public void prepareSuccessView(SearchOutputData recipeResults);
}
