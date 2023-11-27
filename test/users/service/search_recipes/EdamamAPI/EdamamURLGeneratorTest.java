package users.service.search_recipes.EdamamAPI;

import org.junit.Test;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;

import static org.junit.jupiter.api.Assertions.*;

public class EdamamURLGeneratorTest {
    @Test
    public void EdamamURLGeneratorTest1(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();

        SearchInputData searchInputData = new SearchInputData(new String[] {"steak", "sandwich"}, new String[] {"Lunch"},
                new String[] {"low-sodium"}, new String[] {});
        String result = edamamURLGenerator.convertToURL(searchInputData);
        assertEquals("https://api.edamam.com/api/recipes/v2?type=public&q=steak%2C%20sandwich&app_id=ebc53afb&app_key=16c8dd744237d5c5cc0ca9b3b5a5f6eb&diet=low-sodium&mealType=Lunch&imageSize=THUMBNAIL&random=true", result);
    }

    @Test
    public void EdamamURLGeneratorTest2(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();

        SearchInputData searchInputData = new SearchInputData(new String[] {"steak", "sandwich"}, new String[] {"Dinner", "Lunch"},
                new String[] {"low-fat","low-sodium"}, new String[] {"egg-free", "fish-free"});
        String result = edamamURLGenerator.convertToURL(searchInputData);
        assertEquals("https://api.edamam.com/api/recipes/v2?type=public&q=steak%2C%20sandwich&app_id=ebc53afb&app_key=16c8dd744237d5c5cc0ca9b3b5a5f6eb&diet=low-fat&diet=low-sodium&health=egg-free&health=fish-free&mealType=Dinner&mealType=Lunch&imageSize=THUMBNAIL&random=true", result);
    }

    @Test
    public void EdamamURLGeneratorTest3(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();

        SearchInputData searchInputData = new SearchInputData(new String[] {"steak"}, new String[] {},
                new String[] {}, new String[] {});
        String result = edamamURLGenerator.convertToURL(searchInputData);
        assertEquals("https://api.edamam.com/api/recipes/v2?type=public&q=steak&app_id=ebc53afb&app_key=16c8dd744237d5c5cc0ca9b3b5a5f6eb&imageSize=THUMBNAIL&random=true", result);
    }

    @Test
    public void EdamamURLGeneratorTest4(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();

        SearchInputData searchInputData = new SearchInputData(new String[] {}, new String[] {}, new String[] {}, new String[] {"alcohol-free"});
        String result = edamamURLGenerator.convertToURL(searchInputData);
        assertEquals("https://api.edamam.com/api/recipes/v2?type=public&app_id=ebc53afb&app_key=16c8dd744237d5c5cc0ca9b3b5a5f6eb&health=alcohol-free&imageSize=THUMBNAIL&random=true", result);
    }
}