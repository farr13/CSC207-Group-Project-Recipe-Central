package backend.service.see_list_cookbooks;

import view.states.CookbookListState;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;

public class SeeListCookbooksPresenter implements SeeListCookbooksOutputBoundary {
    CookbookListViewModel cookbookListViewModel;
    ViewManagerModel viewManagerModel;
    public SeeListCookbooksPresenter(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel){
        this.viewManagerModel = viewManagerModel;
        this.cookbookListViewModel = cookbookListViewModel;
    }
    @Override
    public void prepareSuccessView(SeeListCookbooksOutputData seeListCookbooksOutputData) {
        CookbookListState cookbookListState = cookbookListViewModel.getState();
        cookbookListState.setCookbookNames(seeListCookbooksOutputData.getCookbookNames());
        this.cookbookListViewModel.setState(cookbookListState);
        this.cookbookListViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(cookbookListViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView() {}
}
