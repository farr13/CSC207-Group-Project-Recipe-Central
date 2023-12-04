package app;

import backend.service.back_to_menu.BackToMenuController;
import backend.service.back_to_menu.BackToMenuInteractor;
import backend.service.back_to_menu.BackToMenuPresenter;
import backend.service.go_add_recipe.GoAddRecipeController;
import backend.service.go_add_recipe.GoAddRecipeInteractor;
import backend.service.go_add_recipe.GoAddRecipePresenter;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import view.usecase_views.SearchResultView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;


public class SearchResultUseCaseFactory {
    public SearchResultUseCaseFactory() {}
    public static SearchResultView create(SearchResultViewModel searchResultViewModel,
                                          AddRecipeViewModel addRecipeViewModel,
                                          MainMenuViewModel mainMenuViewModel,
                                          ViewManagerModel viewManagerModel,
                                          SeeListCookbooksDAI seeListCookbooksDAO) {
        BackToMenuController backToMenuController = SearchResultUseCaseFactory.createBackToMenuUseCase(viewManagerModel,
                mainMenuViewModel);
        GoAddRecipeController goAddRecipeController = SearchResultUseCaseFactory.createGoAddRecipeUseCase(viewManagerModel,
                addRecipeViewModel, searchResultViewModel, seeListCookbooksDAO);
        return new SearchResultView(searchResultViewModel, backToMenuController, goAddRecipeController);
    }

    private static BackToMenuController createBackToMenuUseCase(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        BackToMenuPresenter backToMenuPresenter = new BackToMenuPresenter(viewManagerModel, mainMenuViewModel);
        BackToMenuInteractor backToMenuInteractor = new BackToMenuInteractor(backToMenuPresenter);
        return new BackToMenuController(backToMenuInteractor);
    }

    private static GoAddRecipeController createGoAddRecipeUseCase(ViewManagerModel viewManagerModel, AddRecipeViewModel addRecipeViewModel,
                                                                  SearchResultViewModel searchResultViewModel, SeeListCookbooksDAI seeListCookbooksDAO){
        GoAddRecipePresenter goAddRecipePresenter = new GoAddRecipePresenter(viewManagerModel, addRecipeViewModel, searchResultViewModel);
        GoAddRecipeInteractor goAddRecipeInteractor = new GoAddRecipeInteractor(goAddRecipePresenter, seeListCookbooksDAO);
        return new GoAddRecipeController(goAddRecipeInteractor);
    }
}