package users.service.view_cookbook;

public interface ViewCookbookOutputBoundary {
    void presentSuccess(ViewCookbookOutputData outputData);
    void presentError(String errorMessage);
}
