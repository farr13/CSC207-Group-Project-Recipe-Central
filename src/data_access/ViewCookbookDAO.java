package data_access;

import backend.service.make_cookbook.MakeCookbookViewDAI;
import backend.service.view_cookbook.ViewCookbookDAI;
import backend.entity.Cookbook;
import backend.service.see_list_cookbooks.SeeListCookbooksDAI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ViewCookbookDAO implements SeeListCookbooksDAI, ViewCookbookDAI, MakeCookbookViewDAI {
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public ViewCookbookDAO(String fileName){
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
            StringBuilder result = new StringBuilder();
            String nextLine = reader.readLine();
            while (nextLine != null) {
                result.append(nextLine);
                nextLine = reader.readLine();
            }
            return result.toString();
        } catch (IOException e) {
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
        if (Objects.equals(jsonStr, "[]"))
            return new ArrayList<Cookbook>(){};
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    @Override
    public Cookbook viewCookbook(String cookbookName) {
        cookbooks = convertCookbook(readFile());
        if (existByTitle(cookbookName)){
            for (Cookbook cookbook: cookbooks){
                if (Objects.equals(cookbook.getName(), cookbookName))
                    return cookbook;
            }
        }
        throw new NoSuchElementException();
    }
    @Override
    public Cookbook[] viewCookbooks(){
        cookbooks = convertCookbook(readFile());
        return cookbooks.toArray(new Cookbook[0]);
    }
}
