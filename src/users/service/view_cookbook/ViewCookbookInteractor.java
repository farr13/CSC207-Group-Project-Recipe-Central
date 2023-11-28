package users.service.view_cookbook;

import backend.entity.Cookbook;
import data_access.AddCookbookDAO;

public class ViewCookbookInteractor implements ViewCookbookInputBoundary {
    private AddCookbookDAO addCookbookDAO; // Dependency on AddCookbookDAO

    public ViewCookbookInteractor(AddCookbookDAO addCookbookDAO) {
        this.addCookbookDAO = addCookbookDAO;
    }

    @Override
    public void execute(ViewCookbookInputData viewCookbookInputData) {
        String cookbookName = viewCookbookInputData.getCookbookName();
        try {
            Cookbook cookbook = addCookbookDAO.get(cookbookName);
            if (cookbook == null) {
                System.out.println("Cookbook not found: " + cookbookName);
                return;
            }
            displayCookbook(cookbook);
        } catch (Exception e) {
            // Handle exceptions, such as issues with file reading
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayCookbook(Cookbook cookbook) {
        // Logic to display the cookbook's details
        System.out.println(cookbook);
    }
}
