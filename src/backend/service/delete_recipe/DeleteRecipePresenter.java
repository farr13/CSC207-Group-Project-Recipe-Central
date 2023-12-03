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
    private String[] createRecipeBlocks(Triplet[] recipes){
        ArrayList<String> recipeBlocks = new ArrayList<String>();
        for (Triplet recipe: recipes){
            StringBuilder temp;
            String[] ingredients = recipe.getList();
            temp = new StringBuilder(("<html>Recipe:<html>  " + "<html>_" + recipe.getName() + "_<html>" + "<br>Instructions: _"
                    + recipe.getLink() + "_<br> Ingredients:_"));
            for (String ingredient: ingredients){
                temp.append(" ").append(ingredient).append(",");
            }
            temp.append("_<br> <br>");
            recipeBlocks.add(temp.toString());
        }

        return recipeBlocks.toArray(new String[0]);
    }
    @Override
    public void prepareSuccessView(DeleteRecipeOutputData deleteRecipeOutputData) {
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookState.setRecipeBlocks(createRecipeBlocks(deleteRecipeOutputData.getRecipes()));
        this.openCookbookViewModel.setState(openCookbookState);
        this.openCookbookViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        OpenCookbookState openCookbookState = openCookbookViewModel.getState();
        openCookbookViewModel.firePropertyChanged();
    }
}
