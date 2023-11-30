package backend.service.search_recipes.application_business_rules.API_Interface;

import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;

public interface JsonOutputDataConverter {
    public SearchOutputData convertRecipes(String requestResponse);
}
