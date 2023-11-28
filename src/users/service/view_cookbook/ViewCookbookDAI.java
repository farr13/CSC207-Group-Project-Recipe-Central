package users.service.view_cookbook;

import users.entity.Cookbook;

public interface ViewCookbookDAI {
    /**
     * Retrieves a cookbook by its name from the JSON file.
     *
     * @param name The name of the cookbook.
     * @return The cookbook with the specified name, or null if not found.
     */
    Cookbook getCookbookByName(String name);

    /**
     * Retrieves all cookbooks stored in the JSON file.
     *
     * @return An array or a list of all cookbooks.
     */
    Cookbook[] getAllCookbooks();

}
