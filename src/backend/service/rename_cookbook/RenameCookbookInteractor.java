package backend.service.rename_cookbook;

import backend.entity.Cookbook;
import backend.data_access_interfaces.AddCookbookDAI;
import backend.data_access_interfaces.DeleteCookbookDAI;
import backend.data_access_interfaces.ViewCookbookDAI;

public class RenameCookbookInteractor implements RenameCookbookInputBoundary{

    final DeleteCookbookDAI deleteCookbookDAO;
    final ViewCookbookDAI viewCookbookDAO;
    final AddCookbookDAI addCookbookDAO;
    final RenameCookbookOutputBoundary renameCookbookPresenter;

    public RenameCookbookInteractor(DeleteCookbookDAI deleteCookbookDAO,
                                    ViewCookbookDAI viewCookbookDAO,
                                    AddCookbookDAI addCookbookDAO,
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
