package backend.service.make_cookbook;

import backend.entity.Cookbook;
import backend.entity.Recipe;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;

import java.util.Objects;

public class MakeCookbookInteractor implements MakeCookbookInputBoundary{

    final MakeCookbookAddDAI makeCookbookAddDAO;
    final SeeListCookbooksDAI seeListCookbooksDAO;
    final MakeCookbookOutputBoundary makeCookbookPresenter;
    public MakeCookbookInteractor(MakeCookbookAddDAI makeCookbookAddDAO, SeeListCookbooksDAI seeListCookbooksDAO,
                                  MakeCookbookOutputBoundary makeCookbookOutputBoundary) {
        this.makeCookbookAddDAO = makeCookbookAddDAO;
        this.seeListCookbooksDAO = seeListCookbooksDAO;
        this.makeCookbookPresenter = makeCookbookOutputBoundary;
    }
    private boolean existByTitle(String cookbookName, Cookbook[] cookbooks) throws Exception {
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), cookbookName))
                return true;
        }
        throw new RuntimeException("Could not read cookbooks.");
    }
    @Override
    public void execute(MakeCookbookInputData makeCookbookInputData) {
        Cookbook[] cookbooks = new Cookbook[0];
        try {
            cookbooks = seeListCookbooksDAO.viewCookbooks();
            if (!existByTitle(makeCookbookInputData.getTitle(), cookbooks)) {
                Cookbook newCookbook = new Cookbook(makeCookbookInputData.getTitle(), new Recipe[]{});
                makeCookbookPresenter.prepareSuccessView(new MakeCookbookOutputData(seeListCookbooksDAO.viewCookbooks()));
                makeCookbookAddDAO.addCookbook(newCookbook);
            }else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            makeCookbookPresenter.prepareFailView("Cookbook could not be made.");
        }
    }
}
