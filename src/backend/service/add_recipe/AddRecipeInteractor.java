package backend.service.add_recipe;

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

    private Recipe[] convertTripletToRecipes(Triplet[] triplets){
        ArrayList<Recipe> storedRecipes = new ArrayList<>();
        for (Triplet triplet: triplets){
            ArrayList<Ingredient> storedIngredients= new ArrayList<Ingredient>();
            for (String description: triplet.getList())
                storedIngredients.add(new Ingredient(description));
            Recipe recipeTemp = new Recipe(triplet.getName(), triplet.getLink(), storedIngredients.toArray(new Ingredient[0]));
            storedRecipes.add(recipeTemp);
        }

        return storedRecipes.toArray(new Recipe[0]);
    }

    @Override
    public void execute(AddRecipeInputData addRecipeInputData) {
        try {
            addRecipeDAO.addRecipe(addRecipeInputData.getCookbookName(), convertTripletToRecipes(addRecipeInputData.getRecipe()));
            addRecipePresenter.prepareSuccessView(new AddRecipeOutputData());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
