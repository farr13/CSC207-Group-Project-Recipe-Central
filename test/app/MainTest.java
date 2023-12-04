package app;

import data_access.*;
import org.junit.Test;
import view.usecase_views.*;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void mainTest() {
        // The main application window.
        JFrame frame = new JFrame("Recipe Central");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setLayout(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);

        //This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);

        //Creating data access objects
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("test.json");
        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("test.json");
        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("test.json");
        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("test.json");
        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("test.json");
        ViewRecipeDAO viewRecipeDAO = new ViewRecipeDAO("test.json");

        //Making View Models
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel();
        CookbookListViewModel cookbookListViewModel = new CookbookListViewModel();
        OpenCookbookViewModel openCookbookViewModel = new OpenCookbookViewModel();
        SearchResultViewModel searchResultViewModel = new SearchResultViewModel();
        AddRecipeViewModel addRecipeViewModel = new AddRecipeViewModel();
        AddCookbookViewModel addCookbookViewModel = new AddCookbookViewModel();

        //Making Views
        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(
                viewManagerModel, mainMenuViewModel,
                searchResultViewModel, cookbookListViewModel,
                viewCookbookDAO);
        view.add(mainMenuView, mainMenuView.viewName);

        CookbookListView cookbookListView = CookbookListUseCaseFactory.create(
                viewManagerModel, mainMenuViewModel,
                cookbookListViewModel, openCookbookViewModel, addCookbookViewModel,
                viewCookbookDAO, deleteCookbookDAO);
        view.add(cookbookListView, cookbookListView.viewName);

        OpenCookbookView openCookbookView = OpenCookbookViewUseCaseFactory.create(
                viewManagerModel, openCookbookViewModel,
                cookbookListViewModel, mainMenuViewModel,
                viewCookbookDAO, deleteRecipeDAO, viewRecipeDAO);
        view.add(openCookbookView, openCookbookView.viewName);

        SearchResultView searchResultsView = SearchResultUseCaseFactory.create
                (searchResultViewModel,
                        addRecipeViewModel,
                        mainMenuViewModel,
                        viewManagerModel,
                        viewCookbookDAO);
        view.add(searchResultsView, searchResultsView.viewName);

        AddCookbookView addCookbookView = AddCookbookUseCaseFactory.create(
                viewManagerModel,
                cookbookListViewModel,
                addCookbookViewModel,
                addCookbookDAO,
                viewCookbookDAO);
        view.add(addCookbookView, addCookbookView.viewName);

        AddRecipeView addRecipeView = AddRecipeUseCaseFactory.create(
                viewManagerModel,
                addRecipeViewModel,
                searchResultViewModel,
                addRecipeDAO);
        view.add(addRecipeView, addRecipeView.viewName);

        //Final Steps
        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
}