package backend.service.back_to_menu;

import view.view_models.MainMenuViewModel;

public class BackToMenuPresenter implements BackToMenuOutputBoundary {
    private final MainMenuViewModel mainMenuViewModel;
    public BackToMenuPresenter(MainMenuViewModel mainMenuViewModel) {
        this.mainMenuViewModel = mainMenuViewModel;
    }
    @Override
    public void prepareSuccessView() {
        System.out.println("MAIN MENU");
    }
}
