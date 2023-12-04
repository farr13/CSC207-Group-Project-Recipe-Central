package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ViewRecipeDAOTest {
    private final Ingredient i1 = new Ingredient("1 cup of flour");
    private final Ingredient i2 = new Ingredient("1 bag of chocolate chips");
    private final Ingredient[] ingLst = new Ingredient[]{i1, i2};
    private final Recipe r1 = new Recipe("Waffles", "url", ingLst);
    private final Recipe r2 = new Recipe("Pasta", "url", ingLst);
    private final Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r1});
    private final Cookbook c2 = new Cookbook("Lunch", new Recipe[]{r2});
    private AddCookbookDAO addCookbookDAO;
    private ViewRecipeDAO viewRecipeDAO;
    private DeleteRecipeDAO deleteRecipeDAO;

    private void setUp() {
        String filename = "thisDAOTest.json";
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(filename));
            fw.write("[]");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        addCookbookDAO = new AddCookbookDAO(filename);
        viewRecipeDAO = new ViewRecipeDAO(filename);
        deleteRecipeDAO = new DeleteRecipeDAO(filename);
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
        //addCookbookDAO.addCookbook(new Cookbook[]{c1, c2});

        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("deleteOneRecipeEmptiedCookbook.json");
        //deleteRecipeDAO.deleteRecipeObject(c1,r2);
        //deleteRecipeDAO.deleteRecipe(new Cookbook("breakfast", new Recipe[]{r1}),r1);
        //deleteRecipeDAO.deleteRecipeObject(c2,r2);
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
        //addCookbookDAO.addCookbook(new Cookbook[]{c1, c2});

        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("deleteMultiRecipeEmptiedCookbook.json");
        //deleteRecipeDAO.deleteRecipeObject(c1, new Recipe("", "", new Ingredient[]{}));
        //deleteRecipeDAO.deleteRecipeList(c2, new Recipe[]{});
    }
}