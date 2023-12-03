package backend.service.search_recipes.interface_adapters;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchOutputBoundary;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
import view.states.SearchResultState;
import view.view_managers.ViewManagerModel;
import view.view_models.SearchResultViewModel;

public class SearchPresenter implements SearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SearchResultViewModel searchResultViewModel;
    public SearchPresenter(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchResultViewModel = searchResultViewModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData recipeResults) {
        SearchResultState searchResultState = searchResultViewModel.getState();
        searchResultState.setRecipeLst(recipeResults.getRecipes());
        // Original print to Console Message:
        for (Recipe recipe: recipeResults.getRecipes()){
            System.out.println(recipe.getName() + " " + recipe.getInstructions() + ":");
            for (Ingredient ingredient: recipe.getIngredients())
                System.out.println(ingredient.getTextDescription());
        }

        this.searchResultViewModel.setState(searchResultState);

        searchResultViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        // New actual method:
        /*
        SearchResultState searchResultState = searchResultViewModel.getState();
        // Todo: Some way to update Search Result state to have the output recipes
        this.searchResultViewModel.setState(searchResultState);
        searchResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
         */
    }
}
