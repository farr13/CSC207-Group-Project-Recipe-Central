package backend.service.see_list_cookbooks;

public interface SeeListCookbooksOutputBoundary {
    void prepareSuccessView(SeeListCookbooksOutputData seeListCookbooksOutputData);
    void prepareFailView();
}
