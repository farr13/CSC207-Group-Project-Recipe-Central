package users.repository;

import users.entity.Cookbook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileCookbookRepository implements CookbookRepository {
    private static final String JSON_PATH = "cookbooks.json";
    private final Gson gson = new Gson();

    @Override
    public Cookbook findCookbookByName(String name) throws IOException {
        List<Cookbook> cookbooks = readCookbooks();
        return cookbooks.stream()
                .filter(cookbook -> cookbook.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveCookbook(Cookbook cookbook) throws IOException {
        List<Cookbook> cookbooks = readCookbooks();
        cookbooks = cookbooks.stream()
                .filter(c -> !c.getName().equals(cookbook.getName()))
                .collect(Collectors.toList());
        cookbooks.add(cookbook);
        writeCookbooks(cookbooks);
    }

    private List<Cookbook> readCookbooks() throws IOException {
        try (FileReader reader = new FileReader(JSON_PATH)) {
            Type listType = new TypeToken<ArrayList<Cookbook>>(){}.getType();
            List<Cookbook> cookbooks = gson.fromJson(reader, listType);
            return cookbooks != null ? cookbooks : new ArrayList<>();
        }
    }

    private void writeCookbooks(List<Cookbook> cookbooks) throws IOException {
        try (FileWriter writer = new FileWriter(JSON_PATH)) {
            gson.toJson(cookbooks, writer);
        }
    }
}
