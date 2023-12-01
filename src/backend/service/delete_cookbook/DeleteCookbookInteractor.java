package backend.service.delete_cookbook;

public class DeleteCookbookInteractor implements DeleteCookbookInputBoundary{

    final DeleteCookbookDataAccessInterface deleteCookbookDataAccessObject;

    final DeleteCookbookOutputBoundary deletePresenter;

    public DeleteCookbookInteractor(DeleteCookbookDataAccessInterface deleteCookbookDataAccessObject,
                                    DeleteCookbookOutputBoundary deleteCookbookOutputBoundary) {
        this.deletePresenter = deleteCookbookOutputBoundary;
        this.deleteCookbookDataAccessObject = deleteCookbookDataAccessObject;
    }

    @Override
    public void execute(DeleteCookbookInputData deleteCookbookInputData) {
        String[] storedCookbooks = deleteCookbookDataAccessObject.getStoredCookbooks();

        deleteCookbookDataAccessObject.deleteStoredCookbooks();

        DeleteCookbookOutputData deleteCookbookOutputData = new DeleteCookbookOutputData(storedCookbooks);
        deletePresenter.prepareSuccessView(deleteCookbookOutputData);
    }
}
