package data_access;

import backend.entity.Cookbook;
import backend.service.make_cookbook.MakeCookbookAddDAI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class AddCookbookDAO implements MakeCookbookAddDAI {
    private ArrayList<Cookbook> cookbooks;
    private final File file;

    public AddCookbookDAO(String fileName){
        file = new File(fileName);
        if (!file.exists())
            createFile();
        cookbooks = convertCookbook(readFile());
    }
    private void createFile(){
        try {
            BufferedWriter cookbookWriter = new BufferedWriter(new FileWriter(file.getName()));
            cookbookWriter.write("[]");
            cookbookWriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String readFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getName()))) {
            String result = "";
            String nextLine = reader.readLine();
            while (nextLine != null) {
                result = result + nextLine;
                nextLine = reader.readLine();
            }

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeFile(){
        try {
            PrintWriter cookbookWriter = new PrintWriter(file);
            cookbookWriter.print("");
            cookbookWriter.print(new Gson().toJson(cookbooks));
            cookbookWriter.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean existByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), identifier))
                return true;
        }
        return false;
    }
    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    @Override
    public void addCookbook(Cookbook cookbook) throws Exception {
        this.cookbooks = convertCookbook(readFile());
        if (existByTitle(cookbook.getName())) {
            throw new RuntimeException("Cookbook name already exists.");
        } else{
            cookbooks.add(cookbook);
            writeFile();
        }
    }
    public void addCookbookLst(Cookbook[] cookbooks) {
        for (Cookbook cookbook: cookbooks){
            if (existByTitle(cookbook.getName())) {
                throw new RuntimeException("Cookbook name already exists.");
            } else {
                this.cookbooks.add(cookbook);
            }
        }
        writeFile();
    }
}
