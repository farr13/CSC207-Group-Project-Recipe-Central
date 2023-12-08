package backend.service.add_recipe;

import view.states.SearchResultState;
import view.view_managers.ViewManagerModel;
import view.view_models.AddRecipeViewModel;
import view.view_models.SearchResultViewModel;

public class AddRecipePresenter implements AddRecipeOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SearchResultViewModel searchResultViewModel;
    private final AddRecipeViewModel addRecipeViewModel;
    public AddRecipePresenter(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel,
                              AddRecipeViewModel addRecipeViewModel){
        this.searchResultViewModel = searchResultViewModel;
        this.addRecipeViewModel = addRecipeViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView() {
        SearchResultState searchResultState = searchResultViewModel.getState();
        searchResultViewModel.setState(searchResultState);
        searchResultViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(searchResultViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        addRecipeViewModel.firePropertyChanged();
    }
}
