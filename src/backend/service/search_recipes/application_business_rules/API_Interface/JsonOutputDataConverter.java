package backend.service.search_recipes.application_business_rules.API_Interface;

import backend.entity.Recipe;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;

public interface JsonOutputDataConverter {
    public Recipe[] convertRecipes(String requestResponse);
}
