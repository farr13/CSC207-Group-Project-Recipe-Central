package backend.service.back_to_menu;

import view.states.MainMenuState;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;

public class BackToMenuPresenter implements BackToMenuOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final MainMenuViewModel mainMenuViewModel;
    public BackToMenuPresenter(ViewManagerModel viewManagerModel, MainMenuViewModel mainMenuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.mainMenuViewModel = mainMenuViewModel;
    }
    @Override
    public void prepareSuccessView() {
        System.out.println("here");
        MainMenuState mainMenuState = mainMenuViewModel.getState();
        this.mainMenuViewModel.setState(mainMenuState);
        this.mainMenuViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(mainMenuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
