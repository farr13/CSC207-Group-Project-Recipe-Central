package dao;

import users.entity.Cookbook;
import dao.FileCookbookDAO;

import java.util.List;

public class Application {
    private static final String COOKBOOK_FILE = "cookbooks.dat";
    private List<Cookbook> cookbooks;
    private final FileCookbookDAO cookbookDAO = new FileCookbookDAO(COOKBOOK_FILE);

    public void start() {
        try {
            cookbooks = cookbookDAO.loadCookbooks();
            // Application logic
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            cookbookDAO.saveCookbooks(cookbooks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Other application methods...
}
