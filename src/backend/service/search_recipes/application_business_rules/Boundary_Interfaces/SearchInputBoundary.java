package backend.service.search_recipes.application_business_rules.Boundary_Interfaces;

import backend.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

public interface SearchInputBoundary {
    public void execute(SearchInputData searchInputData);
}
