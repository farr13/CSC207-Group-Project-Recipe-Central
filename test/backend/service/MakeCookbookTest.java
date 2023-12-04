package backend.service;

import backend.service.add_recipe.AddRecipeController;
import backend.service.add_recipe.AddRecipeInteractor;
import backend.service.add_recipe.AddRecipePresenter;
import backend.service.make_cookbook.MakeCookbookController;
import backend.service.make_cookbook.MakeCookbookInteractor;
import backend.service.make_cookbook.MakeCookbookPresenter;
import backend.service.make_cookbook.MakeCookbookViewDAI;
import data_access.*;
import org.junit.Test;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

public class MakeCookbookTest {
    private static MakeCookbookController setUp() {
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

        MakeCookbookPresenter makeCookbookPresenter = new MakeCookbookPresenter(viewManagerModel, cookbookListViewModel, addCookbookViewModel);
        MakeCookbookInteractor makeCookbookInteractor = new MakeCookbookInteractor(addCookbookDAO, viewCookbookDAO, makeCookbookPresenter);
        return new MakeCookbookController(makeCookbookInteractor);
    }

    @Test
    public void BasicTest(){
        MakeCookbookController makeCookbookController = setUp();
        makeCookbookController.execute("");
        makeCookbookController.execute("newCookbook");
    }
}
