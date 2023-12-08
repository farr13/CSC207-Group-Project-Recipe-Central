package backend.service.delete_cookbook;

public interface DeleteCookbookOutputBoundary {
    void prepareSuccessView(DeleteCookbookOutputData response);
    void prepareFailView();
}
