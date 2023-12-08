package view.states;

public class OpenCookbookState {
    private String cookbookName = "";
    private String[] recipeBlocks = new String[]{};
    public OpenCookbookState(){}
    public void setCookbookName(String cookbookName) {
        this.cookbookName = cookbookName;
    }
    public void setRecipeBlocks(String[] recipeBlocks) {
        this.recipeBlocks = recipeBlocks;
    }
    public String getCookbookName() {
        return cookbookName;
    }
    public String[] getRecipeBlocks() {
        return recipeBlocks;
    }
}
