package backend.service.make_cookbook;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import backend.service.make_cookbook.MakeCookbookController;
import backend.service.make_cookbook.MakeCookbookInputBoundary;
import backend.service.make_cookbook.MakeCookbookInputData;
import org.junit.jupiter.api.Test;
import data_access.*;
import static org.junit.jupiter.api.Assertions.*;

class MakeCookbookControllerTest {
    Ingredient ingredient = new Ingredient("bruh");
    Ingredient[] ingredients = {ingredient};
    Recipe recipe = new Recipe("test", "www.food.com", ingredients);
    Recipe[] testrecipe = {recipe};
    Cookbook testbook = new Cookbook("testbook", testrecipe);
    AddCookbookDAO testDAO = new AddCookbookDAO("testfile");

    MakeCookbookInputBoundary testboundary = new MakeCookbookInputBoundary() {
        @Override
        public void execute(MakeCookbookInputData makeCookbookInputData) {

        }
    };
    MakeCookbookController testcontrol = new MakeCookbookController(testboundary);
    @Test
    void execute() throws Exception {
        testcontrol.execute("test");
    }
    
}