package backend.service.view_cookbook;

public class ViewCookbookInteractor implements ViewCookbookInputBoundary {

    final ViewCookbookViewDAI viewCookbookDAO;

    final ViewCookbookOutputBoundary viewCookbookPresenter;

    public ViewCookbookInteractor(ViewCookbookViewDAI viewCookbookDAO,
                                  ViewCookbookOutputBoundary viewCookbookPresenter) {
        this.viewCookbookDAO = viewCookbookDAO;
        this.viewCookbookPresenter = viewCookbookPresenter;
    }
    @Override
    public void execute(ViewCookbookInputData viewCookbookInputData) {
        ViewCookbookOutputData viewCookbookOutputData;
        try {
            viewCookbookOutputData = new ViewCookbookOutputData(viewCookbookDAO.viewCookbook(viewCookbookInputData.getName()));
            viewCookbookPresenter.prepareSuccessView(viewCookbookOutputData);
        } catch (Exception e) {
            viewCookbookPresenter.prepareFailView("Could not retrieve cookbooks.");
        }
    }
}
