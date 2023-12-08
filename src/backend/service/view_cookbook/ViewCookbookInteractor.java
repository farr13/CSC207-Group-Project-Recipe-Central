package backend.service.view_cookbook;

import backend.adapters.RecipesToTriplets;
import backend.entity.Cookbook;

public class ViewCookbookInteractor implements ViewCookbookInputBoundary {
    final ViewCookbookDAI viewCookbookDAO;
    final ViewCookbookOutputBoundary viewCookbookPresenter;
    public ViewCookbookInteractor(ViewCookbookDAI viewCookbookDAO,
                                  ViewCookbookOutputBoundary viewCookbookPresenter) {
        this.viewCookbookDAO = viewCookbookDAO;
        this.viewCookbookPresenter = viewCookbookPresenter;
    }
    @Override
    public void execute(ViewCookbookInputData viewCookbookInputData) {
        ViewCookbookOutputData viewCookbookOutputData;
        try {
            Cookbook cookbook = viewCookbookDAO.viewCookbook(viewCookbookInputData.getName());
            viewCookbookOutputData = new ViewCookbookOutputData(cookbook.getName(), RecipesToTriplets.convert(cookbook.getRecipes()));

            viewCookbookPresenter.prepareSuccessView(viewCookbookOutputData);
        } catch (Exception e) {
            viewCookbookPresenter.prepareFailView(); //Could not retrieve cookbooks.
        }
    }
}
