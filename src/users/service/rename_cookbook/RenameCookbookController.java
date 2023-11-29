package users.service.rename_cookbook;

import users.service.rename_cookbook.*;

public class RenameCookbookController {
    private final RenameCookbookInputBoundary interactor;
    private final RenameCookbookOutputBoundary presenter;

    public RenameCookbookController(RenameCookbookInputBoundary interactor,
                                    RenameCookbookOutputBoundary presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    public void renameCookbook(String oldName, String newName) {
        RenameCookbookInputData inputData = new RenameCookbookInputData(oldName, newName);
        try {
            interactor.execute(inputData);
            presenter.present(new RenameCookbookOutputData(true, "Cookbook renamed successfully."));
        } catch (CookbookNotFoundException e) {
            presenter.present(new RenameCookbookOutputData(false, e.getMessage()));
        } catch (Exception e) {
            presenter.present(new RenameCookbookOutputData(false, "An unexpected error occurred."));
        }
    }
}
