package data_access;

import backend.entity.Cookbook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCookbookDAO {
    private String jsonPath;
    private String json;
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public AddCookbookDAO(String fileName){
        jsonPath = fileName;

        file = new File(fileName);
        createFile();

        String cookbookStr;

        cookbookStr = readFile();

        this.cookbooks = convertCookbook(cookbookStr);
    }

    private String readFile(){
        return getString(file);
    }

    static String getString(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String result = reader.readLine();
            while (result != null) {
                result = result + reader.readLine();
            }
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFile(){
        try {
            BufferedWriter cookbookWriter = new BufferedWriter(new FileWriter(file));
            String jsonPrint = new Gson().toJson(cookbooks);
            cookbookWriter.write(jsonPrint);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean existByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (cookbook.getName() == identifier.trim())
                return false;
        }
        return true;
    }
    private void createFile(){
        try {
            file.createNewFile();
        } catch (IOException ignored) { }
    }
    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    public void addCookbook(Cookbook cookbook) throws Exception {
        if (existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook Name already exist");
        } else {
            cookbooks.add(cookbook);
            writeFile();
        }
    }
    public void addCookbook(Cookbook[] cookbooks) throws Exception {
        for (Cookbook cookbook: cookbooks){
            if (existByTitle(cookbook.getName())) {
                throw new Exception("Cookbook Name already exist");
            } else {
                this.cookbooks.add(cookbook);
            }
        }
        writeFile();
    }
}
