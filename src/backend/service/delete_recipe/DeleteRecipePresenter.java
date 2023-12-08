package backend.service.delete_recipe;

import backend.adapters.TripletsToRecipeBlocks;
import view.states.OpenCookbookState;
import view.view_models.OpenCookbookViewModel;

public class DeleteRecipePresenter implements DeleteRecipeOutputBoundary {
    private final OpenCookbookViewModel openCookbookViewModel;

    public DeleteRecipePresenter(OpenCookbookViewModel openCookbookViewModel) {
        this.openCookbookViewModel = openCookbookViewModel;
    }
    @Override
    public void prepareSuccessView(DeleteRecipeOutputData deleteRecipeOutputData) {
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookState.setRecipeBlocks(TripletsToRecipeBlocks.convert(deleteRecipeOutputData.getRecipes()));
        this.openCookbookViewModel.setState(openCookbookState);
        this.openCookbookViewModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView() {
        openCookbookViewModel.firePropertyChanged();
    }
}
