package backend.service.search_recipes.application_business_rules;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchOutputBoundary;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchInputData;
import backend.service.search_recipes.application_business_rules.API_Interface.APICaller;
import backend.service.search_recipes.application_business_rules.API_Interface.InputDataURLConverter;
import backend.service.search_recipes.application_business_rules.API_Interface.JsonOutputDataConverter;
import backend.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchInputBoundary;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary {
    private APICaller apiCaller;
    private InputDataURLConverter inputDataConverter;
    private JsonOutputDataConverter outputDataConverter;
    private SearchOutputBoundary searchPresenter;

    public SearchInteractor(APICaller apiCaller, InputDataURLConverter inputDataConverter, JsonOutputDataConverter outputDataConverter, SearchOutputBoundary searchPresenter){
        this.apiCaller = apiCaller;
        this.inputDataConverter = inputDataConverter;
        this.outputDataConverter = outputDataConverter;
        this.searchPresenter = searchPresenter;
    }

    private Triplet[] convertTriplet(Recipe[] recipes){
        ArrayList<Triplet> triplets = new ArrayList<Triplet>();
        for (Recipe recipe: recipes){
            String name = recipe.getName();
            String link = recipe.getInstructions();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (Ingredient ingredient: recipe.getIngredients())
                arrayList.add(ingredient.getTextDescription());
            triplets.add(new Triplet(name, link, arrayList.toArray(new String[0])));
        }
        return triplets.toArray(new Triplet[0]);
    }

    @Override
    public void execute(SearchInputData searchInputData) {
        // Convert inputdata data to a tuple with strings
        String pullRequestURL = inputDataConverter.convertToURL(searchInputData);
        // Call the API Caller which gives a string in Json format
        String requestResponce = apiCaller.execute(pullRequestURL);
        // Convert Json String to Recipe output data
        Recipe[] recipes = outputDataConverter.convertRecipes(requestResponce);
        SearchOutputData searchOutputData = new SearchOutputData(convertTriplet(recipes));
        // Call the presenter
        searchPresenter.prepareSuccessView(searchOutputData);
    }
}
