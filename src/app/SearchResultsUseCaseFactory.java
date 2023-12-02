package app;

import backend.service.add_recipe.*;
import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.view_cookbook.ViewCookbookController;
import view.usecase_views.CookbookListView;
import view.usecase_views.SearchResultsView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

import java.io.IOException;


public class SearchResultsUseCaseFactory {
    public SearchResultsUseCaseFactory() {

    }
    public static SearchResultsView create(SearchResultViewModel searchResultViewModel,
                                    AddRecipeViewModel addRecipeViewModel,
                                    MainMenuViewModel mainMenuViewModel,
                                    ViewManagerModel viewManagerModel,
                                    AddRecipeDAI addRecipeDAO) {
        AddRecipeController addRecipeController = createAddRecipeUsecase(addRecipeViewModel, viewManagerModel, addRecipeDAO);
        return new SearchResultsView(searchResultViewModel, addRecipeViewModel, addRecipeController);
    }

    private static AddRecipeController createAddRecipeUsecase(AddRecipeViewModel addRecipeViewModel,
                                                       ViewManagerModel viewManagerModel,
                                                       AddRecipeDAI addRecipeDAO) {
        AddRecipePresenter addRecipePresenter = new AddRecipePresenter(viewManagerModel, addRecipeViewModel);
        AddRecipeInteractor addRecipeInteractor = new AddRecipeInteractor(addRecipeDAO, addRecipePresenter);
        return new AddRecipeController(addRecipeInteractor);
    }
}
