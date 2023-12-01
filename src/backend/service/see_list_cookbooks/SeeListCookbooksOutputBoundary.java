package backend.service.see_list_cookbooks;

public interface SeeListCookbooksOutputBoundary {
    public void prepareSuccessView(SeeListCookbooksOutputData seeListCookbooksOutputData);
    public void prepareFailView();
}
