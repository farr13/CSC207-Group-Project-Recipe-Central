package view.usecase_views;

import backend.service.delete_recipe.DeleteRecipeController;
import backend.service.rename_cookbook.RenameCookbookController;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import view.recipe_objects.JRecipePanel;
import view.recipe_objects.Triplet;
import view.states.OpenCookbookState;
import view.view_models.CookbookListViewModel;
import view.view_models.MainMenuViewModel;
import view.view_models.OpenCookbookViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OpenCookbookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "open cookbook";

    private final MainMenuViewModel mainMenuViewModel;
    private final OpenCookbookViewModel openCookbookViewModel;
    private final CookbookListViewModel cookbookListViewModel;
    private final SeeListCookbooksController seeListCookbooksController;
    private final DeleteRecipeController deleteRecipeController;
    //private final RenameCookbookController renameCookbookController;
    private final JButton mainMenu;
    private final JButton viewCookbooks;
    private final JButton renameCookbook;
    private final JButton deleteRecipe;

    public OpenCookbookView(MainMenuViewModel mainMenuViewModel, OpenCookbookViewModel openCookbookViewModel,
                            CookbookListViewModel cookbookListViewModel, SeeListCookbooksController seeListCookbooksController,
                            DeleteRecipeController deleteRecipeController) {
        this.mainMenuViewModel = mainMenuViewModel;
        this.openCookbookViewModel = openCookbookViewModel;
        this.cookbookListViewModel = cookbookListViewModel;
        this.seeListCookbooksController = seeListCookbooksController;
        this.deleteRecipeController = deleteRecipeController;
        //this.renameCookbookController = renameCookbookController;

        openCookbookViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(openCookbookViewModel.getState().getCookbookName());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Creating buttons and placing them is specific panels
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        viewCookbooks = new JButton(OpenCookbookViewModel.COOKBOOK_LIST_BUTTON_LABEL);
        navigationPanel.add(viewCookbooks);
        mainMenu = new JButton(OpenCookbookViewModel.MAIN_MENU_BUTTON_LABEL);
        navigationPanel.add(mainMenu);

        JPanel editCookbookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        deleteRecipe = new JButton(OpenCookbookViewModel.DELETE_RECIPE_BUTTON_LABEL);
        editCookbookPanel.add(deleteRecipe);
        renameCookbook = new JButton(OpenCookbookViewModel.RENAME_RECIPE_BUTTON_LABEL);
        editCookbookPanel.add(renameCookbook);

        // Make Recipe Scroll panel
        JScrollPane recipeScrollPanel = new JScrollPane();
        for (Triplet recipe: openCookbookViewModel.getState().getRecipes())
            recipeScrollPanel.add(new JRecipePanel(recipe));

        this.add(title);
        this.add(recipeScrollPanel);
        this.add(editCookbookPanel);
        this.add(navigationPanel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property changed method called");
    }
}
