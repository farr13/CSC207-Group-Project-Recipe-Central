package backend.service.back_to_search;

import view.states.MainMenuState;
import view.states.SearchResultState;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;
import view.view_models.SearchResultViewModel;

public class BackToSearchPresenter implements BackToSearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SearchResultViewModel searchResultViewModel;
    public BackToSearchPresenter(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchResultViewModel = searchResultViewModel;
    }
    @Override
    public void prepareSuccessView() {
        SearchResultState searchResultState = searchResultViewModel.getState();
        searchResultViewModel.setState(searchResultState);
        searchResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(searchResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
