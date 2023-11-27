package users.service.search_recipes.EdamamAPI;

import org.junit.Test;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

import static org.junit.jupiter.api.Assertions.*;

public class EdamamCallerTest {
    @Test
    public void EdamamCallerTest1(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();

        SearchInputData searchInputData = new SearchInputData(new String[] {}, new String[] {}, new String[] {}, new String[] {"alcohol-free"});

        String callerURL = edamamURLGenerator.convertToURL(searchInputData);
        String response = edamamCaller.execute(callerURL);

        assertNotEquals(response, "no results");
        System.out.println(response);
    }
}