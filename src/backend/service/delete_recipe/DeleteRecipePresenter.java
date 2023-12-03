package backend.service.delete_recipe;

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
    private Triplet[] convertToTriplets(Recipe[] recipes){
        ArrayList<Triplet> storedTriplets = new ArrayList<Triplet>();
        for (Recipe recipe: recipes){
            ArrayList<String> descriptions = new ArrayList<String>();
            for (Ingredient ingredient: recipe.getIngredients())
                descriptions.add(ingredient.getTextDescription());

            Triplet tripletTemp = new Triplet(recipe.getName(),
                    recipe.getInstructions(), descriptions.toArray(descriptions.toArray(new String[0])));

            storedTriplets.add(tripletTemp);
        }
        return storedTriplets.toArray(new Triplet[0]);
    }
    @Override
    public void prepareSuccessView(DeleteRecipeOutputData deleteRecipeOutputData) {
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookState.setRecipes(convertToTriplets(deleteRecipeOutputData.getRecipes()));
        this.openCookbookViewModel.setState(openCookbookState);
        this.openCookbookViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(openCookbookViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookViewModel.firePropertyChanged();
    }
}
