package view.states;

import backend.entity.Recipe;

import javax.swing.*;
import java.util.ArrayList;

public class SearchResultState {
    private ArrayList<String> recipeLst = new ArrayList<>();

    public SearchResultState(SearchResultState copy) {
        recipeLst = copy.recipeLst;
    }
    public SearchResultState(){
    }

    public ArrayList<String> getRecipeLst() {return recipeLst;}

    public void setRecipeLst(ArrayList<String> recipeLst) {this.recipeLst = recipeLst;}

}
