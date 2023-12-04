package backend.service.add_recipe;

import backend.adapters.TripletsToRecipes;
import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class AddRecipeInteractor implements AddRecipeInputBoundary{
    private final AddRecipeOutputBoundary addRecipePresenter;
    private final AddRecipeDAI addRecipeDAO;

    public AddRecipeInteractor(AddRecipeDAI addRecipeDAO, AddRecipeOutputBoundary addRecipeOutputBoundary){
        this.addRecipeDAO = addRecipeDAO;
        this.addRecipePresenter = addRecipeOutputBoundary;
    }

    @Override
    public void execute(AddRecipeInputData addRecipeInputData) {
        try {
            if (addRecipeInputData.getRecipe().length == 0 || addRecipeInputData.getCookbookName().length == 0)
                throw new Exception("Select a cookbook or recipe.");
            addRecipeDAO.addRecipe(addRecipeInputData.getCookbookName(), TripletsToRecipes.convert(addRecipeInputData.getRecipe()));
            addRecipePresenter.prepareSuccessView(new AddRecipeOutputData());
        } catch (Exception e) {
            addRecipePresenter.prepareFailView("Improper selection");
        }

    }
}
