package dao;

import users.entity.Cookbook;

import java.io.IOException;
import java.util.List;

public interface CookbookDAO {
    void saveCookbooks(List<Cookbook> cookbooks) throws IOException;
    List<Cookbook> loadCookbooks() throws IOException, ClassNotFoundException;
}
