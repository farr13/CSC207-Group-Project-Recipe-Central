package users.service.rename_cookbook;

import users.service.rename_cookbook.RenameCookbookOutputBoundary;
import users.service.rename_cookbook.RenameCookbookOutputData;

public class RenameCookbookPresenter implements RenameCookbookOutputBoundary {

    @Override
    public void present(RenameCookbookOutputData outputData) {
        if (outputData.isSuccess()) {
            System.out.println("Cookbook renamed successfully.");
        } else {
            System.out.println("Error: " + outputData.getMessage());
        }
    }
}
