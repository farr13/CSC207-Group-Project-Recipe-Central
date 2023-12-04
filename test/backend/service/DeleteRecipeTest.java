package backend.service;

import backend.service.delete_cookbook.DeleteCookbookController;
import backend.service.delete_cookbook.DeleteCookbookInteractor;
import backend.service.delete_cookbook.DeleteCookbookPresenter;
import backend.service.delete_recipe.DeleteRecipeController;
import backend.service.delete_recipe.DeleteRecipeInteractor;
import backend.service.delete_recipe.DeleteRecipePresenter;
import data_access.*;
import org.junit.Test;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

public class DeleteRecipeTest {
    private static DeleteRecipeController setUp() {
        JFrame frame = new JFrame("Recipe Central");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setLayout(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel();
        OpenCookbookViewModel openCookbookViewModel = new OpenCookbookViewModel();
        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
        AddRecipeViewModel addRecipeViewModel = new AddRecipeViewModel();
        AddCookbookViewModel addCookbookViewModel = new AddCookbookViewModel();

        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("test.json");
        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("test.json");
        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("test.json");
        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("test.json");
        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("test.json");
        ViewRecipeDAO viewRecipeDAO = new ViewRecipeDAO("test.json");

        DeleteRecipePresenter deleteCookbookPresenter = new DeleteRecipePresenter(viewManagerModel, openCookbookViewModel);
        DeleteRecipeInteractor deleteRecipeInteractor = new DeleteRecipeInteractor(deleteRecipeDAO, viewRecipeDAO, deleteCookbookPresenter);
        return new DeleteRecipeController(deleteRecipeInteractor);
    }

    @Test
    public void BasicTest(){
        DeleteRecipeController deleteRecipeController = setUp();
        deleteRecipeController.execute("NotExist", new String[]{"ssss_non_nono_sksks__sss"});
        deleteRecipeController.execute("Tester", new String[]{"sss_name_sss_link__sss"});
    }
}
