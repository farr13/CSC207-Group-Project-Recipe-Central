package data_access;

import backend.entity.Cookbook;
import backend.service.delete_cookbook.DeleteCookbookDAI;
import backend.service.rename_cookbook.DAI.RenameCookbookDeleteDAI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class DeleteCookbookDAO implements DeleteCookbookDAI {
    private ArrayList<Cookbook> cookbooks;
    private File file;

    public DeleteCookbookDAO(String fileName){
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
    private boolean notExistByTitle(String identifier) {
        for (Cookbook cookbook: cookbooks){
            if (Objects.equals(cookbook.getName(), identifier))
                return false;
        }
        return true;
    }
    private ArrayList<Cookbook> convertCookbook(String jsonStr){
        Type cookbookListType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
        return new Gson().fromJson(jsonStr, cookbookListType);
    }
    @Override
    public void deleteCookbooks(String[] cookbookNames) throws Exception {
        cookbooks = convertCookbook(readFile());
        for (String cookbookName: cookbookNames){
            if (notExistByTitle(cookbookName)) {
                throw new Exception("Cookbook Does Not Exist");
            } else {
                for (Cookbook cookbook: cookbooks){
                    if (Objects.equals(cookbook.getName(), cookbookName)){
                        cookbooks.remove(cookbook);
                        writeFile();
                        break;
                    }
                }
            }
        }
    }
}
