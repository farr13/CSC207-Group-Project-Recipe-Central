package users.service.search_recipes;

public class SearchController {
    final SearchInputBoundary searchUseCaseInteractor;
    public SearchController(SearchInputBoundary searchUseCaseInteractor) {
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }


    public void execute(String ingredientsSearch, String mealTypeSearch, String dietSearch, String healthSearch) {
        SearchInputData searchInputData = new SearchInputData(ingredientsSearch, mealTypeSearch, dietSearch, healthSearch);
        clearUseCaseInteractor.execute(searchInputData);
    }
}
