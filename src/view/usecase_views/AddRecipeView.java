package view.usecase_views;

import backend.service.add_recipe.AddRecipeController;
import backend.service.back_to_search.BackToSearchController;
import view.states.AddCookbookState;
import view.states.AddRecipeState;
import view.states.SearchResultState;
import view.view_managers.ViewManagerModel;
import view.view_models.AddCookbookViewModel;
import view.view_models.AddRecipeViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class AddRecipeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Add Recipe";
    public final ViewManagerModel viewManagerModel;
    public final AddRecipeViewModel addRecipeViewModel;
    public final AddRecipeController addRecipeController;
    public final BackToSearchController backToSearchController;
    private final JButton cancel;
    private final JButton add;
    private DefaultListModel<String> cookbookLst = new DefaultListModel<>();
    private DefaultListModel<String> selectedRecipesLst = new DefaultListModel<>();

    public AddRecipeView(ViewManagerModel viewManagerModel, AddRecipeViewModel addRecipeViewModel,
                         AddRecipeController addRecipeController, BackToSearchController backToSearchController) {
        this.viewManagerModel = viewManagerModel;
        this.addRecipeViewModel = addRecipeViewModel;
        this.addRecipeController = addRecipeController;
        this.backToSearchController = backToSearchController;

        addRecipeViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(AddRecipeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Shows view
        JPanel editCookbooks = new JPanel();
        editCookbooks.setLayout(new GridLayout(1,2));

        JPanel viewRecipePanel = new JPanel();
        JLabel recipeLabel = new JLabel("Recipes Selected:");
        JList<String> selectedRecipesJlist = new JList<>(selectedRecipesLst);
        JScrollPane recipesScrollPane = new JScrollPane(selectedRecipesJlist);
        viewRecipePanel.add(recipeLabel);
        viewRecipePanel.add(recipesScrollPane);

        JPanel viewCookbookPanel = new JPanel();
        JLabel cookbookLabel = new JLabel("Cookbooks:");
        JList<String> cookbookJlist = new JList<>(cookbookLst);
        JScrollPane cookbookScrollPane = new JScrollPane(cookbookJlist);
        viewCookbookPanel.add(cookbookLabel);
        viewCookbookPanel.add(cookbookScrollPane);

        editCookbooks.add(viewRecipePanel);
        editCookbooks.add(viewCookbookPanel);

        //Make buttons
        JPanel flowLayoutPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add = new JButton(AddCookbookViewModel.ADD_COOKBOOK_BUTTON_LABEL);
        flowLayoutPanel.add(add);
        cancel = new JButton(AddCookbookViewModel.VIEW_COOKBOOKS_BUTTON_LABEL);
        flowLayoutPanel.add(cancel);

        //Create active listeners
        add.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(add)) {
                            addRecipeController.execute(cookbookJlist.getSelectedValuesList().toArray(new String[0]),
                                    addRecipeViewModel.getState().getRecipesSelected());
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            backToSearchController.execute();
                        }
                    }
                }
        );

        //Adding all components to this Jpanel
        this.add(title);
        this.add(editCookbooks);
        this.add(flowLayoutPanel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddRecipeState state = (AddRecipeState) evt.getNewValue();
        String[] recipes = state.getRecipesSelected();
        if (recipes != null){
            selectedRecipesLst.clear();
            for(String recipe: recipes){
                selectedRecipesLst.addElement(recipe);
            }
        }
        String[] cookbookNames = state.getCookbookNames();
        if (cookbookNames != null){
            cookbookLst.clear();
            for(String cookbookName: cookbookNames){
                cookbookLst.addElement(cookbookName);
            }
        }
    }
}
