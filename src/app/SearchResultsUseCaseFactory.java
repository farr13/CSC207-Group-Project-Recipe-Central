package app;

import backend.service.add_recipe.*;
import backend.service.back_to_menu.BackToMenuController;
import backend.service.back_to_menu.BackToMenuInteractor;
import backend.service.back_to_menu.BackToMenuPresenter;
import backend.service.view_cookbook.ViewCookbookDAI;
import view.usecase_views.SearchResultsView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

import java.io.IOException;


public class SearchResultsUseCaseFactory {
    public SearchResultsUseCaseFactory() {}
    public static SearchResultsView create(SearchResultViewModel searchResultViewModel,
                                    AddRecipeViewModel addRecipeViewModel,
                                    MainMenuViewModel mainMenuViewModel,
                                    ViewManagerModel viewManagerModel,
                                    ViewCookbookDAI viewCookbookDAO,
                                    AddRecipeDAI addRecipeDAO) {
        AddRecipeController addRecipeController = createAddRecipeUseCase(addRecipeViewModel, viewManagerModel, addRecipeDAO);
        BackToMenuController backToMenuController = createBackToMenuUseCase(viewManagerModel, mainMenuViewModel);
        return new SearchResultsView(searchResultViewModel, addRecipeViewModel, addRecipeController, backToMenuController);
    }

    private static AddRecipeController createAddRecipeUseCase(AddRecipeViewModel addRecipeViewModel,
                                                       ViewManagerModel viewManagerModel,
                                                       AddRecipeDAI addRecipeDAO) {
        AddRecipePresenter addRecipePresenter = new AddRecipePresenter(viewManagerModel, addRecipeViewModel);
        AddRecipeInteractor addRecipeInteractor = new AddRecipeInteractor(addRecipeDAO, addRecipePresenter);
        return new AddRecipeController(addRecipeInteractor);
    }
    private static BackToMenuController createBackToMenuUseCase(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        BackToMenuPresenter backToMenuPresenter = new BackToMenuPresenter(viewManagerModel, mainMenuViewModel);
        BackToMenuInteractor backToMenuInteractor = new BackToMenuInteractor(backToMenuPresenter);
        return new BackToMenuController(backToMenuInteractor);
    }
}
