package backend.service.delete_cookbook;

import view.states.CookbookListState;
import view.view_models.CookbookListViewModel;

public class DeleteCookbookPresenter implements DeleteCookbookOutputBoundary {
    private final CookbookListViewModel cookbookListViewModel;

    public DeleteCookbookPresenter(CookbookListViewModel cookbookListViewModel) {
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
    public void prepareFailView() {
        cookbookListViewModel.firePropertyChanged();
    }
}
