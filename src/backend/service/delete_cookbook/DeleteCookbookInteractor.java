package backend.service.delete_cookbook;

import backend.entity.Cookbook;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;

import java.util.ArrayList;

public class DeleteCookbookInteractor implements DeleteCookbookInputBoundary{
    final private DeleteCookbookDAI deleteCookbookDAO;
    final private SeeListCookbooksDAI viewCookbookDAO;
    final private DeleteCookbookOutputBoundary deletePresenter;

    public DeleteCookbookInteractor(DeleteCookbookDAI deleteCookbookDAO,
                                    SeeListCookbooksDAI viewCookbookDAO,
                                    DeleteCookbookOutputBoundary deleteCookbookOutputBoundary) {
        this.viewCookbookDAO = viewCookbookDAO;
        this.deletePresenter = deleteCookbookOutputBoundary;
        this.deleteCookbookDAO = deleteCookbookDAO;
    }

    private String[] getCookbookNames(Cookbook[] cookbooks) {
        ArrayList<String> cookbookNames = new ArrayList<>();
        for (Cookbook cookbook: cookbooks)
            cookbookNames.add(cookbook.getName());
        return cookbookNames.toArray(new String[0]);
    }

    @Override
    public void execute(DeleteCookbookInputData deleteCookbookInputData) {
        try {
            deleteCookbookDAO.deleteCookbooks(deleteCookbookInputData.getStoredCookbooks());
            String[] newCookbookNames = getCookbookNames(viewCookbookDAO.viewCookbooks());
            DeleteCookbookOutputData deleteCookbookOutputData = new DeleteCookbookOutputData(newCookbookNames);
            deletePresenter.prepareSuccessView(deleteCookbookOutputData);
        } catch (Exception e) {
            deletePresenter.prepareFailView(); //Could not delete all selected cookbooks.
        }
    }
}
