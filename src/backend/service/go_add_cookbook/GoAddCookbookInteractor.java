package backend.service.go_add_cookbook;

public class GoAddCookbookInteractor implements GoAddCookbookInputBoundary {
    private final GoAddCookbookOutputBoundary goAddCookbookPresenter;
    public GoAddCookbookInteractor(GoAddCookbookOutputBoundary goAddCookbookPresenter) {
        this.goAddCookbookPresenter = goAddCookbookPresenter;
    }
    @Override
    public void execute() {
        goAddCookbookPresenter.prepareSuccessView();

    }
}
