package backend.service.delete_recipe;

public interface DeleteRecipeOutputBoundary {
    void prepareSuccessView(DeleteRecipeOutputData deleteRecipeOutputData);
    void prepareFailView(String error);
}
