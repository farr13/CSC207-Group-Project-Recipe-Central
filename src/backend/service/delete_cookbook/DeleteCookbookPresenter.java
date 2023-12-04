package backend.service.delete_cookbook;

import backend.entity.Cookbook;
import view.states.CookbookListState;
import view.states.MainMenuState;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;

import java.util.ArrayList;

public class DeleteCookbookPresenter implements DeleteCookbookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CookbookListViewModel cookbookListViewModel;

    public DeleteCookbookPresenter(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.cookbookListViewModel = cookbookListViewModel;
    }
    @Override
    public void prepareSuccessView(DeleteCookbookOutputData deleteCookbookOutputData) {
        CookbookListState cookbookListState = cookbookListViewModel.getState();
        cookbookListState.setCookbookNames(deleteCookbookOutputData.getCookbookNames());
        this.cookbookListViewModel.setState(cookbookListState);
        this.cookbookListViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CookbookListState cookbookListState = cookbookListViewModel.getState();
        cookbookListViewModel.firePropertyChanged();
    }
}
