package users.service.make_cookbook;

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
    }
}
