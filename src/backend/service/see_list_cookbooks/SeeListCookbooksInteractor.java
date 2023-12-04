package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

import java.util.ArrayList;

public class SeeListCookbooksInteractor implements SeeListCookbooksInputBoundary{
    final SeeListCookbooksDAI seeListCookbooksDAO;

    final SeeListCookbooksOutputBoundary seeListCookbooksPresenter;
    public SeeListCookbooksInteractor(SeeListCookbooksDAI seeListCookbooksDAI,
                                      SeeListCookbooksOutputBoundary seeListCookbooksPresenter) {
        this.seeListCookbooksDAO = seeListCookbooksDAI;
        this.seeListCookbooksPresenter = seeListCookbooksPresenter;
    }

    private String[] getCookbookNames(Cookbook[] cookbooks){
        ArrayList<String> cookbookNames = new ArrayList<String>();
        for (Cookbook cookbook: cookbooks)
            cookbookNames.add(cookbook.getName());
        return cookbookNames.toArray(new String[0]);
    }

    @Override
    public void execute(SeeListCookbooksInputData seeListCookbooksInputData) {
        try {
            Cookbook[] cookbooks = seeListCookbooksDAO.viewCookbooks();
            SeeListCookbooksOutputData seeListCookbooksOutputData = new SeeListCookbooksOutputData(getCookbookNames(cookbooks));
            seeListCookbooksPresenter.prepareSuccessView(seeListCookbooksOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            seeListCookbooksPresenter.prepareFailView("Could not get cookbooks.");
        }
    }
}
