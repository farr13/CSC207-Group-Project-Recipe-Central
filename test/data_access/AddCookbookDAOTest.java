package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

public class AddCookbookDAOTest {
    private final Ingredient i1 = new Ingredient("1 cup of flour");
    private final Ingredient i2 = new Ingredient("1 bag of chocolate chips");
    private final Ingredient[] ingLst = new Ingredient[]{i1, i2};
    private final Recipe r1 = new Recipe("cookies", "url", ingLst);
    private final Recipe r2 = new Recipe("cookies", "url", ingLst);
    private final Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r1});
    private final Cookbook c2 = new Cookbook("Lunch", new Recipe[]{r1, r2});
    private AddCookbookDAO addCookbookDAO;
    private ViewCookbookDAO viewCookbookDAO;

    private void setUp() {
        String filename = "thisDAOTest.json";
        try { BufferedWriter fw = new BufferedWriter(new FileWriter(filename));
            fw.write("[]");
            fw.close(); }
        catch (Exception e) {
            e.printStackTrace();
        }
        addCookbookDAO = new AddCookbookDAO(filename);
        viewCookbookDAO= new ViewCookbookDAO(filename);

    }

    @Test
    public void addOneCookbookTest() throws Exception {
        setUp();
        addCookbookDAO.addCookbook(c1);
        // Assert file has cookbook
    }

    @Test
    public void addMultipleCookbooksTest() throws Exception {
        setUp();
        addCookbookDAO.addCookbookLst(new Cookbook[]{c1, c2});
        // Assert file has cookbooks
    }
    @Test
    public void addExistingCookbookTest() {
        setUp();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    addCookbookDAO.addCookbook(c1);
                    addCookbookDAO.addCookbook(c1);
                }
        );
        assertEquals("Cookbook name already exists.", exception.getMessage());
    }

    @Test
    public void addExistingCookbookLstTest() {
        setUp();
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    addCookbookDAO.addCookbook(c1);
                    addCookbookDAO.addCookbookLst(new Cookbook[]{c1, c2});
                }
        );
        assertEquals("Cookbook name already exists.", exception.getMessage());
    }
}