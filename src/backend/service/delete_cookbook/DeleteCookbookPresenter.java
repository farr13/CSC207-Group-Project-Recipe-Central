package backend.service.delete_cookbook;

import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;

public class DeleteCookbookPresenter implements DeleteCookbookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CookbookListViewModel cookbookListViewModel;

    public DeleteCookbookPresenter(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.cookbookListViewModel = cookbookListViewModel;
    }
    @Override
    public void prepareSuccessView(DeleteCookbookOutputData response) {
    }

    @Override
    public void prepareFailView(String error) {

    }
}
