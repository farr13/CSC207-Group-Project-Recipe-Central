package backend.service.add_recipe;

public interface AddRecipeOutputBoundary {
    void prepareSuccessView(AddRecipeOutputData addRecipeOutputData);
    void prepareFailView(String error);
}
