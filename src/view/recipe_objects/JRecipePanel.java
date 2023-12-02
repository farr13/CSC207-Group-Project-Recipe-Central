package view.recipe_objects;

import view.view_models.MainMenuViewModel;

import javax.swing.*;

public class JRecipePanel extends JPanel {
    public JRecipePanel(Triplet recipe){
        this.setBorder(BorderFactory.createTitledBorder(recipe.getName()));

        JLabel intructionsURL = new JLabel("Recipe Link: " + recipe.getLink());
        this.add(intructionsURL);

        JList<String> ingredients = new JList<>(recipe.getList());
        JScrollPane ingredientsPanel = new JScrollPane(ingredients);
        ingredientsPanel.add(ingredients);
        this.add(ingredientsPanel);
    }
}
