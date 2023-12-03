package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViewCookbookDAOTest {
    public ViewCookbookDAO createDAO(String fileName){
        return new ViewCookbookDAO(fileName);
    }

    @Test
    public void createFileTest(){
        createDAO("createFileTest.json");
    }

    @Test
    public void viewCookbookBasic() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("viewCookbookBasic.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed.com",
                        new Ingredient[]{new Ingredient("1 cup of flour"),
                                new Ingredient("1 bag of chocolate chips")});
        Cookbook c1 = new Cookbook("breakfast", new Recipe[]{r2, r1}),
                c2 = new Cookbook("lunch", new Recipe[]{r2, r1});
        //addCookbookDAO.addCookbook(new Cookbook[]{c1});
        ViewCookbookDAO viewCookbookDAO = createDAO("viewCookbookBasic.json");
        System.out.println(viewCookbookDAO.viewCookbooks());
        //System.out.println(viewCookbookDAO.viewCookbook(c2));
    }

    @Test
    public void viewEmptyCookbookBasic() throws Exception {
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("viewEmptyCookbookBasic.json");
        Cookbook c1 = new Cookbook("", new Recipe[]{});
        ViewCookbookDAO viewCookbookDAO = createDAO("viewEmptyCookbookBasic.json");
        System.out.println(viewCookbookDAO.viewCookbooks());
        //System.out.println(viewCookbookDAO.viewCookbook(c1));
    }
}