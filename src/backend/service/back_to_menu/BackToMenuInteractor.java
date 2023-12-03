package backend.service.back_to_menu;

public class BackToMenuInteractor implements BackToMenuInputBoundary {
    private final BackToMenuOutputBoundary backToMenuPresenter;

    public BackToMenuInteractor(BackToMenuOutputBoundary backToMenuPresenter) {
        this.backToMenuPresenter = backToMenuPresenter;
    }
    @Override
    public void execute() {
        backToMenuPresenter.prepareSuccessView();
    }
}
