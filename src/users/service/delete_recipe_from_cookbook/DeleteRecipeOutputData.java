package users.service.delete_recipe_from_cookbook;

public class DeleteRecipeOutputData {
    private final boolean success;
    private final String message;

    public DeleteRecipeOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
