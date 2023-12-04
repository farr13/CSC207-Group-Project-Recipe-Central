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

    private Triplet[] convertToTriplet(String[] recipeBlocks){
        ArrayList<Triplet> triplets = new ArrayList<Triplet>();
        for (String recipeBlock: recipeBlocks){
            String[] sectioned = recipeBlock.split("_");
            String name = sectioned[1];
            String link = sectioned[3];
            String[] listTemp = sectioned[5].split(",");
            ArrayList<String> listFinal = new ArrayList<String>();
            for(String ingredient: listTemp)
                listFinal.add(ingredient.trim());
            triplets.add(new Triplet(name, link, listFinal.toArray(new String[0])));
        }

        return triplets.toArray(new Triplet[0]);
    }
    public void execute(String cookbookName, String[] recipeBlocks) {
        DeleteRecipeInputData deleteRecipeInputData = new DeleteRecipeInputData(cookbookName, convertToTriplet(recipeBlocks));

        deleteRecipeInteractor.execute(deleteRecipeInputData);
    }
}
