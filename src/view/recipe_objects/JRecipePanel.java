package view.recipe_objects;

import javax.swing.*;

public class JRecipePanel extends JPanel {
    public JRecipePanel(Triplet recipe){
        this.setBorder(BorderFactory.createTitledBorder(recipe.getName()));
        JLabel instructions = new JLabel("Recipe Link: " + recipe.getLink());
        this.add(instructions);
        JList<String> ingredients = new JList<>(recipe.getList());
        this.add(ingredients);
    }
}
