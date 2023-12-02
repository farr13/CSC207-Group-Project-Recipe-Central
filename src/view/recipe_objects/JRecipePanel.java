package view.recipe_objects;

import view.view_models.MainMenuViewModel;

import javax.swing.*;

public class JRecipePanel extends JPanel {
    public JRecipePanel(Triplet<String, String, String[]> recipe){
        this.setBorder(BorderFactory.createTitledBorder(recipe.getFirst()));

        JLabel intructionsURL = new JLabel("Recipe Link: " + recipe.getSecond());
        this.add(intructionsURL);

        JList<String> ingredients = new JList<>(recipe.getThird());
        JScrollPane ingredientsPanel = new JScrollPane(ingredients);
        ingredientsPanel.add(ingredients);
        this.add(ingredientsPanel);
    }
}
