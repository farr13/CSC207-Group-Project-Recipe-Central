package backend.service.view_cookbook;

public class ViewCookbookController {
    private final ViewCookbookInputBoundary viewCookbookInteractor;
    public ViewCookbookController(ViewCookbookInputBoundary viewCookbookInteractor) {
        this.viewCookbookInteractor = viewCookbookInteractor;
    }
    public void execute(String name) {
        ViewCookbookInputData viewCookbookInputData = new ViewCookbookInputData(name);
        viewCookbookInteractor.execute(viewCookbookInputData);
    }
}
