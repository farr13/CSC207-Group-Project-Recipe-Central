package users.service.rename_cookbook;

public class RenameCookbookInteractor implements RenameCookbookInputBoundary{

    final RenameCookbookDataAccessInterface renameCookbookDataAccessObject;

    final RenameCookbookOutputBoundary renameCookbookPresenter;

    public RenameCookbookInteractor(RenameCookbookDataAccessInterface renameCookbookDataAccessInterface,
                                    RenameCookbookOutputBoundary renameCookbookOutputBoundary) {
        this.renameCookbookDataAccessObject = renameCookbookDataAccessInterface;
        this.renameCookbookPresenter = renameCookbookOutputBoundary;
    }

    @Override
    public void execute(RenameCookbookInputData renameCookbookInputData){
        String cookbookName = renameCookbookInputData.getCookbookname();
        renameCookbookDataAccessObject.changeCookbookName(cookbookName);
        RenameCookbookOutputdata renameCookbookOutputdata = new RenameCookbookOutputdata(cookbookName);
        renameCookbookPresenter.prepareSuccessView(renameCookbookOutputdata);
    }
}
