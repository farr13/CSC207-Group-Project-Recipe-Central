package users.repository;

import users.entity.Cookbook;

import java.io.IOException;
import java.util.List;

public interface CookbookRepository {
    Cookbook findCookbookByName(String name) throws IOException;
    void saveCookbook(Cookbook cookbook) throws IOException;

}
