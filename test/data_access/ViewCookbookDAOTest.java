package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ViewCookbookDAOTest {
    private final Ingredient i1 = new Ingredient("1 cup of flour");
    private final Ingredient i2 = new Ingredient("1 bag of chocolate chips");
    private final Ingredient[] ingLst = new Ingredient[]{i1, i2};
    private final Recipe r1 = new Recipe("Waffles", "url", ingLst);
    private final Recipe r2 = new Recipe("Pasta", "url", ingLst);
    private final Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r1});
    private final Cookbook c2 = new Cookbook("Lunch", new Recipe[]{r2});
    private AddCookbookDAO addCookbookDAO;
    private ViewCookbookDAO viewCookbookDAO;

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
        viewCookbookDAO= new ViewCookbookDAO(filename);
    }
    @Test(expected = NoSuchElementException.class)
    public void viewCookbookEmptyStringTest() {
        setUp();
        Cookbook test = viewCookbookDAO.viewCookbook("");
    }
    @Test
    public void viewCookbookTrueTest() throws Exception {
        setUp();
        Cookbook[] input = new Cookbook[]{c1, c2};
        addCookbookDAO.addCookbookLst(input);
        Cookbook output1 = viewCookbookDAO.viewCookbook(c1.getName());
        Cookbook output2 = viewCookbookDAO.viewCookbook(c2.getName());
        Cookbook[] output = new Cookbook[]{output1, output2};
        assertTrue(input[0].equals(output[0]) && input[1].equals(output[1]));
    }
    @Test
    public void viewCookbooksEmptyTest() {
        setUp();
        Cookbook[] empty = new Cookbook[]{};
        Cookbook[] output = viewCookbookDAO.viewCookbooks();
        assertArrayEquals(empty, output);
    }
    @Test
    public void viewCookbooksTest() throws Exception {
        setUp();
        Cookbook[] input = new Cookbook[]{c1, c2, new Cookbook("a", new Recipe[]{r1, r2})};
        addCookbookDAO.addCookbookLst(input);
        Cookbook[] output = viewCookbookDAO.viewCookbooks();
        assertTrue(input[0].equals(output[0]) && input[1].equals(output[1]) && input[2].equals(output[2]));
    }
}