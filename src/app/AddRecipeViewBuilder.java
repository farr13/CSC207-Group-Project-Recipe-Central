package app;

import backend.service.add_recipe.*;
import backend.service.back_to_search.BackToSearchController;
import backend.service.back_to_search.BackToSearchInteractor;
import backend.service.back_to_search.BackToSearchPresenter;
import view.usecase_views.AddRecipeView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.SearchResultViewModel;

/** Builder class for building a view of AddRecipeView type from the view models and data access objects for use cases.*/
public class AddRecipeViewBuilder {
    /** Takes in the respective view models and data access objects to return a view for the Add Recipe Panel.
     * @param viewManagerModel
     * @param addRecipeViewModel
     * @param searchResultViewModel
     * @param addRecipeDAO
     * @return An object of AddRecipeView type */
    @SuppressWarnings("JavadocDeclaration")
    public static AddRecipeView create(ViewManagerModel viewManagerModel, AddRecipeViewModel addRecipeViewModel,
                                       SearchResultViewModel searchResultViewModel,
                                       AddRecipeDAI addRecipeDAO) {
        BackToSearchController backToSearchController =
                AddRecipeViewBuilder.createBackToSearchUseCase(viewManagerModel, searchResultViewModel);
        AddRecipeController addRecipeController =
                AddRecipeViewBuilder.createAddRecipeUseCase(viewManagerModel, addRecipeViewModel, searchResultViewModel, addRecipeDAO);

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
