package backend.service.rename_cookbook;

import backend.entity.Cookbook;
import backend.service.rename_cookbook.DAI.RenameCookbookAddDAI;
import backend.service.rename_cookbook.DAI.RenameCookbookDeleteDAI;
import backend.service.rename_cookbook.DAI.RenameCookbookViewDAI;
import backend.service.view_cookbook.ViewCookbookDAI;

public class RenameCookbookInteractor implements RenameCookbookInputBoundary{

    final RenameCookbookDeleteDAI deleteCookbookDAO;
    final RenameCookbookViewDAI viewCookbookDAO;
    final RenameCookbookAddDAI addCookbookDAO;
    final RenameCookbookOutputBoundary renameCookbookPresenter;

    public RenameCookbookInteractor(RenameCookbookDeleteDAI deleteCookbookDAO,
                                    RenameCookbookViewDAI viewCookbookDAO,
                                    RenameCookbookAddDAI addCookbookDAO,
                                    RenameCookbookOutputBoundary renameCookbookOutputBoundary) {
        this.deleteCookbookDAO = deleteCookbookDAO;
        this.viewCookbookDAO = viewCookbookDAO;
        this.addCookbookDAO = addCookbookDAO;
        this.renameCookbookPresenter = renameCookbookOutputBoundary;
    }

    @Override
    public void execute(RenameCookbookInputData renameCookbookInputData){
        try {
            Cookbook oldCookbook = viewCookbookDAO.viewCookbook(renameCookbookInputData.getCookbookNameOld());
            Cookbook newCookbook = new Cookbook(renameCookbookInputData.getCookbookNameNew(), oldCookbook.getRecipes());
            deleteCookbookDAO.deleteCookbook(oldCookbook);
            addCookbookDAO.addCookbook(newCookbook);
            renameCookbookPresenter.prepareSuccessView(new RenameCookbookOutputdata(newCookbook.getName()));
        } catch (Exception e) {
            renameCookbookPresenter.prepareFailView();
        }
    }
}
