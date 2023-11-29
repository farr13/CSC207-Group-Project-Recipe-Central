package users.service.delete_recipe_from_cookbook;

import users.repository.CookbookRepository;
import users.entity.Cookbook;
import users.entity.Recipe;
import java.util.Iterator;

public class DeleteRecipeInteractor implements DeleteRecipeInputBoundary {
    private final CookbookRepository cookbookRepository;

    public DeleteRecipeInteractor(CookbookRepository cookbookRepository) {
        this.cookbookRepository = cookbookRepository;
    }

    @Override
    public void execute(DeleteRecipeInputData deleteRecipeInputData) throws Exception {
        String cookbookName = deleteRecipeInputData.getCookbookName();
        String recipeName = deleteRecipeInputData.getRecipeName();

        Cookbook cookbook = cookbookRepository.findCookbookByName(cookbookName);
        if (cookbook == null) {
            throw new Exception("Cookbook not found");
        }

        Iterator<Recipe> iterator = cookbook.getRecipes().iterator();
        while (iterator.hasNext()) {
            Recipe recipe = iterator.next();
            if (recipe.getName().equals(recipeName)) {
                iterator.remove();
                cookbookRepository.saveCookbook(cookbook);
                return;
            }
        }
        throw new Exception("Recipe not found");
    }
}
