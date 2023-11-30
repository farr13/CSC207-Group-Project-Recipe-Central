package backend.service.rename_cookbook;

public interface RenameCookbookOutputBoundary {
    public void prepareSuccessView(RenameCookbookOutputdata name);
    public void prepareFailView();
}
