package backend.service.go_add_recipe;

public interface GoAddRecipeOutputBoundary {
    void prepareSuccessView(GoAddRecipeOutputData goAddRecipeOutputData);
    void prepareFailView();
}
