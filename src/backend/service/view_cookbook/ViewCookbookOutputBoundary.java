package backend.service.view_cookbook;

public interface ViewCookbookOutputBoundary {
    void prepareSuccessView(ViewCookbookOutputData viewCookbookOutputData);
    void prepareFailView();
}
