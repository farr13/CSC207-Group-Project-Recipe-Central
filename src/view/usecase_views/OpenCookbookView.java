package view.usecase_views;

import backend.service.back_to_menu.BackToMenuController;
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
import java.util.ArrayList;

public class OpenCookbookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "open cookbook";
    private final OpenCookbookViewModel openCookbookViewModel;
    private final SeeListCookbooksController seeListCookbooksController;
    private final DeleteRecipeController deleteRecipeController;
    private final BackToMenuController backToMenuController;
    //private final RenameCookbookController renameCookbookController;
    private final JButton mainMenu;
    private final JButton viewCookbooks;
    //private final JButton renameCookbook;
    private final JButton deleteRecipe;

    public OpenCookbookView(OpenCookbookViewModel openCookbookViewModel, SeeListCookbooksController seeListCookbooksController,
                            DeleteRecipeController deleteRecipeController, BackToMenuController backToMenuController) {
        this.openCookbookViewModel = openCookbookViewModel;
        this.seeListCookbooksController = seeListCookbooksController;
        this.deleteRecipeController = deleteRecipeController;
        this.backToMenuController = backToMenuController;
        //this.renameCookbookController = renameCookbookController;

        openCookbookViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(openCookbookViewModel.getState().getCookbookName());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        //Creating buttons and placing them is specific panels
        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        viewCookbooks = new JButton(OpenCookbookViewModel.COOKBOOK_LIST_BUTTON_LABEL);
        navigationPanel.add(viewCookbooks);
        mainMenu = new JButton(OpenCookbookViewModel.MAIN_MENU_BUTTON_LABEL);
        navigationPanel.add(mainMenu);

        JPanel editCookbookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        deleteRecipe = new JButton(OpenCookbookViewModel.DELETE_RECIPE_BUTTON_LABEL);
        editCookbookPanel.add(deleteRecipe);

        // Make Recipe Scroll panel
        ArrayList<String> recipesDescription = new ArrayList<String>();

        for (Triplet<String, String, String[]> recipe: openCookbookViewModel.getState().getRecipes()){
            recipesDescription.add("***" + recipe.getFirst() + "***");
            recipesDescription.add("Instructions Link: "+ recipe.getSecond());

            StringBuilder ingredients = new StringBuilder("Ingredients: ");
            for (String ingredientDescription: recipe.getThird())
                ingredients.append(ingredientDescription).append(",");
            recipesDescription.add(ingredients.toString());
        }

        JList<String> recipesFinal = new JList<String>(recipesDescription.toArray(new String[recipesDescription.size()]));
        JScrollPane scrollPane = new JScrollPane(recipesFinal);
        scrollPane.createHorizontalScrollBar();
        scrollPane.createVerticalScrollBar();

        //Create active listeners
        mainMenu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(mainMenu)) {
                            backToMenuController.execute();
                        }
                    }
                }
        );

        viewCookbooks.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(viewCookbooks)) {
                            seeListCookbooksController.execute();
                        }
                    }
                }
        );

        deleteRecipe.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteRecipe)) {
                            deleteRecipeController.execute(openCookbookViewModel.getState().getCookbookName(),
                                    convertToTriplet(recipesFinal.getSelectedValuesList().toArray(String[]::new)));
                        }
                    }
                }
        );

        //Adding components to this Jpanel
        this.add(scrollPane);
        this.add(editCookbookPanel);
        this.add(navigationPanel);
    }

    private Triplet<String, String, String[]>[] convertToTriplet(String[] selected){
        ArrayList<Triplet<String, String, String[]>> results = new ArrayList<Triplet<String, String, String[]>>();

        for (int i = 0; i < selected.length; i += 3){
            String line = selected[i];
            if (line.substring(0,3) == "***"){
                String name = line.substring(3, line.length()-3);
                String link = selected[i+1];
                String ingredientComma = selected[i+2];
                String[] ingredients = ingredientComma.split(",");
                results.add(new Triplet<>(name, link, ingredients));
            }
        }

        return results.toArray(Triplet[]::new);
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
