package view.recipe_objects;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
public class JLabelTextPanel extends JPanel {
    public JLabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
