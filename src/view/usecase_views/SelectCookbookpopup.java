package view.usecase_views;

import view.view_models.SearchResultViewModel;
import view.view_models.SelectCookbookpopupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SelectCookbookpopup extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Select Cookbook";

    private final SelectCookbookpopupViewModel selectCookbookpopupViewModel;
    private final JButton cancel;

    public SelectCookbookpopup(SelectCookbookpopupViewModel selectCookbookpopupViewModel){
        this.selectCookbookpopupViewModel = selectCookbookpopupViewModel;
        selectCookbookpopupViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SelectCookbookpopupViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JList<String> cookbookLst = new JList<>(SelectCookbookpopupViewModel.COOKBOOKS);

        JScrollPane scrollPane = new JScrollPane(cookbookLst);

        cancel = new JButton(SelectCookbookpopupViewModel.CANCEL_BUTTON);

        JPanel flowLayoutPanel = new JPanel(new FlowLayout());
        flowLayoutPanel.add(cancel);

        cancel.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(cancel)) {
                            System.out.println("Not Implemented Yet");
                        }
                    }
                }
        );

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel " +
                "not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
