package backend.service.see_list_cookbooks;

public class SeeListCookbooksController {
    final SeeListCookbooksInputBoundary seeListCookbooksIteractor;

    public SeeListCookbooksController(SeeListCookbooksInputBoundary seeListCookbooksIteractor) {
        this.seeListCookbooksIteractor = seeListCookbooksIteractor;
    }

    public void execute() {
        SeeListCookbooksInputData seeListCookbooksInputData = new SeeListCookbooksInputData();
        seeListCookbooksIteractor.execute(seeListCookbooksInputData);
    }
}
