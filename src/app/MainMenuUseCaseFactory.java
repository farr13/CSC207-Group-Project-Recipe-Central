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

public class MainMenuUseCaseFactory {
    private MainMenuUseCaseFactory(){}

    public static MainMenuView create(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel, SearchResultViewModel searchResultViewModel,
                                      CookbookListViewModel cookbookListViewModel, SeeListCookbooksDAI seeListCookbooksDAO){
        SearchController searchController = MainMenuUseCaseFactory.createSearchUseCase(viewManagerModel, searchResultViewModel);
        SeeListCookbooksController seeListCookbooksController = MainMenuUseCaseFactory.createSeeListCookbooksUseCase(viewManagerModel,
                cookbookListViewModel,seeListCookbooksDAO);
        return new MainMenuView(mainMenuViewModel, searchController, seeListCookbooksController);
    }
    private static SearchController createSearchUseCase(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel){
        SearchPresenter searchPresenter = new SearchPresenter(viewManagerModel, searchResultViewModel);
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();
        SearchInteractor searchInteractor = new SearchInteractor(edamamCaller, edamamURLGenerator, jsonRecipeGenerator, searchPresenter);
        return new SearchController(searchInteractor);
    }
    private static SeeListCookbooksController createSeeListCookbooksUseCase(ViewManagerModel viewManagerModel,
                                                                            CookbookListViewModel cookbookListViewModel,
                                                                            SeeListCookbooksDAI seeListCookbooksDAO){
        SeeListCookbooksPresenter seeListCookbooksPresenter = new SeeListCookbooksPresenter(viewManagerModel, cookbookListViewModel);
        SeeListCookbooksInteractor seeListCookbooksInteractor = new SeeListCookbooksInteractor(seeListCookbooksDAO,
                seeListCookbooksPresenter);
        return new SeeListCookbooksController(seeListCookbooksInteractor);
    }
}
