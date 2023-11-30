package backend.service.delete_cookbook;

public interface DeleteRecipeOutputBoundary {
    void prepareSuccessView(DeleteRecipeOutputData deleteRecipeOutputData);
    void prepareFailView();
}
