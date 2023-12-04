package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteCookbookDAOTest {
    private final Ingredient i1 = new Ingredient("1 cup of flour");
    private final Ingredient i2 = new Ingredient("1 bag of chocolate chips");
    private final Ingredient[] ingLst = new Ingredient[]{i1, i2};
    private final Recipe r1 = new Recipe("Waffles", "url", ingLst);
    private final Recipe r2 = new Recipe("Pasta", "url", ingLst);
    private final Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r1});
    private final Cookbook c2 = new Cookbook("Lunch", new Recipe[]{r2});
    private AddCookbookDAO addCookbookDAO;
    private DeleteCookbookDAO deleteCookbookDAO;
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
        deleteCookbookDAO = new DeleteCookbookDAO(filename);
        viewCookbookDAO= new ViewCookbookDAO(filename);
    }

    @Test
    public void deleteCookbookEmpty() throws Exception {
        setUp();
        Cookbook[] input = new Cookbook[]{c1};
        addCookbookDAO.addCookbookLst(input);
        deleteCookbookDAO.deleteCookbooks(new String[]{});
        Cookbook[] output = viewCookbookDAO.viewCookbooks();
        assertArrayEquals(input, output);
    }

    @Test
    public void deleteCookbookNameTest() throws Exception {
        setUp();
        addCookbookDAO.addCookbookLst(new Cookbook[]{c1, c2});
        deleteCookbookDAO.deleteCookbooks(new String[]{c1.getName(), c2.getName()});
        Cookbook[] output = viewCookbookDAO.viewCookbooks();
        assertArrayEquals(new Cookbook[]{}, output);
    }

    @Test
    public void deleteCookbookRemains() throws Exception {
        setUp();
        addCookbookDAO.addCookbookLst(new Cookbook[]{c1, c2});
        deleteCookbookDAO.deleteCookbooks(new String[]{c1.getName()});
        Cookbook[] output1 = viewCookbookDAO.viewCookbooks();
        boolean checker1 = c2.equals(output1[0]);
        setUp();
        addCookbookDAO.addCookbookLst(new Cookbook[]{c1, c2});
        deleteCookbookDAO.deleteCookbooks(new String[]{c2.getName()});
        Cookbook[] output2 = viewCookbookDAO.viewCookbooks();
        boolean checker2 = c1.equals(output2[0]);
        assertTrue(checker1 && checker2);
    }

    @Test
    public void deleteCookbookErrorTest() {
        setUp();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    deleteCookbookDAO.deleteCookbooks(new String[]{c1.getName()});
                }
        );
        assertEquals("Cookbook Does Not Exist", exception.getMessage());
    }

}