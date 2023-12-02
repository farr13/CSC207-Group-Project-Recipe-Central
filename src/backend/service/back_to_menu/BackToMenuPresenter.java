package backend.service.back_to_menu;

import view.states.MainMenuState;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;

public class BackToMenuPresenter implements BackToMenuOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;
    public BackToMenuPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }
    @Override
    public void prepareSuccessView() {
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        this.mainMenuViewModel.setState(mainMenuState);
        mainMenuViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
