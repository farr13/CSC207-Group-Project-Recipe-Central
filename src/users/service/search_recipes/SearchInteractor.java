package users.service.search_recipes;

public class SearchInteractor implements SearchInputBoundary {
    private APICaller apiCaller;
    private InputDataURLConverter inputDataConverter;
    private JsonOutputDataConverter outputDataConverter;
    private SearchPresenter searchPresenter;

    public SearchInteractor(APICaller apiCaller, InputDataURLConverter inputDataConverter, JsonOutputDataConverter outputDataConverter, SearchPresenter searchPresenter){
        this.apiCaller = apiCaller;
        this.inputDataConverter = inputDataConverter;
        this.outputDataConverter = outputDataConverter;
        this.searchPresenter = searchPresenter;
    }

    @Override
    public void execute(SearchInputData searchInputData) {
        // Convert inputdata data to a tuple with strings
        String requestURLComponents = inputDataConverter.convertToURL(searchInputData);
        // Call the API Caller which gives a string in Json format
        String responceStr = apiCaller.execute(requestURLComponents);
        // Convert Json String to Recipe output data
        OutputData outputData = outputDataConverter.convertToRecipies(responceStr);
        // Call the presenter
        searchPresenter.prepareSuccessView(outputData);
    }
}
