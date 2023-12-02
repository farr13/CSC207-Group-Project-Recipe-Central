package app;

import backend.service.add_recipe.AddRecipeController;
import backend.service.add_recipe.AddRecipeDAI;
import backend.service.add_recipe.AddRecipeOutputBoundary;
import backend.service.add_recipe.AddRecipePresenter;
import view.usecase_views.SearchResultsView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeToCookbookViewmodel;
import view.view_models.MainMenuViewModel;

import java.io.IOException;

public class SearchResultsUseCaseFactory {

    private SearchResultsUseCaseFactory() {}

    public static SearchResultsView create(MainMenuViewModel mainMenuViewModel, AddRecipeToCookbookViewmodel
            addRecipeToCookbookViewmodel) {
        //try {
            //AddRecipeController addRecipeController = create()
        //}
    }

    /*
    private static AddRecipeController createAddRecipeUseCase(ViewManagerModel viewManagerModel,
                                                              MainMenuViewModel mainMenuViewModel,
                                                              AddRecipeDAI addRecipeDAI) throws IOException {
        AddRecipeOutputBoundary addRecipeOutputBoundary = new AddRecipePresenter(viewManagerModel, mainMenuViewModel)
    }

     */
}
