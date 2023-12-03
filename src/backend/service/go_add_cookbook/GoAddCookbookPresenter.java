package backend.service.go_add_cookbook;

import view.states.AddCookbookState;
import view.states.MainMenuState;
import view.view_managers.ViewManagerModel;
import view.view_models.AddCookbookViewModel;
import view.view_models.MainMenuViewModel;

public class GoAddCookbookPresenter implements GoAddCookbookOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final AddCookbookViewModel addCookbookViewModel;
    public GoAddCookbookPresenter(ViewManagerModel viewManagerModel, AddCookbookViewModel addCookbookViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addCookbookViewModel = addCookbookViewModel;
    }
    @Override
    public void prepareSuccessView() {
        AddCookbookState addCookbookState = addCookbookViewModel.getState();
        addCookbookState.setErrorMessage("");
        this.addCookbookViewModel.setState(addCookbookState);
        this.addCookbookViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(addCookbookViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
