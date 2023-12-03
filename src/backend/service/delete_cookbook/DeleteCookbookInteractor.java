package backend.service.delete_cookbook;

import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import backend.service.view_cookbook.ViewCookbookDAI;

public class DeleteCookbookInteractor implements DeleteCookbookInputBoundary{

    final private DeleteCookbookDAI deleteCookbookDAO;
    final private SeeListCookbooksDAI viewCookbookDAO;
    final private DeleteCookbookOutputBoundary deletePresenter;

    public DeleteCookbookInteractor(DeleteCookbookDAI deleteCookbookDAO,
                                    SeeListCookbooksDAI viewCookbookDAO, DeleteCookbookOutputBoundary deleteCookbookOutputBoundary) {
        this.viewCookbookDAO = viewCookbookDAO;
        this.deletePresenter = deleteCookbookOutputBoundary;
        this.deleteCookbookDAO = deleteCookbookDAO;
    }

    @Override
    public void execute(DeleteCookbookInputData deleteCookbookInputData) {
        try {
            deleteCookbookDAO.deleteCookbooks(deleteCookbookInputData.getStoredCookbooks());
            DeleteCookbookOutputData deleteCookbookOutputData = new DeleteCookbookOutputData(viewCookbookDAO.viewCookbooks());
            deletePresenter.prepareSuccessView(deleteCookbookOutputData);
        } catch (Exception e) {
            deletePresenter.prepareFailView("Could not delete all selected cookbooks.");
        }
    }
}
