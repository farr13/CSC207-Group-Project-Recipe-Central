package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteCookbookDAOTest {
    public DeleteCookbookDAO createDAO(String fileName){
        return new DeleteCookbookDAO(fileName);
    }
    @Test
    public void createFileTest(){
        createDAO("createFileTest2.json");
    }
    @Test
    public void deleteOneCookbookTestEmptied() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteOneCookbookTestEmptied.json");
        Recipe cookies = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        //addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{cookies}));

        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{cookies});
        DeleteCookbookDAO deleteCookbookDAO = createDAO("deleteOneCookbookTestEmptied.json");
        //deleteCookbookDAO.deleteCookbook(cookbook);
    }
    @Test
    public void deleteOneCookbookTestRemain() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteOneCookbookTestRemain.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed",
                        new Ingredient[]{new Ingredient("1 cup of flour3"),
                                new Ingredient("1 bag of chocolate chips")});

        //addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{r1,r2}));

        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{r2});
        DeleteCookbookDAO deleteCookbookDAO = createDAO("deleteOneCookbookTestRemain.json");
        //deleteCookbookDAO.deleteCookbook(cookbook);
        Cookbook cookbook2 = new Cookbook("Breakfast", new Recipe[]{r1, r2});
        //deleteCookbookDAO.deleteCookbook(cookbook2);
    }
    @Test
    public void deleteMultiCookbookTestEmptied() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteMultiCookbookTestEmptied.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed",
                        new Ingredient[]{new Ingredient("1 cup of flour3"),
                                new Ingredient("1 bag of chocolate chips")});

        //addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{r1}));
        //addCookbookDAO.addCookbook(new Cookbook("Lunch", new Recipe[]{r2}));

        DeleteCookbookDAO deleteCookbookDAO = createDAO("deleteMultiCookbookTestEmptied.json");

        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{r1});
        Cookbook cookbook2 = new Cookbook("Lunch", new Recipe[]{r2});
        //deleteCookbookDAO.deleteCookbookLst(new Cookbook[]{cookbook, cookbook2});
    }
    @Test
    public void deleteMultiCookbookTestRemain() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteMultiCookbookTestRemain.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed",
                        new Ingredient[]{new Ingredient("1 cup of flour3"),
                                new Ingredient("1 bag of chocolate chips")});

        addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{r1}));
        addCookbookDAO.addCookbook(new Cookbook("Lunch", new Recipe[]{r2}));

        DeleteCookbookDAO deleteCookbookDAO = createDAO("deleteMultiCookbookTestRemain.json");

        Cookbook cookbook = new Cookbook("Breakfast", new Recipe[]{r1});
        //deleteCookbookDAO.deleteCookbookLst(new Cookbook[]{cookbook});
    }
    @Test
    public void deleteNoCookbookTestRemain() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteNoCookbookTestRemain.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed",
                        new Ingredient[]{new Ingredient("1 cup of flour3"),
                                new Ingredient("1 bag of chocolate chips")});

        //addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{r1}));
        //addCookbookDAO.addCookbook(new Cookbook("Lunch", new Recipe[]{r2}));

        DeleteCookbookDAO deleteCookbookDAO = createDAO("deleteNoCookbookTestRemain.json");

        Cookbook cookbook = new Cookbook("", new Recipe[]{});
        //deleteCookbookDAO.deleteCookbookLst(new Cookbook[]{cookbook});
    }
    @Test
    public void deleteNoCookbookTestEmptied() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("deleteNoCookbookTestEmptied.json");

        DeleteCookbookDAO deleteCookbookDAO = createDAO("deleteNoCookbookTestEmptied.json");

        Cookbook cookbook = new Cookbook("", new Recipe[]{});
        //deleteCookbookDAO.deleteCookbookLst(new Cookbook[]{cookbook});
    }
}