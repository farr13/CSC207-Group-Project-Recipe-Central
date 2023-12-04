package backend.service.search_recipes.interface_adapters;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.search_recipes.application_business_rules.Boundary_Interfaces.SearchOutputBoundary;
import backend.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
import view.recipe_objects.Triplet;
import view.states.SearchResultState;
import view.view_managers.ViewManagerModel;
import view.view_models.SearchResultViewModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchPresenter implements SearchOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SearchResultViewModel searchResultViewModel;
    public SearchPresenter(ViewManagerModel viewManagerModel, SearchResultViewModel searchResultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchResultViewModel = searchResultViewModel;
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
    public void prepareSuccessView(SearchOutputData recipeResults) {
        SearchResultState currState = searchResultViewModel.getState();

        String[] recipeBlocks = createRecipeBlocks(recipeResults.getRecipes());

        currState.setRecipeLst(recipeBlocks);

        searchResultViewModel.setState(currState);
        searchResultViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(searchResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
