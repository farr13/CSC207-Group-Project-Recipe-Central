package backend.service.delete_cookbook;

public class DeleteCookbookInteractor implements DeleteCookbookInputBoundary{

    final DeleteCookbookDAI deleteCookbookDAO;

    final DeleteCookbookOutputBoundary deletePresenter;

    public DeleteCookbookInteractor(DeleteCookbookDAI deleteCookbookDAO,
                                    DeleteCookbookOutputBoundary deleteCookbookOutputBoundary) {
        this.deletePresenter = deleteCookbookOutputBoundary;
        this.deleteCookbookDAO = deleteCookbookDAO;
    }

    @Override
    public void execute(DeleteCookbookInputData deleteCookbookInputData) {
        try {
            deleteCookbookDAO.deleteCookbooks(deleteCookbookInputData.getStoredCookbooks());
            DeleteCookbookOutputData deleteCookbookOutputData = new DeleteCookbookOutputData(deleteCookbookInputData.getStoredCookbooks());
            deletePresenter.prepareSuccessView(deleteCookbookOutputData);
        } catch (Exception e) {
            deletePresenter.prepareFailView("Could not delete all selected cookbooks.");
        }
    }
}
