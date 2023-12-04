package backend.service;

import backend.service.go_add_cookbook.GoAddCookbookController;
import backend.service.go_add_cookbook.GoAddCookbookInteractor;
import backend.service.go_add_cookbook.GoAddCookbookPresenter;
import backend.service.go_add_recipe.GoAddRecipeController;
import backend.service.go_add_recipe.GoAddRecipeInteractor;
import backend.service.go_add_recipe.GoAddRecipePresenter;
import data_access.*;
import org.junit.Test;
import view.view_managers.ViewManager;
import view.view_managers.ViewManagerModel;
import view.view_models.*;

import javax.swing.*;
import java.awt.*;

public class GoAddRecipeTest {
    private static GoAddRecipeController setUp() {
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

        GoAddRecipePresenter goAddRecipePresenter = new GoAddRecipePresenter(viewManagerModel, addRecipeViewModel, searchResultViewModel);
        GoAddRecipeInteractor goAddRecipeInteractor = new GoAddRecipeInteractor(goAddRecipePresenter, viewCookbookDAO);
        return new GoAddRecipeController(goAddRecipeInteractor);
    }

    @Test
    public void BasicTest(){
        GoAddRecipeController goAddRecipeController = setUp();
        goAddRecipeController.execute(new String[]{"Recipe_name_dddd_link_dddd_ingredients_"});
        goAddRecipeController.execute(new String[]{});
    }
}
