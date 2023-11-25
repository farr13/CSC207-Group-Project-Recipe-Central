package users.service.search_recipes.application_business_rules;

import users.service.search_recipes.application_business_rules.API_Interface.APICaller;
import users.service.search_recipes.application_business_rules.API_Interface.InputDataURLConverter;
import users.service.search_recipes.application_business_rules.API_Interface.JsonOutputDataConverter;
import users.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchInputBoundary;
import users.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchOutputBoundary;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;
import users.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;

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

    @Override
    public void execute(SearchInputData searchInputData) {
        // Convert inputdata data to a tuple with strings
        String pullRequestURL = inputDataConverter.convertToURL(searchInputData);
        // Call the API Caller which gives a string in Json format
        String requestResponce = apiCaller.execute(pullRequestURL);
        // Convert Json String to Recipe output data
        SearchOutputData searchOutputData = outputDataConverter.convertRecipes(requestResponce);
        // Call the presenter
        searchPresenter.prepareSuccessView(searchOutputData);
    }
}
