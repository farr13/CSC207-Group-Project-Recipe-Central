package backend.service.search_recipes.interface_adapters;

import backend.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchInputBoundary;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

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
        for (int i=0; i < ingredients.length; i++){
            ingredients[i] = ingredients[i].trim();
        }
    }
}
