package view.usecase_views;

import backend.service.make_cookbook.MakeCookbookController;
import backend.service.see_list_cookbooks.SeeListCookbooksController;
import view.states.AddCookbookState;
import view.view_managers.ViewManagerModel;
import view.view_models.AddCookbookViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class AddCookbookView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Add Cookbook";
    public final ViewManagerModel viewManagerModel;
    public final AddCookbookViewModel addCookbookViewModel;
    public final MakeCookbookController makeCookbookController;
    public final SeeListCookbooksController seeListCookbooksController;
    private final JButton cancel;
    private final JButton add;
    private final JTextField nameInputField = new JTextField(30);

    public AddCookbookView(ViewManagerModel viewManagerModel, AddCookbookViewModel addCookbookViewModel,
                           MakeCookbookController makeCookbookController, SeeListCookbooksController seeListCookbooksController) {
        this.viewManagerModel = viewManagerModel;
        this.addCookbookViewModel = addCookbookViewModel;
        this.makeCookbookController = makeCookbookController;
        this.seeListCookbooksController = seeListCookbooksController;

        addCookbookViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(AddCookbookViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Make input cookname panel
        JPanel inputNameSection = new JPanel();
        JLabel inputNameLabel = new JLabel("Cookbook Name: ");
        inputNameSection.add(inputNameLabel);
        inputNameSection.add(nameInputField);

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
                            makeCookbookController.execute(nameInputField.getText());
                        }
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            seeListCookbooksController.execute();
                        }
                    }
                }
        );

        //Adding all components to this Jpanel
        this.add(title);
        this.add(inputNameSection);
        this.add(flowLayoutPanel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        AddCookbookState state = (AddCookbookState) evt.getNewValue();
        nameInputField.setText("");

        JFrame frame = new JFrame(state.getErrorMessage());
        if (Objects.equals(state.getErrorMessage(), "Invalid Name"))
            JOptionPane.showMessageDialog(frame, ("Please use a different name for the new cookbook."));
    }
}
