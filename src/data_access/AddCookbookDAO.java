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
    private File cookbookFile;

    public AddCookbookDAO(String fileName){
        jsonPath = fileName;

        this.cookbookFile = new File(fileName);

        String cookbookStr;

        if (this.cookbookFile.exists()) {
            cookbookStr = readFile();
        }else{
            cookbookFile = null;
            cookbookStr = "[]";
        }

        this.cookbooks = convertCookbook(cookbookStr);
    }

    private String readFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(cookbookFile))) {
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
            BufferedWriter cookbookWriter = new BufferedWriter(new FileWriter(cookbookFile));
            String jsonPrint = new Gson().toJson(cookbooks);
            cookbookWriter.write(jsonPrint);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    public void addCookbook(Cookbook cookbook) throws Exception {
        if (existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook Name already exist");
        }
        else {
            this.cookbooks.add(cookbook);
            writeFile();
        }
    }

    private boolean existByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (cookbook.getName() == identifier.trim())
                return false;
        }
        return true;
    }

}
