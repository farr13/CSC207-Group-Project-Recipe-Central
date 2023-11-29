package data_access;

import app.NotImplementedException;
import backend.entity.Cookbook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeleteCookbookDAO {
    private String jsonPath;
    private String json;
    private ArrayList<Cookbook> cookbooks;
    private File cookbookFile;

    public void DeleteCookbookDAO(String fileName){
        jsonPath = fileName;

        cookbookFile = new File(fileName);
        createFile();

        String cookbookStr;

        if (cookbookFile.exists()) {
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
    private boolean existByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (cookbook.getName() == identifier.trim())
                return false;
        }
        return true;
    }
    private void createFile(){
        try {
            cookbookFile.createNewFile();
        } catch (IOException ignored) { }
    }
    public void deleteCookbook(Cookbook cookbook) throws Exception {
        if (!existByTitle(cookbook.getName())) {
            throw new Exception("Cookbook Does Not Exist");
        } else {
            cookbooks.remove(cookbook);
            writeFile();
        }
    }

    public void deleteCookbook(Cookbook[] cookbooks) throws Exception {
        for (Cookbook cookbook: cookbooks){
            if (!existByTitle(cookbook.getName())) {
                throw new Exception("Cookbook Does Not Exist");
            } else {
                this.cookbooks.remove(cookbook);
            }
        }
        writeFile();
    }
}
