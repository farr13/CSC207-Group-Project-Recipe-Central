package users.service.search_recipes.API_Interface;

import users.service.search_recipes.DataTypes.SearchOutputData;

public interface JsonOutputDataConverter {
    public SearchOutputData convertRecipes(String requestResponse);
}
