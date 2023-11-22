package users.service.delete_cookbook;

public class DeleteCookbookController {

    final DeleteCookbookInputBoundary deleteCookbookIteractor;

    public DeleteCookbookController(DeleteCookbookInputBoundary deleteCookbookIteractor) {
        this.deleteCookbookIteractor = deleteCookbookIteractor;
    }

    public void execute(String[] storedCookbooks) {
        DeleteCookbookInputData deleteCookbookInputData = new DeleteCookbookInputData(storedCookbooks);

        deleteCookbookIteractor.execute(deleteCookbookInputData);
    }
}
