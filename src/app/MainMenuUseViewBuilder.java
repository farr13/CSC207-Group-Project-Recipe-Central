package app;

import backend.service.search_recipes.EdamamAPI.EdamamCaller;
import backend.service.search_recipes.EdamamAPI.EdamamURLGenerator;
import backend.service.search_recipes.EdamamAPI.JsonRecipeGenerator;
import backend.service.search_recipes.application_business_rules.SearchInteractor;
import backend.service.search_recipes.interface_adapters.SearchController;
import backend.service.search_recipes.interface_adapters.SearchPresenter;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import backend.service.see_list_cookbooks.SeeListCookbooksInteractor;
import backend.service.see_list_cookbooks.SeeListCookbooksPresenter;
import view.usecase_views.MainMenuView;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

/** Builder class for building a view of MainMenuView type from the view models and data access objects for use cases.*/
public class MainMenuUseViewBuilder {
    /**Takes in the respective view models and data access objects for search and returns a view for the Main Menu Panel.
     * @param viewManagerModel
     * @param mainMenuViewModel
     * @param searchResultViewModel
     * @param cookbookListViewModel
     * @param seeListCookbooksDAO
     * @return An object of the MainMenuView type. */
    @SuppressWarnings("JavadocDeclaration")
    public static MainMenuView create(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, SearchResultViewModel searchResultViewModel,
                                      CookbookListViewModel cookbookListViewModel, SeeListCookbooksDAI seeListCookbooksDAO) {
        SearchController searchController =
                MainMenuUseViewBuilder.createSearchUseCase(viewManagerModel, searchResultViewModel);
        SeeListCookbooksController seeListCookbooksController =
                MainMenuUseViewBuilder.createSeeListCookbooksUseCase(viewManagerModel, cookbookListViewModel,seeListCookbooksDAO);

        return new MainMenuView(mainMenuViewModel, searchController, seeListCookbooksController);
    }
    private static SearchController createSearchUseCase(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel){
        SearchPresenter searchPresenter = new SearchPresenter(viewManagerModel, searchResultViewModel);
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();
        EdamamCaller edamamCaller = new EdamamCaller();
        SearchInteractor searchInteractor = new SearchInteractor(edamamCaller, edamamURLGenerator, jsonRecipeGenerator, searchPresenter);
        return new SearchController(searchInteractor);
    }
    private static SeeListCookbooksController createSeeListCookbooksUseCase(ViewManagerModel viewManagerModel,
                                                                            CookbookListViewModel cookbookListViewModel,
                                                                            SeeListCookbooksDAI seeListCookbooksDAO) {
        SeeListCookbooksPresenter seeListCookbooksPresenter = new SeeListCookbooksPresenter(viewManagerModel, cookbookListViewModel);
        SeeListCookbooksInteractor seeListCookbooksInteractor = new SeeListCookbooksInteractor(seeListCookbooksDAO, seeListCookbooksPresenter);
        return new SeeListCookbooksController(seeListCookbooksInteractor);
    }
}
