package data_access;

import backend.entity.Cookbook;
import backend.entity.Ingredient;
import backend.entity.Recipe;
import com.google.gson.*;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AddCookbookDAOTest {
    public AddCookbookDAO createDAO(String fileName){
        return new AddCookbookDAO(fileName);
    }

    @Test
    public void createFileTest(){
        createDAO("createFileTest.json");
    }
    @Test
    public void addOneCookbookTest() throws Exception {
        AddCookbookDAO addCookbookDAO = createDAO("addOneCookbookTest.json");
        Recipe cookies = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{cookies}));
    }

    @Test
    public void addMultipleCookbooksTest() throws Exception {
        AddCookbookDAO addCookbookDAO = createDAO("saved_data.json");
        Recipe r1 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")}),
                r2 = new Recipe("cookies", "adwadaed",
                new Ingredient[]{new Ingredient("1 cup of flour"),
                        new Ingredient("1 bag of chocolate chips")});
        Cookbook c1 = new Cookbook("Breakfast", new Recipe[]{r2, r1}),
                c2 = new Cookbook("Lunch", new Recipe[]{r2, r1});
        addCookbookDAO.addCookbook(new Cookbook[]{c1, c2});
    }
    @Test
    public void addExistingCookbookTest() {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    AddCookbookDAO addCookbookDAO = createDAO("addExistingCookbookTest.json");
                    Recipe cookies = new Recipe("cookies", "adwadaed",
                            new Ingredient[]{new Ingredient("1 cup of flour"),
                                    new Ingredient("1 bag of chocolate chips")});
                    addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{cookies}));
                    addCookbookDAO.addCookbook(new Cookbook("Breakfast", new Recipe[]{}));
                }
        );

        assertEquals("Cookbook name already exists.", exception.getMessage());
    }

    @Test
    public void addExistingCookbookLstTest() {
        Throwable exception = assertThrows(
                Exception.class, () -> {
                    AddCookbookDAO addCookbookDAO = createDAO("addExistingCookbookLstTest.json");
                    Recipe r1 = new Recipe("cookies", "adwadaed",
                            new Ingredient[]{new Ingredient("1 cup of flour"),
                                    new Ingredient("1 bag of chocolate chips")});
                    Recipe r2 = new Recipe("cookies", "adwadaed",
                            new Ingredient[]{new Ingredient("1 cup of flour"),
                                    new Ingredient("1 bag of chocolate chips")});
                    Cookbook c1 = new Cookbook("breakfast", new Recipe[]{r2, r2}),
                            c2 = new Cookbook("breakfast", new Recipe[]{r2, r2});
                    addCookbookDAO.addCookbook(new Cookbook[]{c1, c2});
                }
        );

        assertEquals("Cookbook name already exists.", exception.getMessage());
    }

    @Test
    public void addNoNameCookbookTest() throws Exception {
        AddCookbookDAO addCookbookDAO = createDAO("addNoNameCookbookTest.json");
        addCookbookDAO.addCookbook(new Cookbook("", new Recipe[]{}));
    }
}