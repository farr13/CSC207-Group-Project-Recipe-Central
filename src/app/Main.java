package app;

import data_access.*;
import view.usecase_views.MainMenuView;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.MainMenuViewModel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // The main application window.
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel view = new JPanel(cardLayout);
        view.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(view, BorderLayout.CENTER);

        //This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(view, cardLayout, viewManagerModel);

        //Creating data access objects
        AddCookbookDAO addCookbookDAO = new AddCookbookDAO("saved_data.json");
        AddRecipeDAO addRecipeDAO = new AddRecipeDAO("saved_data.json");
        DeleteCookbookDAO deleteCookbookDAO = new DeleteCookbookDAO("saved_data.json");
        DeleteRecipeDAO deleteRecipeDAO = new DeleteRecipeDAO("saved_data.json");
        ViewCookbookDAO viewCookbookDAO = new ViewCookbookDAO("saved_data.json");

        //Making View Models
        MainMenuViewModel mainMenuViewModel = new MainMenuViewModel("Main Screen");

        //Making Views
        MainMenuView mainMenuView = MainMenuUseCaseFactory.create(mainMenuViewModel, viewCookbookDAO);
        view.add(mainMenuView);

        //Final Steps
        viewManagerModel.setActiveView(mainMenuView.viewName);
        viewManagerModel.firePropertyChanged();

        frame.pack();
        frame.setVisible(true);
    }
}
