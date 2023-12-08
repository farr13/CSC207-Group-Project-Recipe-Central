package backend.service.see_list_cookbooks;

public class SeeListCookbooksController {
    private final SeeListCookbooksInputBoundary seeListCookbooksIteractor;
    public SeeListCookbooksController(SeeListCookbooksInputBoundary seeListCookbooksIteractor) {
        this.seeListCookbooksIteractor = seeListCookbooksIteractor;
    }
    public void execute() {
        seeListCookbooksIteractor.execute();
    }
}
