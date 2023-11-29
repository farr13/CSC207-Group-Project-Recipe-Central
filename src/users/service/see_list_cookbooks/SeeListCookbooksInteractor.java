package users.service.see_list_cookbooks;

import users.entity.Cookbook;

public class SeeListCookbooksInteractor implements SeeListCookbooksInputBoundary{
    final SeeListCookbooksDataAccessInterface seeListCookbooksDataAccessObject;

    final SeeListCookbooksOutputBoundary seeListCookbooksPresnter;
    public SeeListCookbooksInteractor(SeeListCookbooksDataAccessInterface seeListCookbooksDataAccessInterface,
                                      SeeListCookbooksOutputBoundary seeListCookbooksOutputBoundary) {
        this.seeListCookbooksDataAccessObject = seeListCookbooksDataAccessInterface;
        this.seeListCookbooksPresnter = seeListCookbooksOutputBoundary;
    }

    @Override
    public void execute(SeeListCookbooksInputData seeListCookbooksInputData) {
        String[] cookbooks = seeListCookbooksDataAccessObject.getAllCookbooks();
        SeeListCookbooksOutputData seeListCookbooksOutputData = new SeeListCookbooksOutputData(cookbooks);
        seeListCookbooksPresnter.prepareSucceccView(seeListCookbooksOutputData);
    }
}
