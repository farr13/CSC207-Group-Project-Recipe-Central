package backend.service.see_list_cookbooks;

import backend.entity.Cookbook;

public interface SeeListCookbooksDAI {
    Cookbook[] viewCookbooks() throws Exception;
}
