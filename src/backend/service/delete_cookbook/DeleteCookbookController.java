package backend.service.delete_cookbook;

public class  DeleteCookbookController {
    private final DeleteCookbookInputBoundary deleteCookbookIteractor;
    public DeleteCookbookController(DeleteCookbookInputBoundary deleteCookbookIteractor) {
        this.deleteCookbookIteractor = deleteCookbookIteractor;
    }
    public void execute(String[] deleteCookbooks) {
        DeleteCookbookInputData deleteCookbookInputData = new DeleteCookbookInputData(deleteCookbooks);
        deleteCookbookIteractor.execute(deleteCookbookInputData);
    }
}
