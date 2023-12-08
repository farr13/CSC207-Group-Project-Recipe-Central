package backend.service.back_to_search;

public class BackToSearchInteractor implements BackToSearchInputBoundary {
    private final BackToSearchOutputBoundary backToMenuPresenter;
    public BackToSearchInteractor(BackToSearchOutputBoundary backToMenuPresenter) {
        this.backToMenuPresenter = backToMenuPresenter;
    }
    @Override
    public void execute() {
        backToMenuPresenter.prepareSuccessView();
    }
}
