package users.service.search_recipes.interface_adapters;

import users.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchInputBoundary;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

import java.util.ArrayList;

public class SearchController {
    final SearchInputBoundary searchUseCaseInteractor;
    public SearchController(SearchInputBoundary searchUseCaseInteractor) {
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }


    public void execute(String ingredients, String[] mealTypes, String[] diets, String[] healths) {
        String[] ingredientInputData = ingredients.split(","),
                mealTypeInputData = mealTypes,
                dietInputData = diets,
                healthInputData = healths;

        trimIngredients(ingredientInputData);

        SearchInputData searchInputData = new SearchInputData(ingredientInputData, mealTypeInputData, dietInputData, healthInputData);
        searchUseCaseInteractor.execute(searchInputData);
    }

    private void trimIngredients(String[] ingredients){
        for (String ingredient: ingredients){
            ingredient.trim();
        }
    }
}
