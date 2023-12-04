package backend.service.go_add_recipe;

import backend.adapters.TripletsToRecipeBlocks;
import view.recipe_objects.Triplet;
import view.states.AddCookbookState;
import view.states.AddRecipeState;
import view.states.CookbookListState;
import view.states.SearchResultState;
import view.usecase_views.SearchResultView;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.SearchResultViewModel;

import java.util.ArrayList;

public class GoAddRecipePresenter implements GoAddRecipeOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddRecipeViewModel addRecipeViewModel;
    private final SearchResultViewModel searchResultViewModel;
    public GoAddRecipePresenter(ViewManagerModel viewManagerModel, AddRecipeViewModel addRecipeViewModel,
                                SearchResultViewModel searchResultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addRecipeViewModel = addRecipeViewModel;
        this.searchResultViewModel = searchResultViewModel;
    }

    @Override
    public void prepareSuccessView(GoAddRecipeOutputData goAddRecipeOutputData) {
        AddRecipeState addRecipeState = addRecipeViewModel.getState();
        addRecipeState.setRecipesSelected(TripletsToRecipeBlocks.convert(goAddRecipeOutputData.getRecipes()));
        addRecipeState.setCookbookNames(goAddRecipeOutputData.getCookbookNames());
        this.addRecipeViewModel.setState(addRecipeState);
        this.addRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SearchResultState searchResultView = searchResultViewModel.getState();
        searchResultViewModel.firePropertyChanged();
    }
}
