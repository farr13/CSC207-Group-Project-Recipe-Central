package view.states;

import backend.entity.Recipe;

public class SearchResultState {
    private Recipe[] recipeLst = {};

    public SearchResultState(SearchResultState copy) {
        recipeLst = copy.recipeLst;
    }
    public SearchResultState(){
    }

    public Recipe[] getRecipeLst() {return recipeLst;}

    public void setRecipeLst(Recipe[] recipeLst) {this.recipeLst = recipeLst;}

}
