package backend.service.delete_cookbook;

public class DeleteCookbookInteractor implements DeleteCookbookInputBoundary{

    final DeleteCookbookDeleteDAI deleteCookbookDAO;

    final DeleteCookbookOutputBoundary deletePresenter;

    public DeleteCookbookInteractor(DeleteCookbookDeleteDAI deleteCookbookDAO,
                                    DeleteCookbookOutputBoundary deleteCookbookOutputBoundary) {
        this.deletePresenter = deleteCookbookOutputBoundary;
        this.deleteCookbookDAO = deleteCookbookDAO;
    }

    @Override
    public void execute(DeleteCookbookInputData deleteCookbookInputData) {
        try {
            deleteCookbookDAO.deleteCookbook(deleteCookbookInputData.getCookbookName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        DeleteCookbookOutputData deleteCookbookOutputData = new DeleteCookbookOutputData(deleteCookbookInputData.getCookbookName());
        deletePresenter.prepareSuccessView(deleteCookbookOutputData);
    }
}
