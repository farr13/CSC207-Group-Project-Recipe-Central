package data_access;
/*
import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddRecipeDAOTest {
    public AddRecipeDAO createDAO(String fileName){
        return new AddRecipeDAO(fileName);
    }

    @Test
    public void createFileTest(){
        createDAO("createFileTest.json");
    }

    @Test
    public void addOneRecipe1() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("addOneRecipe1.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        Recipe r2 = new Recipe("cookies", "aaedszgxd",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        Cookbook c1 = new Cookbook("breakfast", new Recipe[]{r1}),
                c2 = new Cookbook("lunch", new Recipe[]{r1, r2});

        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("addOneRecipe1.json");
        addRecipeDAO.addRecipe(c1, r2);
    }
    @Test
    public void addOneRecipeRepeat() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("addOneRecipeRepeat.json");
        Recipe cookies = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{cookies});
        addCookbookDAO.addCookbook(cookbook);

        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("addOneRecipeRepeat.json");

        Recipe cookies2 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});

        addRecipeDAO.addRecipe(cookbook, cookies2);
    }
    @Test
    public void addRecipeEmptyCookbook() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("addRecipeEmptyCookbook.json");

        Recipe r1 = new Recipe("cookiessss", "adwadaed.ca",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});

        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{r1});
        addCookbookDAO.addCookbook(cookbook);

        Recipe cookies = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("addRecipeEmptyCookbook.json");

        addRecipeDAO.addRecipe(cookbook, cookies);
    }

    @Test
    public void addMultiRecipeEmptyCookbook() throws Exception {
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookiesss", "adwadaed.com",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("3 bag of chocolate chips")});

        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{r1,r2});

        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("addMultiRecipeEmptyCookbook.json");
        addRecipeDAO.addRecipe(cookbook, r1);
    }
}

 */