package users.service.see_list_cookbooks;

public class SeeListCookbooksController {
    final SeeListCookbooksInputBoundary seeListCookbooksIteractor;

    public SeeListCookbooksController(SeeListCookbooksInputBoundary seeListCookbooksIteractor) {
        this.seeListCookbooksIteractor = seeListCookbooksIteractor;
    }

    public void execute(String[] cookbooks) {
        SeeListCookbooksInputData seeListCookbooksInputData = new SeeListCookbooksInputData(cookbooks);
        seeListCookbooksIteractor.execute(seeListCookbooksInputData);
    }
}
