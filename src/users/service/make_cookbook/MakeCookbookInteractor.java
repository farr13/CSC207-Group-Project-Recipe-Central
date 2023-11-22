package users.service.make_cookbook;

import users.entity.Cookbook;
import users.entity.Recipe;

import java.util.ArrayList;

public class MakeCookbookInteractor implements MakeCookbookInputBoundary{

    final MakeCookbookDataAccessInterface makeCookbookDataAccessObject;
    final MakeCookbookOutputBoundary makeCookbookPresenter;
    public MakeCookbookInteractor(MakeCookbookDataAccessInterface makeCookbookDataAccessObject,
                                  MakeCookbookOutputBoundary makeCookbookOutputBoundary) {
        this.makeCookbookDataAccessObject = makeCookbookDataAccessObject;
        this.makeCookbookPresenter = makeCookbookOutputBoundary;
    }

    @Override
    public void execute(MakeCookbookInputData makeCookbookInputData) {
        String title = makeCookbookInputData.getTitle();
        if (!makeCookbookDataAccessObject.existByTitle(title)) {
            makeCookbookPresenter.prepareFailView(title + "Cookbook title already exist.");
        }
        else {
            Cookbook cookbook = makeCookbookDataAccessObject.get(makeCookbookInputData.getTitle());

            MakeCookbookOutputData makeCookbookOutputData = new MakeCookbookOutputData(
                    cookbook.getName(), false);
            makeCookbookPresenter.prepareSuccessView(makeCookbookOutputData);
        }
    }
}
