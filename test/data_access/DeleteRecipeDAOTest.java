package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;

import java.io.*;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeleteRecipeDAOTest {
    private final Ingredient i1 = new Ingredient("1 cup of flour");
    private final Ingredient i2 = new Ingredient("1 bag of chocolate chips");
    private final Ingredient[] ingLst = new Ingredient[]{i1, i2};
    private final Recipe r1 = new Recipe("Waffles", "url", ingLst);
    private final Recipe r2 = new Recipe("Pasta", "url", ingLst);
    private final Recipe r3 = new Recipe("Pizza", "url", ingLst);
    private final Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r1});
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
    public void deleteOneRecipeTest() throws Exception {
        setUp();
        addCookbookDAO.addCookbook(c1);
        deleteRecipeDAO.deleteRecipe(c1.getName(), new Recipe[]{r1});
        Recipe[] output = viewRecipeDAO.viewRecipes(c1.getName());
        assertArrayEquals(new Recipe[]{}, output);
    }
    @Test
    public void deleteMultipleRemainTest() throws Exception {
        setUp();
        Recipe[] rLst = new Recipe[]{r1, r2, r3};
        Cookbook test1 = new Cookbook("breakfast", rLst);
        addCookbookDAO.addCookbookLst(new Cookbook[]{test1});
        deleteRecipeDAO.deleteRecipe(test1.getName(), new Recipe[]{r1, r2});
        Recipe[] recipeList1 = viewRecipeDAO.viewRecipes(test1.getName());
        assertArrayEquals(new Recipe[]{r3}, recipeList1);
    }
    @Test
    public void deleteEmptyTest() throws Exception {
        setUp();
        addCookbookDAO.addCookbook(c1);
        Recipe[] before = viewRecipeDAO.viewRecipes(c1.getName());
        deleteRecipeDAO.deleteRecipe(c1.getName(), new Recipe[]{});
        Recipe[] after = viewRecipeDAO.viewRecipes(c1.getName());
        assertArrayEquals(before, after);
    }
    @Test
    public void addExistingCookbookLstTest() throws IOException {
        setUp();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    deleteRecipeDAO.deleteRecipe("Breakfast", new Recipe[]{});
                }
        );
        assertEquals("Cookbook doesn't exist", exception.getMessage());
    }
}