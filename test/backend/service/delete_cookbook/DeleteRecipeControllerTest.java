package backend.service.delete_cookbook;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.delete_recipe.DeleteRecipeController;
import backend.service.delete_recipe.DeleteRecipeInputBoundary;
import backend.service.delete_recipe.DeleteRecipeInputData;
import data_access.AddCookbookDAO;
import org.junit.jupiter.api.Test;

class DeleteRecipeControllerTest {
    Ingredient ingredient = new Ingredient("bruh");

    Ingredient[] ingredients = {ingredient};
    Recipe recipe = new Recipe("test", "www.food.com", ingredients);

    Recipe[] testrecipe = {recipe};
    Cookbook testbook = new Cookbook("testbook", testrecipe);

    AddCookbookDAO testDAO = new AddCookbookDAO("testfile");

    DeleteRecipeInputBoundary testboundary = new DeleteRecipeInputBoundary() {
        @Override
        public void execute(DeleteRecipeInputData deleteRecipeInputData) {
        }
    };
    DeleteRecipeController testDelete = new DeleteRecipeController(testboundary);

    @Test
    void execute() throws Exception {
        testDAO.addCookbook(testbook);
        //testDelete.execute(testbook.getName(), "testRecipe");
    }

    private void assertEquals(boolean b) {
    }
}