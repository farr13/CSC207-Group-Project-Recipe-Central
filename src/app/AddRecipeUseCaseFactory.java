package app;

import backend.service.add_recipe.*;
import backend.service.back_to_search.BackToSearchController;
import backend.service.back_to_search.BackToSearchInteractor;
import backend.service.back_to_search.BackToSearchPresenter;
import view.usecase_views.AddRecipeView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.SearchResultViewModel;

public class AddRecipeUseCaseFactory {
    public AddRecipeUseCaseFactory() {}
    public static AddRecipeView create(ViewManagerModel viewManagerModel, AddRecipeViewModel addRecipeViewModel,
                                       SearchResultViewModel searchResultViewModel,
                                       AddRecipeDAI addRecipeDAO) {
        BackToSearchController backToSearchController = AddRecipeUseCaseFactory.createBackToSearchUseCase(viewManagerModel,
                searchResultViewModel);
        AddRecipeController addRecipeController = AddRecipeUseCaseFactory.createAddRecipeUseCase(viewManagerModel,
                addRecipeViewModel, searchResultViewModel, addRecipeDAO);

        return new AddRecipeView(viewManagerModel, addRecipeViewModel, addRecipeController, backToSearchController);
    }

    private static BackToSearchController createBackToSearchUseCase(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel) {
        BackToSearchPresenter backToSearchPresenter = new BackToSearchPresenter(viewManagerModel, searchResultViewModel);
        BackToSearchInteractor backToSearchInteractor = new BackToSearchInteractor(backToSearchPresenter);
        return new BackToSearchController(backToSearchInteractor);
    }
    private static AddRecipeController createAddRecipeUseCase(ViewManagerModel viewManagerModel,
                                                              AddRecipeViewModel addRecipeViewModel,
                                                              SearchResultViewModel searchResultViewModel,
                                                              AddRecipeDAI addRecipeDAO) {
        AddRecipePresenter addRecipePresenter = new AddRecipePresenter(viewManagerModel, searchResultViewModel, addRecipeViewModel);
        AddRecipeInteractor addRecipeInteractor = new AddRecipeInteractor(addRecipeDAO, addRecipePresenter);
        return new AddRecipeController(addRecipeInteractor);
    }
}
