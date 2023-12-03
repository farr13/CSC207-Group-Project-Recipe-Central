package backend.service.add_recipe;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;

public class AddRecipeInteractor implements AddRecipeInputBoundary{
    final AddRecipeDAI addRecipeDAO;
    final AddRecipeOutputBoundary addRecipePresenter;

    public AddRecipeInteractor(AddRecipeDAI addRecipeDAO, AddRecipeOutputBoundary addRecipeOutputBoundary){
        this.addRecipeDAO = addRecipeDAO;
        this.addRecipePresenter = addRecipeOutputBoundary;
    }

    @Override
    public void execute(AddRecipeInputData addRecipeInputData) throws Exception {
        Cookbook cookbook = addRecipeDAO.getCookbook(addRecipeInputData.getCookbookName());
        String name = addRecipeInputData.getRecipeName();
        String instructions = addRecipeInputData.getInstructions();

        Ingredient[] ingredients = {};
        Recipe recipe = new Recipe(name, instructions, ingredients);

        addRecipeDAO.addRecipe(cookbook, recipe);
        addRecipePresenter.prepareSuccessView();
    }
}
