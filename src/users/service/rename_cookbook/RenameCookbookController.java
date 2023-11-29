package users.service.rename_cookbook;

public class RenameCookbookController {
    final RenameCookbookInputBoundary renameCookbookInteractor;

    public RenameCookbookController(RenameCookbookInputBoundary renameCookbookInteractor) {
        this.renameCookbookInteractor = renameCookbookInteractor;
    }

    public void execute(String cookbookName) {
        RenameCookbookInputData renameCookbookInputData = new RenameCookbookInputData(cookbookName);
        renameCookbookInteractor.execute(renameCookbookInputData);
    }
}
