package backend.service.view_cookbook;

public interface ViewCookbookOutputBoundary {
    public void prepareSuccessView(ViewCookbookOutputData viewCookbookOutputData);
    public void prepareFailView(String error);
}
