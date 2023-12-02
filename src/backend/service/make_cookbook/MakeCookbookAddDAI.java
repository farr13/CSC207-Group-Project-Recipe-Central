package backend.service.make_cookbook;

import backend.entity.Cookbook;

public interface MakeCookbookAddDAI {
    /*gets the cookbook based on title*/
    public void addCookbook(Cookbook cookbook) throws Exception;
}
