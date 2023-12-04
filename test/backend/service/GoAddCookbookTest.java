package backend.service;

import backend.service.back_to_menu.BackToMenuController;
import backend.service.back_to_menu.BackToMenuInteractor;
import backend.service.back_to_menu.BackToMenuPresenter;
import backend.service.go_add_cookbook.GoAddCookbookController;
import backend.service.go_add_cookbook.GoAddCookbookInteractor;
import backend.service.go_add_cookbook.GoAddCookbookPresenter;
import org.junit.Test;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

public class GoAddCookbookTest {
    private static GoAddCookbookController setUp() {
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

        GoAddCookbookPresenter goAddCookbookPresenter = new GoAddCookbookPresenter(viewManagerModel, addCookbookViewModel);
        GoAddCookbookInteractor goAddCookbookInteractor = new GoAddCookbookInteractor(goAddCookbookPresenter);
        return new GoAddCookbookController(goAddCookbookInteractor);
    }

    @Test
    public void BasicTest(){
        GoAddCookbookController goAddCookbookController = setUp();
        goAddCookbookController.execute();
    }
}
