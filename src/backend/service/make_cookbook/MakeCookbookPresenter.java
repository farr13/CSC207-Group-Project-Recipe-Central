package backend.service.make_cookbook;

import backend.entity.Cookbook;
import view.states.AddCookbookState;
import view.states.CookbookListState;
import view.view_managers.ViewManagerModel;
import view.view_models.AddCookbookViewModel;
import view.view_models.CookbookListViewModel;

import java.util.ArrayList;

public class MakeCookbookPresenter implements MakeCookbookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final CookbookListViewModel cookbookListViewModel;
    private final AddCookbookViewModel addCookbookViewModel;

    public MakeCookbookPresenter(ViewManagerModel viewManagerModel, CookbookListViewModel cookbookListViewModel,
                                 AddCookbookViewModel addCookbookViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.cookbookListViewModel = cookbookListViewModel;
        this.addCookbookViewModel = addCookbookViewModel;
    }
    private String[] convertCookbookNames(Cookbook[] cookbooks){
        ArrayList<String> cookbookNames = new ArrayList<String>();
        for (Cookbook cookbook: cookbooks)
            cookbookNames.add(cookbook.getName());
        return cookbookNames.toArray(new String[0]);
    }
    @Override
    public void prepareSuccessView(MakeCookbookOutputData makeCookbookOutputData) {
        String[] cookbookNames = convertCookbookNames(makeCookbookOutputData.getCookbooks());
        CookbookListState cookbookListState = cookbookListViewModel.getState();
        cookbookListState.setCookbookNames(cookbookNames);
        this.cookbookListViewModel.setState(cookbookListState);
        this.cookbookListViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(cookbookListViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        AddCookbookState addCookbookState = addCookbookViewModel.getState();
        addCookbookViewModel.firePropertyChanged();
    }
}
