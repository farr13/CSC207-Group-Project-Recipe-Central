package view.recipe_objects;

import view.view_models.MainMenuViewModel;

import javax.swing.*;
import java.awt.*;

public class JRecipePanel extends JPanel {
    public JRecipePanel(Triplet<String, String, String[]> recipe){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(recipe.getFirst()));

        StringBuilder recipeDetails = new StringBuilder(recipe.getFirst() + "\nRecipe Link: " + recipe.getSecond() + "\n Ingredients: \n");
        for (String ingredientDescription: recipe.getThird()){
            recipeDetails.append("- ").append(ingredientDescription);
        }

        JTextArea descTextArea = new JTextArea(recipeDetails.toString());
        descTextArea.setEditable(false);
        descTextArea.setLineWrap(true);
        descTextArea.setWrapStyleWord(true);

        this.add(descTextArea, BorderLayout.CENTER);
    }
}
