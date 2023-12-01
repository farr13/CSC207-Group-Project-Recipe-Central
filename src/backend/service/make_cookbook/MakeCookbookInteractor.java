package backend.service.make_cookbook;

import backend.entity.Cookbook;
import backend.entity.Recipe;

import java.util.Objects;

public class MakeCookbookInteractor implements MakeCookbookInputBoundary{

    final MakeCookbookAddDAI makeCookbookAddDAO;
    final MakeCookbookViewDAI makeCookbookViewDAO;
    final MakeCookbookOutputBoundary makeCookbookPresenter;
    public MakeCookbookInteractor(MakeCookbookAddDAI makeCookbookAddDAO,
                                  MakeCookbookViewDAI makeCookbookViewDAO, MakeCookbookOutputBoundary makeCookbookOutputBoundary) {
        this.makeCookbookAddDAO = makeCookbookAddDAO;
        this.makeCookbookViewDAO = makeCookbookViewDAO;
        this.makeCookbookPresenter = makeCookbookOutputBoundary;
    }
    private boolean existByTitle(String cookbookName, Cookbook[] cookbooks) {
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), cookbookName))
                return true;
        }
        return false;
    }
    @Override
    public void execute(MakeCookbookInputData makeCookbookInputData) {
        Cookbook[] cookbooks = makeCookbookViewDAO.viewCookbooks();
        if (!existByTitle(makeCookbookInputData.getTitle(), cookbooks)){
            Cookbook newCookbook = new Cookbook(makeCookbookInputData.getTitle(), new Recipe[]{});
            makeCookbookPresenter.prepareSuccessView(new MakeCookbookOutputData(newCookbook.getName()));
            try {
                makeCookbookAddDAO.addCookbook(newCookbook);
            } catch (Exception e) {
                makeCookbookPresenter.prepareFailView("Cookbook could not be made.");
            }
        }else{
            makeCookbookPresenter.prepareFailView("Cookbook could not be made.");
        }
    }
}
