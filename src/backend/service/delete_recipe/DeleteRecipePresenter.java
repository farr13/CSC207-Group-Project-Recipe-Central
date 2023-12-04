package backend.service.delete_recipe;

import backend.adapters.TripletsToRecipeBlocks;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import view.recipe_objects.*;
import view.states.OpenCookbookState;
import view.view_managers.ViewManagerModel;
import view.view_models.OpenCookbookViewModel;

import java.util.ArrayList;

public class DeleteRecipePresenter implements DeleteRecipeOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final OpenCookbookViewModel openCookbookViewModel;

    public DeleteRecipePresenter(ViewManagerModel viewManagerModel, OpenCookbookViewModel openCookbookViewModel) {
        this.viewManagerModel = viewManagerModel;
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
    public void prepareFailView(String error) {
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookViewModel.firePropertyChanged();
    }
}
