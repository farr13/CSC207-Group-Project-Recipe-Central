package backend.service.rename_cookbook;

public class RenameCookbookController {
    final RenameCookbookInputBoundary renameCookbookInteractor;

    public RenameCookbookController(RenameCookbookInputBoundary renameCookbookInteractor) {
        this.renameCookbookInteractor = renameCookbookInteractor;
    }

    public void execute(String cookbookNameNew, String cookbookNameOld) {
        RenameCookbookInputData renameCookbookInputData = new RenameCookbookInputData(cookbookNameNew, cookbookNameOld);
        renameCookbookInteractor.execute(renameCookbookInputData);
    }
}
