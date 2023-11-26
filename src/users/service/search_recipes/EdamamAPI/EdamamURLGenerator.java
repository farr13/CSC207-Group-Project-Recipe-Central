package users.service.search_recipes.EdamamAPI;

import users.service.search_recipes.application_business_rules.API_Interface.InputDataURLConverter;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

public class EdamamURLGenerator implements InputDataURLConverter {
    String apiID, apiKey;

    public EdamamURLGenerator(String id, String key){
        apiID = id;
        apiKey = key;
    }

    @Override
    public String convertToURL(SearchInputData searchInputData) {
        String ingredients = "", mealTypes = "", diets = "", healths = "", requestURL = "";
        for (String ingredient: searchInputData.getIngredients()){
            ingredients = ingredient + "%2C%20";
        }
        if (ingredients.length() > 1)
            ingredients = ingredients.substring(0, ingredients.length() - 6);

        for (String mealType: searchInputData.getMealType())
            mealTypes = "&mealType=" + mealType;

        for (String diet: searchInputData.getDiet())
            diets = "&diet=" + diet;

        for (String health: searchInputData.getHealth())
            healths = "&health=" + health;

        return "https://api.edamam.com/api/recipes/v2?type=public&q=" + ingredients + "&app_id=" + apiID +
                "&app_key=" + apiKey + diets + healths + mealTypes;
    }
}
