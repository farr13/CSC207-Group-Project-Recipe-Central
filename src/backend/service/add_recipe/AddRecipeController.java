package backend.service.add_recipe;
import backend.entity.Recipe;
import backend.entity.Ingredient;
import view.recipe_objects.Triplet;

import java.util.ArrayList;

public class AddRecipeController {
    private final AddRecipeInputBoundary addRecipeUseCaseInteractor;
    public AddRecipeController(AddRecipeInputBoundary addRecipeUseCaseInteractor) {
        this.addRecipeUseCaseInteractor = addRecipeUseCaseInteractor;
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

    public void execute(String[] cookbookName, String[] recipes) {
        AddRecipeInputData addRecipeInputData = new AddRecipeInputData(cookbookName, convertToTriplet(recipes));
        addRecipeUseCaseInteractor.execute(addRecipeInputData);
    }
}
