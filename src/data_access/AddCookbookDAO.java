package data_access;

import app.NotImplementedException;
import backend.entity.Cookbook;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddCookbookDAO { //implements AddCookbookInterface {}
        String jsonPath = "cookbooks.json";
        String json;
        public void AddCookbook(Cookbook cookbook) throws Exception {
            json = new Gson().toJson(cookbook);
            if (existByTitle(cookbook.getName())) {
                throw new Exception("Cookbook Name already exist");
            }
            else {
                try (FileWriter writer = new FileWriter(jsonPath)) {
                    writer.write(json);
                    System.out.println("cookbook saved to cookbooks.json");
                } catch (IOException e) {
                    e.fillInStackTrace();
                }
            }
    }

    private boolean existByTitle(String identifier) {
            Cookbook[] cookbooks = new Gson().fromJson(json, Cookbook[].class);
            for (Cookbook cookbook : cookbooks) {
                String name = cookbook.getName();
                if (name.equals(identifier))
                    return true;
        }
        return false;
    }

}
