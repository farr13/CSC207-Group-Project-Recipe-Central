package users.service.rename_cookbook;

public class RenameCookbookOutputData {
    private final boolean success;
    private final String message;

    public RenameCookbookOutputData(boolean success, String message) {
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
