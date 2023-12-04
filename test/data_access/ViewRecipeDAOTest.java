package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.NoSuchElementException;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ViewRecipeDAOTest {
    private final Ingredient i1 = new Ingredient("1 cup of flour");
    private final Ingredient i2 = new Ingredient("1 bag of chocolate chips");
    private final Ingredient[] ingLst = new Ingredient[]{i1, i2};
    private final Recipe r1 = new Recipe("Waffles", "url", ingLst);
    private final Recipe r2 = new Recipe("Pasta", "url", ingLst);
    private final Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r1});
    private AddCookbookDAO addCookbookDAO;
    private ViewRecipeDAO viewRecipeDAO;

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
    }

    @Test (expected = NoSuchElementException.class)
    public void noCookbookErrorTest() {
        setUp();
        Recipe[] recipeList1 = viewRecipeDAO.viewRecipes(c1.getName());
    }
    @Test
    public void viewOneRecipeTest() throws Exception {
        setUp();
        addCookbookDAO.addCookbook(c1);
        Recipe[] recipeList1 = viewRecipeDAO.viewRecipes(c1.getName());
        assertArrayEquals(new Recipe[]{r1}, recipeList1);
    }
    @Test
    public void viewMultipleRecipeTest() throws Exception {
        setUp();
        Cookbook test1 = new Cookbook("Brunch", new Recipe[]{r1, r2});
        addCookbookDAO.addCookbook(test1);
        Recipe[] recipeList1 = viewRecipeDAO.viewRecipes(test1.getName());
        assertArrayEquals(new Recipe[]{r1, r2}, recipeList1);
    }
}