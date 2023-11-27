package users.service.search_recipes.interface_adapters;

import org.junit.Test;
import users.service.search_recipes.EdamamAPI.EdamamCaller;
import users.service.search_recipes.EdamamAPI.EdamamURLGenerator;
import users.service.search_recipes.EdamamAPI.JsonRecipeGenerator;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

import static org.junit.jupiter.api.Assertions.*;

public class SearchControllerTest {

    public void searchFactory(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();
    }


}