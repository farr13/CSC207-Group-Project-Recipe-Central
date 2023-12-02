package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

public class SeeListCookbooksInteractor implements SeeListCookbooksInputBoundary{
    final SeeListCookbooksDAI seeListCookbooksDAO;

    final SeeListCookbooksOutputBoundary seeListCookbooksPresenter;
    public SeeListCookbooksInteractor(SeeListCookbooksDAI seeListCookbooksDAI,
                                      SeeListCookbooksOutputBoundary seeListCookbooksPresenter) {
        this.seeListCookbooksDAO = seeListCookbooksDAI;
        this.seeListCookbooksPresenter = seeListCookbooksPresenter;
    }

    @Override
    public void execute(SeeListCookbooksInputData seeListCookbooksInputData) {
        try {
            Cookbook[] cookbooks = seeListCookbooksDAO.viewCookbooks();
            SeeListCookbooksOutputData seeListCookbooksOutputData = new SeeListCookbooksOutputData(cookbooks);
            seeListCookbooksPresenter.prepareSuccessView(seeListCookbooksOutputData);
        } catch (Exception e) {
            seeListCookbooksPresenter.prepareFailView("Could not get cookbooks.");
        }
    }
}
