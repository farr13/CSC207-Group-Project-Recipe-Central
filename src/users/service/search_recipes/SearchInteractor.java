package users.service.search_recipes;

import users.service.search_recipes.API_Interface.APICaller;
import users.service.search_recipes.API_Interface.InputDataURLConverter;
import users.service.search_recipes.API_Interface.JsonOutputDataConverter;

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
        SearhcOutputData searchOutputData = outputDataConverter.convertToRecipies(requestResponce);
        // Call the presenter
        searchPresenter.prepareSuccessView(searchOutputData);
    }
}
