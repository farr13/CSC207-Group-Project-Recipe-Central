package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteRecipeDAOTest {
    public DeleteRecipeDAO createDAO(String fileName){
        return new DeleteRecipeDAO(fileName);
    }

    @Test
    public void createFileTest(){
        createDAO("createFileTest.json");
    }

    @Test
    public void deleteOneRecipeEmptiedCookbook() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteOneRecipeEmptiedCookbook.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed.com",
                        new Ingredient[]{new Ingredient("1 cup of flour"),
                                new Ingredient("1 bag of chocolate chips")});
        Cookbook c1 = new Cookbook("breakfast", new Recipe[]{r2, r1}),
                c2 = new Cookbook("lunch", new Recipe[]{r2, r1});
        addCookbookDAO.addCookbook(new Cookbook[]{c1, c2});

        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("deleteOneRecipeEmptiedCookbook.json");
        deleteRecipeDAO.deleteRecipeObject(c1,r2);
        //deleteRecipeDAO.deleteRecipe(new Cookbook("breakfast", new Recipe[]{r1}),r1);
        deleteRecipeDAO.deleteRecipeObject(c2,r2);
        //deleteRecipeDAO.deleteRecipe(new Cookbook("lunch", new Recipe[]{r1}),r1);
    }
    @Test
    public void deleteMultiRecipeEmptiedCookbook() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteMultiRecipeEmptiedCookbook.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed.com",
                        new Ingredient[]{new Ingredient("1 cup of flour"),
                                new Ingredient("1 bag of chocolate chips")});
        Cookbook c1 = new Cookbook("breakfast", new Recipe[]{r2, r1}),
                c2 = new Cookbook("lunch", new Recipe[]{r2, r1});
        addCookbookDAO.addCookbook(new Cookbook[]{c1, c2});

        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("deleteMultiRecipeEmptiedCookbook.json");
        deleteRecipeDAO.deleteRecipeObject(c1, new Recipe("", "", new Ingredient[]{}));
        deleteRecipeDAO.deleteRecipeList(c2, new Recipe[]{});
    }
}