package backend.service;

import backend.service.see_list_cookbooks.SeeListCookbooksController;
import backend.service.see_list_cookbooks.SeeListCookbooksInteractor;
import backend.service.see_list_cookbooks.SeeListCookbooksPresenter;
import backend.service.view_cookbook.ViewCookbookController;
import backend.service.view_cookbook.ViewCookbookInteractor;
import backend.service.view_cookbook.ViewCookbookPresenter;
import data_access.*;
import org.junit.Test;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

public class ViewCookbookTest {
    private static ViewCookbookController setUp() {
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

        ViewCookbookPresenter viewCookbookPresenter = new ViewCookbookPresenter(viewManagerModel, openCookbookViewModel, cookbookListViewModel);
        ViewCookbookInteractor viewCookbookInteractor = new ViewCookbookInteractor(viewCookbookDAO, viewCookbookPresenter);
        return new ViewCookbookController(viewCookbookInteractor);
    }

    @Test
    public void BasicTest(){
        ViewCookbookController viewCookbookController = setUp();
        viewCookbookController.execute("Tester");
        viewCookbookController.execute("Nooooo");
    }
}
