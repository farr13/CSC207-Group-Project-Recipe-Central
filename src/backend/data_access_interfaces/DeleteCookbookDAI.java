package backend.data_access_interfaces;

import backend.entity.Cookbook;

public interface DeleteCookbookDAI {
    public void deleteCookbook(Cookbook cookbook) throws Exception;
}
