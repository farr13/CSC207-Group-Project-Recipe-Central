package users.service.search_recipes.application_business_rules;

import org.junit.Test;
import users.service.search_recipes.EdamamAPI.EdamamCaller;
import users.service.search_recipes.EdamamAPI.EdamamURLGenerator;
import users.service.search_recipes.EdamamAPI.JsonRecipeGenerator;
import users.service.search_recipes.application_business_rules.DataTypes.SearchInputData;
import users.service.search_recipes.application_business_rules.DataTypes.SearchOutputData;
import users.service.search_recipes.interface_adapters.SearchPresenter;

import static org.junit.jupiter.api.Assertions.*;

public class SearchInteractorTest {
    @Test
    public void SearchInteractorTest1(){
        EdamamCaller edamamCaller = new EdamamCaller();
        EdamamURLGenerator edamamURLGenerator = new EdamamURLGenerator("ebc53afb", "16c8dd744237d5c5cc0ca9b3b5a5f6eb");
        JsonRecipeGenerator jsonRecipeGenerator = new JsonRecipeGenerator();
        SearchPresenter searchPresenter = new SearchPresenter();

        SearchInputData searchInputData = new SearchInputData(new String[] {}, new String[] {}, new String[] {}, new String[] {"alcohol-free"});

        SearchInteractor searchInteractor = new SearchInteractor(edamamCaller, edamamURLGenerator, jsonRecipeGenerator, searchPresenter);
        searchInteractor.execute(searchInputData);
    }
}