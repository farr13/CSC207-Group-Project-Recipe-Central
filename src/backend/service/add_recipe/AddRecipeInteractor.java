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
        Ingredient ingredient = new Ingredient(addRecipeInputData.getIngredientDesc());
        Ingredient[] ingredients = {ingredient};
        Recipe recipe = new Recipe(addRecipeInputData.getRecipeName(), addRecipeInputData.getInstructions(),
                ingredients);
        addRecipeDAO.addRecipe(cookbook, recipe);

        AddRecipeOutputData addRecipeOutputData = new AddRecipeOutputData(addRecipeInputData.getRecipeName());
        addRecipePresenter.preparesuccessView(addRecipeOutputData);
    }
}
