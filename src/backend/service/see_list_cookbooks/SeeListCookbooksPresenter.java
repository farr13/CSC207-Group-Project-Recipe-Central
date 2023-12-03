package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;
import view.states.CookbookListState;
import view.states.MainMenuState;
import view.view_managers.ViewManagerModel;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;

import java.util.ArrayList;

public class SeeListCookbooksPresenter implements SeeListCookbooksOutputBoundary {
    MainMenuViewModel mainMenuViewModel;
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
    public void prepareFailView(String error) {
    }
}
