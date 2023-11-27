package users.service.search_recipes.application_business_rules.API_Interface;

import users.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;

public interface JsonOutputDataConverter {
    public SearchOutputData convertRecipes(String requestResponse);
}
