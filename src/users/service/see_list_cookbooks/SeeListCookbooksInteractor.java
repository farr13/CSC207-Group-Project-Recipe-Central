package users.service.see_list_cookbooks;

public class SeeListCookbooksInteractor implements SeeListCookbooksInputBoundary{
    final SeeListCookbooksDataAccessInterface seeListCookbooksDataAccessObject;

    final SeeListCookbooksOutputBoundary seeListCookbooksPresnter;
    public SeeListCookbooksInteractor(SeeListCookbooksDataAccessInterface seeListCookbooksDataAccessInterface,
                                      SeeListCookbooksOutputBoundary seeListCookbooksOutputBoundary) {
        this.seeListCookbooksDataAccessObject = seeListCookbooksDataAccessInterface;
        this.seeListCookbooksPresnter = seeListCookbooksOutputBoundary;
    }

    @Override
    public void execute(SeeListCookbooksInputBoundary seeListCookbooksInputBoundary) {

    }
}
