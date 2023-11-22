package users.service.make_cookbook;

import users.entity.Cookbook;

public interface MakeCookbookDataAccessInterface {
    /*Check if the cookbook title already exist*/
    boolean existByTitle(String identifier);
    /*saves the cookbook*/
    void save(Cookbook cookbook);
    /*gets the cookbook based on title*/
    Cookbook get(String title);

}
