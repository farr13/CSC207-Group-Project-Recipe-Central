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
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookViewDAI;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import view.usecase_views.MainMenuView;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;

public class MainMenuUseCaseFactory {
    public MainMenuUseCaseFactory(){}

    public static MainMenuView create(MainMenuViewModel mainMenuViewModel, SeeListCookbooksDAI seeListCookbooksDAO){
        SearchController searchController = MainMenuUseCaseFactory.createSearchUseCase();
        SeeListCookbooksController seeListCookbooksController = MainMenuUseCaseFactory.createSeeListCookbooksUseCase(seeListCookbooksDAO);
        return new MainMenuView(mainMenuViewModel, searchController, seeListCookbooksController);
    }
    private static SearchController createSearchUseCase(){
        SearchPresenter searchPresenter = new SearchPresenter();
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();
        SearchInteractor searchInteractor = new SearchInteractor(edamamCaller, edamamURLGenerator, jsonRecipeGenerator, searchPresenter);
        SearchController searchController = new SearchController(searchInteractor);
        return searchController;
    }
    private static SeeListCookbooksController createSeeListCookbooksUseCase(SeeListCookbooksDAI seeListCookbooksDAO){
        SeeListCookbooksPresenter seeListCookbooksPresenter = new SeeListCookbooksPresenter();
        SeeListCookbooksInteractor seeListCookbooksInteractor = new SeeListCookbooksInteractor(seeListCookbooksDAO, seeListCookbooksPresenter);
        SeeListCookbooksController seeListCookbooksController = new SeeListCookbooksController(seeListCookbooksInteractor);
        return seeListCookbooksController;
    }
}
