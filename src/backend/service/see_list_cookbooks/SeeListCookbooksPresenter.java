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
    public SeeListCookbooksPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel,
                                     CookbookListViewModel cookbookListViewModel){
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
        this.cookbookListViewModel = cookbookListViewModel;
    }
    private String[] getCookbookNames(Cookbook[] cookbooks){
        ArrayList<String> cookbookNames = new ArrayList<String>();
        for (Cookbook cookbook: cookbooks)
            cookbookNames.add(cookbook.getName());
        return cookbookNames.toArray(new String[0]);
    }
    @Override
    public void prepareSuccessView(SeeListCookbooksOutputData seeListCookbooksOutputData) {

        CookbookListState cookbookListState = cookbookListViewModel.getState();
        cookbookListState.setCookbookNames(getCookbookNames(seeListCookbooksOutputData.getCookbooks()));
        this.cookbookListViewModel.setState(cookbookListState);
        this.cookbookListViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(cookbookListViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        mainMenuState.setErrorMessage(error);
        mainMenuViewModel.firePropertyChanged();
    }
}
