package backend.service.view_cookbook;

import view.states.CookbookListState;
import view.states.OpenCookbookState;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.OpenCookbookViewModel;

public class ViewCookbookPresenter implements ViewCookbookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final OpenCookbookViewModel openCookbookViewModel;
    private final CookbookListViewModel cookbookListViewModel;

    public ViewCookbookPresenter(ViewManagerModel viewManagerModel, OpenCookbookViewModel openCookbookViewModel, CookbookListViewModel cookbookListViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.openCookbookViewModel = openCookbookViewModel;
        this.cookbookListViewModel = cookbookListViewModel;
    }

    @Override
    public void prepareSuccessView(ViewCookbookOutputData viewCookbookOutputData){
        System.out.println("Made it");
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookViewModel.setState(openCookbookState);
        openCookbookViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(openCookbookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView(String error) {
        CookbookListState cookbookListState = cookbookListViewModel.getState();
        cookbookListViewModel.firePropertyChanged();
    }
}
