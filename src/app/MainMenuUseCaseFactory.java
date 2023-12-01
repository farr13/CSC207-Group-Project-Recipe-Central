package app;

import backend.service.search_recipes.EdamamAPI.EdamamCaller;
import backend.service.search_recipes.EdamamAPI.EdamamURLGenerator;
import backend.service.search_recipes.EdamamAPI.JsonRecipeGenerator;
import backend.service.search_recipes.application_business_rules.SearchInteractor;
import backend.service.search_recipes.interface_adapters.SearchController;
import backend.service.search_recipes.interface_adapters.SearchPresenter;
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookDAI;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import view.usecase_views.MainMenuView;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;

public class MainMenuUseCaseFactory {
    public void MainMenuViewModel(){}

    public static MainMenuView create(MainMenuViewModel mainMenuViewModel, ViewCookbookDAI viewCookbookDAO){
        SearchController searchController = MainMenuUseCaseFactory.createSearchUseCase();
        ViewCookbookController viewCookbookController = MainMenuUseCaseFactory.createViewCookbookUseCase(viewCookbookDAO);
        return new MainMenuView(mainMenuViewModel, searchController, viewCookbookController);
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
    private static ViewCookbookController createViewCookbookUseCase(ViewCookbookDAI viewCookbookDAO){
        ViewCookbookPresenter viewCookbookPresenter = new ViewCookbookPresenter();
        ViewCookbookInteractor viewCookbookInteractor = new ViewCookbookInteractor(viewCookbookDAO, viewCookbookPresenter);
        ViewCookbookController viewCookbookController = new ViewCookbookController(viewCookbookInteractor);
        return viewCookbookController;
    }
}
