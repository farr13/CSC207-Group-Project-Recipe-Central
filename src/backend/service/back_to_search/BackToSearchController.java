package backend.service.back_to_search;

public class BackToSearchController {
    private final BackToSearchInputBoundary backToMenuInteractor;
    public BackToSearchController(BackToSearchInputBoundary backToMenuInteractor) {
        this.backToMenuInteractor = backToMenuInteractor;
    }
    public void execute() {
        backToMenuInteractor.execute();
    }
}
