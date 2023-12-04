package view.states;

import java.util.ArrayList;

public class SearchResultState {
    private String[] recipeLst = {};

    public SearchResultState(SearchResultState copy) {
        recipeLst = copy.recipeLst;
    }
    public SearchResultState(){
    }

    public String[] getRecipeLst() {return recipeLst;}

    public void setRecipeLst(String[] recipeLst) {this.recipeLst = recipeLst;}

}
