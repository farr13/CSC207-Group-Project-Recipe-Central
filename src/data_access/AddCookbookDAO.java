package data_access;

import backend.entity.Cookbook;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    private Cookbook[] readFile(){
        try (FileReader reader = new FileReader(jsonPath)) {
            return new Gson().fromJson(reader, Cookbook[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean existByTitle(String identifier) {
        Cookbook[] cookbooks = readFile();
        assert cookbooks != null;
        for (Cookbook cookbook : cookbooks) {
            String name = cookbook.getName();
            if (name.equals(identifier))
                return true;
        }
            return false;
    }

    private Cookbook get(String findName) {
        Cookbook[] cookbooks = readFile();
        assert cookbooks != null;
        for (Cookbook cookbook : cookbooks) {
            String name = cookbook.getName();
            if (name.equals(findName))
                return cookbook;
        }
        return null;
    }

}
