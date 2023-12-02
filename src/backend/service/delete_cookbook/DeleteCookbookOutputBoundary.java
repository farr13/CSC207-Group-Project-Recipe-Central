package backend.service.delete_cookbook;

public interface DeleteCookbookOutputBoundary {

    public void prepareSuccessView(DeleteCookbookOutputData response);
    public void prepareFailView(String error);
}
