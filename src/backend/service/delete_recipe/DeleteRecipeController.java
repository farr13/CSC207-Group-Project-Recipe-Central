package backend.service.delete_recipe;

import backend.entity.Ingredient;
import backend.entity.Recipe;
import view.recipe_objects.*;

import java.util.ArrayList;

public class DeleteRecipeController {

    final DeleteRecipeInputBoundary deleteRecipeInteractor;

    public DeleteRecipeController(DeleteRecipeInputBoundary deleteRecipeInteractor){
        this.deleteRecipeInteractor = deleteRecipeInteractor;
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
    public void execute(String cookbookName, Triplet[] recipes) {
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(cookbookName, convertTripletToRecipes(recipes));

        deleteRecipeInteractor.execute(deleteRecipeInputData);
    }
}
