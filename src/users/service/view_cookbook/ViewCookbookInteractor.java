package users.service.view_cookbook;

public class ViewCookbookInteractor implements ViewCookbookInputBoundary {

    final ViewCookbookDataAccessInterface cookbookDataAccessObject;

    final ViewCookbookOutputBoundary viewCookbookPresenter;

    public ViewCookbookInteractor(ViewCookbookDataAccessInterface cookbookDataAccessObject,
                                  ViewCookbookOutputBoundary viewCookbookOutputBoundary) {
        this.viewCookbookPresenter = viewCookbookOutputBoundary;
        this.cookbookDataAccessObject = cookbookDataAccessObject;
    }
    @Override
    public void execute(ViewCookbookInputData viewCookbookInputData) {
        ViewCookbookOutputData viewCookbookOutputData =
                new ViewCookbookOutputData(cookbookDataAccessObject.getCookbook(viewCookbookInputData.getName()));
        viewCookbookPresenter.prepareSuccessView(viewCookbookOutputData);
    }
}
