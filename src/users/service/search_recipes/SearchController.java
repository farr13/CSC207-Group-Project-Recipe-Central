package users.service.search_recipes;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchController {
    final SearchInputBoundary searchUseCaseInteractor;
    public SearchController(SearchInputBoundary searchUseCaseInteractor) {
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }


    public void execute(String ingredientsSearch, Boolean[] mealTypeSearch, Boolean[] dietSearch, Boolean[] healthSearch) {
        ArrayList<String> ingredientInputData = ingredientConvert(ingredientsSearch),
                mealTypeInputData = mealTypeConvert(mealTypeSearch),
                dietInputData = dietConvert(dietSearch),
                healthInputData = healthConvert(healthSearch);

        SearchInputData searchInputData = new SearchInputData(ingredientInputData, mealTypeInputData, dietInputData, healthInputData);
        clearUseCaseInteractor.execute(searchInputData);
    }

    private ArrayList<String> ingredientConvert(String ingredientsSearch){
        ArrayList<String> ingredientInputData = new ArrayList<String>();
        String[] ingredientInputDataTemp = ingredientsSearch.split(",");
        for (String ingredient : ingredientInputDataTemp)
            ingredientInputData.add(ingredient.strip());
        return ingredientInputData;
    }

    private ArrayList<String> dietConvert(Boolean[] dietSearch){
        ArrayList<String> dietInputData = new ArrayList<String>();
        if (dietSearch[0]){ dietInputData.add("balanced"); }
        if (dietSearch[1]){ dietInputData.add("high-fiber"); }
        if (dietSearch[2]){ dietInputData.add("high-protein"); }
        if (dietSearch[3]){ dietInputData.add("low-carb"); }
        if (dietSearch[4]){ dietInputData.add("low-fat"); }
        if (dietSearch[5]){ dietInputData.add("low-sodium"); }

        return dietInputData;
    }

    private ArrayList<String> healthConvert(Boolean[] healthSearch){
        ArrayList<String> healthInputData = new ArrayList<String>();
        if (healthSearch[0]){ healthInputData.add("alcohol-cocktail"); }
        if (healthSearch[1]){ healthInputData.add("alcohol-free"); }
        if (healthSearch[2]){ healthInputData.add("celery-free"); }
        if (healthSearch[3]){ healthInputData.add("crustacean-free"); }
        if (healthSearch[4]){ healthInputData.add("dairy-free"); }
        if (healthSearch[5]){ healthInputData.add("vegan"); }
        if (healthSearch[6]){ healthInputData.add("vegetarian"); }

        return healthInputData;
    }

    private ArrayList<String> mealTypeConvert(Boolean[] mealTypeSearch){
        ArrayList<String> mealTypeInputData = new ArrayList<String>();
        if (mealTypeSearch[0]){ mealTypeInputData.add("Dinner"); }
        if (mealTypeSearch[1]){ mealTypeInputData.add("Lunch"); }
        if (mealTypeSearch[2]){ mealTypeInputData.add("Snack"); }
        if (mealTypeSearch[3]){ mealTypeInputData.add("Teatime"); }

        return mealTypeInputData;
    }
}
