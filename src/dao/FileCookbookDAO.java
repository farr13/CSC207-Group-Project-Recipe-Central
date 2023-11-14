package dao;

import users.entity.Cookbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCookbookDAO implements CookbookDAO {
    private final String filepath;

    public FileCookbookDAO(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void saveCookbooks(List<Cookbook> cookbooks) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(cookbooks);
        }
    }

    @Override
    public List<Cookbook> loadCookbooks() throws IOException, ClassNotFoundException {
        File file = new File(filepath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            return (List<Cookbook>) ois.readObject();
        }
    }
}
